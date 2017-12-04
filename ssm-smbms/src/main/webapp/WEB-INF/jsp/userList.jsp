<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="frm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="/statics/css/public.css"/>
    <link rel="stylesheet" href="/statics/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="/statics/js/jquery-easyui-1.2.6/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/statics/js/jquery-easyui-1.2.6/themes/icon.css">
    <style>
        #dd form div{
            margin-top: 7px;
        }
    </style>


</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b">${sessionScope.user.userName}</span> , 欢迎你！</p>
        <a href="/user/doLogout">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="billList.html">账单管理</a></li>
                <li><a href="providerList.html">供应商管理</a></li>
                <li  id="active"><a href="${pageContext.request.contextPath}/jsp/userList.jsp">用户管理</a></li>
                <li><a href="password.html">密码修改</a></li>
                <li><a href="login.html">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面</span>
        </div>
        <div class="search">
            <form id="form1"  method="post">
                <span>用户名：</span>
                <input type="text" name="userName"  placeholder="请输入用户名"/>
                <input type="button" id="btnSelect" value="查询"/>
            </form>
        </div>
        <!--用户-->

        <table id="test">
        </table>

    </div>
</section>
<footer class="footer">
</footer>

<div  id="dd" style="width:700px;padding:30px 60px;font-size: 17px;">
    <form id="form2" onsubmit="return validateUser()">
        <div>
            <label for="userId">用户编码：</label>
            <input type="text"  name="userCode" id="userId"/>
            <span id="userIdMsg"></span>
        </div>
        <div>
            <label for="userName">用户名称：</label>
            <input type="text" class="easyui-textbox" name="userName" id="userName"/>
            <span >*请输入用户名称</span>
        </div>
        <div>
            <label for="userpassword">用户密码：</label>
            <input type="text" class="easyui-textbox" name="userPassword" id="userpassword"/>
            <span>*密码长度必须大于6位小于20位</span>

        </div>
        <div>
            <label for="userRemi">确认密码：</label>
            <input type="text" class="easyui-textbox"  id="userRemi"/>
            <span>*请输入确认密码</span>
        </div>
        <div>
            <label >用户性别：</label>

            <select name="gender">
                <option value="1">男</option>
                <option value="0">女</option>
            </select>
            <span></span>
        </div>
        <div>
            <label for="data">出生日期：</label>
            <input type="text" name="birthday" id="data" class="easyui-datebox"/>
            <span >*</span>
        </div>
        <div>
            <label for="userphone">用户电话：</label>
            <input type="text" class="easyui-textbox" name="phone" id="userphone"/>
            <span >*</span>
        </div>
        <div>
            <label for="userAddress">用户地址：</label>
            <input type="text" class="easyui-textbox" name="address" id="userAddress"/>
        </div>
        <div>
            <label id="roleName">用户类别：</label>
            <input type="radio" name="userType"  value="0"/>管理员
            <input type="radio" name="userType"  value="1"/>经理
            <input type="radio" name="userType"  value="2"/>普通用户

        </div>
    </form>
</div>

