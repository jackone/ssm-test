<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%--<%@taglib prefix="我是狗" uri="http://www.springsecurity.org/jsp"%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
    window.onload=function () {
        init();

    };
    function init() {
        $('#test').datagrid({
            title:'用户管理',
            iconCls:'icon-save',
            fit:true,
            nowrap: true,
            striped: true,
            url:'${pageContext.request.contextPath}/user/selectUser?userName='+$("[name=userName]").val(),
           sortName: 'code',
           sortOrder: 'desc',
            idField:'rid',
			pageSize:2,
            pageList: [2, 5,10, 15, 20],
            frozenColumns:[[
                {field:'ck',checkbox:true},
                {title:'用户编码',field:'userId',width:80,sortable:true}
            ]],
            columns:[[
                {field:'userName',title:'用户名称',width:200},
                {field:'action',title:'操作',width:200, formatter: formatAction 	}
            ]],
            pagination:true, //研究：rows: 每页显示的数据量 page:第几页
            rownumbers:true,
            singleSelect:true,
            fitColumns:true,
            toolbar:[{
                text:'添加角色',
                iconCls:'icon-add',
                handler:function(){
                    open1();
                }
            }]
        });
    }
    var row ;
	function searchTask(){
		$("#dg").datagrid('load',{
			"s_name":$("#s_name").val()
		});
	}
	function formatAction(){
		return "<a href='javascript:openListActionDialog()'>分配权限</a>";
	}
		function openListActionDialog(){
	       //1.获取当前选中行对象  row整行对象
            row=$('#test').datagrid('getSelected');
            $("#tt").tree({
                url: '${pageContext.request.contextPath}/user/getAllMenusJson',
                animate:true,
                cascadeCheck:false,
                checkbox:true,
                loadFilter ://过滤数据
                    function(data) { //data;从Server端响应回来的数据
                        change(data);
                        //图标的设定
                        $.each(data,function (i,v){
                            v.iconCls="icon-folder";
                        });
                        return data;
                    },
                //在内存中已经装配出一个有层级关系的节点树，默认所有节点都没有被选中
                onLoadSuccess:function () {
                   /* var root=$("#tt").tree('getRoot');
                    $("#tt").tree('uncheck',root.target);*/
                    $.ajax({
                        type: "post",
                        url: "${pageContext.request.contextPath}/user/getPrivilegeJson",
                        data:{"rid":row['rid']},
                        dataType: "json",
                        success: function(data){
                            $.each(data,function (i,dom) { //用户拥有的一个权限对象

                                //dom就是一个权限对象
                                //通过find方法寻址数上应该被勾选的节点对象，然后将其选中
                                var checkedNode = $('#tt').tree('find', dom.id);
                                $('#tt').tree('check', checkedNode.target);
                            });
                        }
                    });



                    /*var checkedNode = $('#tt').tree('find', 1);//找到id为”tt“这个树的节点id为”1“的对象
                    $('#tt').tree('check', checkedNode.target);
                    var children = $('#tt').tree('getChildren', checkedNode.target);*/

                }
            });

            /*var node = $('#tt').tree('find', 1);//找到id为”tt“这个树的节点id为”1“的对象
         $('#tt').tree('select', node.target);//设置选中该节点*/
            $("#dlg3").dialog("open").dialog("setTitle","分配权限2");

	};
	$(function () {

    });
    //读懂：工具来用
    function change(data){
        if(!data.length){
            data.text=data.name;
            if(data.children){
                change(data.children);
            }
        }else{
            $.each(data,function (i,v){
                change(v);
            });
        }
    }

    function getChecked(){
        var nodes = $('#tt').tree('getChecked');
        var s = '';  //1,2,3,4
        for(var i=0; i<nodes.length; i++){
            if (s != '') s += ',';
            s += nodes[i].id;
        }
        alert(s);
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/user/savePrivilege",
            data:{"rid":row['rid'],"s":s},
            success:function () {
                $("#dlg3").dialog("close");
            }
        })
        //关闭弹层

    }
</script>
</head>
<body style="margin: 1px">
<%--<我是狗:authorize URL="/role/addRole">
   <a href="/role/addRole">添加角色</a>
</我是狗:authorize>--%>
<table id="test">

</table>

<div id="dlg3" class="easyui-dialog" style="width: 350px;height: 500px;padding: 10px 20px" closed="true" >
   分配权限：
   <ul id="tt"></ul>
   <a href="#" class="easyui-linkbutton" onclick="getChecked()">保存权限</a>
</div>

</body>
</html>