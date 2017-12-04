<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        window.onload=function () {
            init();


        }; //读懂：工具来用

        //模糊查询
        $("#btnSelect").click(function () {
            init();
        });
        function change(data){
            if(!data.length){
                data.id=data.syscode;
                data.text=data.columnname;
                if(data.children){
                    change(data.children);
                }
            }else{
                $.each(data,function (i,v){
                    change(v);
                });
            }
        }
        var checkNode=$("#tt").tree("getChecked");
        function init() {
            var row ;
            //1.获取当前选中行对象  row整行对象


            $("#tt").tree({
                url: '${pageContext.request.contextPath}/column/getAllMenusJson',
                animate:true,
                cascadeCheck:false,
               // checkbox:true,
                loadFilter ://过滤数据
                    function(data) { //data;从Server端响应回来的数据
                        change(data);
                        //图标的设定
                        $.each(data,function (i,v){
                            v.iconCls="icon-folder";
                        });
                        return data;
                    },

                onClick:function (checkNode) {
                    showcontent(checkNode)
                }
            });

            function  showcontent(checkNode){
                $('#column').datagrid({
                    title:checkNode.text,
                    iconCls:'icon-save',
                    //fit:true,
                    //nowrap: true,
                    //striped: true,
                    url:'${pageContext.request.contextPath}/column/selectNews?columntype='+checkNode.id,
                    //sortName: 'code',
                    //sortOrder: 'desc',
                    idField:'information_code',
                    pageSize:2,
                    pageList: [2, 5,10, 15, 20],
                    frozenColumns:[[
                        {field:'ck',checkbox:true},
                        {title:'编号',field:'information_code',width:80,sortable:true},
                        {title:'标题',field:'title',width:80,sortable:true}
                    ]],
                    columns:[[
                        {field:'image_url',title:'图片路径',width:200},
                        {field:'primaryword',title:'关键字',width:200},
                        {field:'summary',title:'标题',width:200},
                        {field:'content',title:'内容',width:200}
                    ]],
                    pagination:true, //研究：rows: 每页显示的数据量 page:第几页
                    rownumbers:true,
                    singleSelect:false,
                    //fitColumns:true,



                    toolbar:[{
                        text:'<input type="text" id="title" placeholder="请输入标题"></input>'
                    },{
                        text:'查询',
                        iconCls:'icon-search',
                        handler:function(){
                            findMess();
                        }
                    },
                        {
                        id: 'btnDelete',
                        text:'批量删除',
                        iconCls:'icon-remove',
                        disabled:false,
                        handler:function(){
                            doDelete();
                        }
                    },{
                        text:'修改',
                        iconCls:'icon-edit',
                        disabled:false,
                        handler:function(){
                            openUserModifyDialog();
                        }
                    }]
                });
            }




        }


        function findMess(){
            $("#column").datagrid('load', {
                "title" : $("#title").val()
            });
            // alert($("#title").val());
            /*$.ajax({
                url:"/news/findNewsByColumn",
                data:{"title":$("#title").val()}
            })*/
        }



    </script>


</head>
<body>
  <div class="easyui-layout" style="width:1127px;height:680px;">
    <div region="west" split="true" title="内容发布" style="width:270px;">
        <ul id="tt"></ul>
    </div>
    <div id="content" region="center" title="栏目列表" style="padding:5px;">
        <a href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        <a href="/page/column/articleForm.jsp" class="easyui-linkbutton" iconCls="icon-add">新增</a>
           <%--<div class="search">
               <form id="form1"  method="post">
                   <span>用户名：</span>
                   <input type="text" name="title"  placeholder="请输入标题"/>
                   <input type="button" id="btnSelect" value="查询"/>
               </form>
           </div>--%>
           <table id="column"></table>
    </div>
   </div>
</body>
</html>