<script type="text/javascript" src="/statics/js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/statics/js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/statics/js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
    //数据校验
    function validateUser(){
        var userid=$("#userId").val();
        if(userid==""){
            $("#userIdMsg").html('*请输入用户编码');
            return false;
        }
        return true;
    }
    function init() {
        $('#test').datagrid({
            title:'用户管理',
            iconCls:'icon-save',
            width:'100%',
            height:450,
            nowrap: true,
            striped: true,
            url:'/userListByPage?userName='+$("[name=userName]").val(),
            sortName: 'code',
            sortOrder: 'desc',
            idField:'id',
            pageList: [2, 5, 15, 20],
            frozenColumns:[[
                {field:'ck',checkbox:true},
                { field: 'id', width: 50, hidden: true },
                {title:'用户编码',field:'userCode',width:80,sortable:true}
            ]],
            columns:[[ //列配置对象
                {field:'userName',title:'用户名称',width:200},
                {field:'gender',title:'性别',width:200,
                    formatter:function(value){
                        if(value==1){
                            return "男";
                        }else{
                            return "女";
                        }
                    }
                },
                {field:'birthday',title:'年龄',width:200,
                    formatter:function(value){
                        return jsGetAge(value);
                    }
                },
                {field:'phone',title:'电话',width:200},
                {field:'userType',title:'用户类型',width:200,
                    formatter:function(value){
                        if(value==1){
                            return "管理员";
                        }else if(value==2){
                            return "员工";
                        }else{
                            return "经理";
                        }
                    }
                }
            ]],
            pagination:true, //rows: 每页显示的数据量 page:第几页
            rownumbers:true,
            singleSelect:false,
            toolbar:[{
                text:'添加用户',
                iconCls:'icon-add',
                handler:function(){
                    open1();
                }
            },{
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
            },{
                text:'导出excel表格',
                iconCls:'icon-excel',
                disabled:false,
                handler:function(){
                    openUserModifyDialog();
                }
            }
            ]
        });
    }
    $(function(){
        init();
        //模糊查询
        $("#btnSelect").click(function () {
            init();
        });
      var url;
        $('#dd').dialog({
           title:'添加用户',
            collapsible:false,
            resizable:true,
           // 小弹层的OK
            buttons:[{
                text:'保存',
                iconCls:'icon-ok',
                handler:function(){
                    saveData();
                }
            }, {
                text:'取消',
                handler:function(){
                    $('#dd').dialog('close');
                }
            }],

        });
        $('#dd').dialog('close');
    }) ;

    //添加
    function open1(){
            url="/addUser";
        $('#dd').dialog('open');
    }
    function saveData() {
        if(validateUser()){
            $.ajax({
                url:url,
                type:"post",
                data:$("#form2").serialize(),
                success:function (data) {
                    if(data==true){
                        alert('保存成功');
                        resetValue();
                        $("#test").datagrid("reload");
                    }else{
                        alert('保存失败');
                    }
                    $('#dd').dialog('close');
                }
            });
        }
    }
    function jsGetAge(strBirthday) {
        var returnAge;
        var strBirthdayArr=strBirthday.split("-");
        var birthYear = strBirthdayArr[0];
        var birthMonth = strBirthdayArr[1];
        var birthDay = strBirthdayArr[2];
        var d = new Date();
        var nowYear = d.getFullYear();
        var nowMonth = d.getMonth() + 1;
        var nowDay = d.getDate();
        if(nowYear == birthYear){
            returnAge = 0;//同年 则为0岁
        }else{
            var ageDiff = nowYear - birthYear ; //年之差
            if(ageDiff > 0){
                if(nowMonth == birthMonth){
                    var dayDiff = nowDay - birthDay;//日之差
                    if(dayDiff < 0){
                        returnAge = ageDiff - 1;
                    }else{
                        returnAge = ageDiff ;
                    }
                }else{
                    var monthDiff = nowMonth - birthMonth;//月之差
                    if(monthDiff < 0){
                        returnAge = ageDiff - 1;
                    } else{
                        returnAge = ageDiff ;
                    }
                } }else{
                returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天
            }
        }
        return returnAge;//返回周岁年龄
    }
    function  doDelete() {
        var selectRows = $("#test").datagrid("getSelections");
        if (selectRows!=0) {
            //提示用户是否真的删除数据
            $.messager.confirm("确认消息", "您确定要删除此信息么？", function (r) {
                if (r) {
                    var strIds = "";
                    for (var i = 0; i < selectRows.length; i++) {
                        strIds += selectRows[i].id + ",";
                    }
                    strIds = strIds.substr(0, strIds.length - 1);
                    //alert(strIds);
                    $.post("/delUser", {ids: strIds}, function (data) {
                        if (data == true) {
                            $("#test").datagrid("reload");
                            $("#test").datagrid("clearSelections");
                        } else {
                            $.messager.alert("删除失败", data);
                        }
                    })
                }
            })
        }else{
            $.messager.alert("系统提示","请选择一条要编辑的数据！");
            return;
        }
    }

    //修改用户信息

    function openUserModifyDialog(){
        var selectedRows = $("#test").datagrid("getSelections");
        if (selectedRows.length!=1){
            $.messager.alert("系统提示","请选择一条要编辑的数据！");
            return;
        }
        var row = selectedRows[0];
        $("#dd").dialog("open").dialog("setTitle","编辑用户信息");
        $("#form2").form("load",row);
        //alert(row.id);
        url ="/updateUser?id="+row.id;
    }
    //修改后清空输入框内的内容
    function resetValue() {
        $("#userId").val("");
        $("#userName").val("");
        $("#userpassword").val("");
        $("#gender").val("");
        $("#data").val("");
        $("#userphone").val("");
        $("#roleName").val("");
        $("#userRemi").val("");
        $("#userAddress").val("");
        //清除学则的样式
        $("#test").datagrid("clearSelections");

    }



</script>



</body>

</html>