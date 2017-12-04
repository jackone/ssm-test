<%@ page isELIgnored="false"  pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/js/js/bootstrap/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/js/jQuery1.11.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/js/jquery.pagination.js"></script>
    <script type="text/javascript">
        jQuery.noConflict();

        jQuery(function ($) {
            load(1,2);
            function load(pageIndex,pageSize) {
                $.ajax({
                    url:"/userListByPage1",
                    type:"POST",
                    data:{"pageIndex":pageIndex,"pageSize":pageSize},
                    success:function (data) {
                        //
                        //清除tbody中的文本内容
                        $("#tbColumns").html('');
                        $.each(data.list,function (i,dom) {  //一个个的UserInfo对象 json格式存储的
                            var str="<tr><td>"+dom.userCode+"</td><td>"+dom.userName+"</td></tr>";
                            $("#tbColumns").append(str);
                        });

                        //渲染分页页码条    条数：整张表的记录数
                        $('#pagination').pagination(data.totalCount, {
                            current_page : data.pageIndex,
                            items_per_page : data.pageSize,
                            num_display_entries : 3,
                            load_first_page : true,
                            prev_text : '上一页',
                            next_text : '下一页'
                        });
                    }
                });
            }
        });
    </script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="login.html">退出</a>
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
                <li  id="active"><a href="userList.html">用户管理</a></li>
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
            <span>用户名：</span>
            <input type="text" placeholder="请输入用户名" name="userName"/>
            <input type="button" value="查询"/>
            <a href="userAdd.html">添加用户</a>
        </div>
        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">用户编码</th>
                <th width="20%">用户名称</th>
                <th width="10%">性别</th>
                <th width="10%">年龄</th>
                <th width="10%">电话</th>
                <th width="10%">用户类型</th>
                <th width="30%">操作</th>
            </tr>
            <tbody id="tbColumns">

            </tbody>

        </table>
        <div class="pagination" id="pagination" style="margin:4px 0 0 0"></div>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<footer class="footer">
    版权归北大青鸟
</footer>

<script src="/statics/js/jquery.js"></script>
<script src="/statics/js/js.js"></script>
<script src="/statics/js/time.js"></script>

</body>
</html>