<%--
  Created by IntelliJ IDEA.
  User: wang
  Date: 2020/5/24
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改管理员</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改管理员</h3>
    <form action="${pageContext.request.contextPath}/user/update.do" method="post">
        <!--  隐藏域 提交id-->
        <input type="hidden" name="userid" id="userid" value="${user.userid}">

        <div class="form-group">
            <label for="username">用户名：</label>
            <input type="text" class="form-control" id="username" name="username" value="${user.username}"
                   readonly="readonly" placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${user.gender == '男'}">
                <input type="radio" name="gender" value="男" checked/>男
                <input type="radio" name="gender" value="女"/>女
            </c:if>

            <c:if test="${user.gender == '女'}">
                <input type="radio" name="gender" value="男"/>男
                <input type="radio" name="gender" value="女" checked/>女
            </c:if>


        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" value="${user.age}" id="age" name="age" placeholder="请输入年龄"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" value="${user.email}" name="email"
                   placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group">
            <label for="oldpassword">原密码</label>
            <input type="password" id="oldpassword" class="form-control" name="oldpassword" placeholder="请输入原密码">
        </div>

        <div class="form-group">
            <label for="password">新密码：</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入新密码"/>
        </div>


        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <a href="${pageContext.request.contextPath}/findUserByPageServlet"> <input class="btn btn-default"
                                                                                       type="button" value="返回"/></a>
        </div>


        <div class="alert alert-info" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <div class="text-center">
                <strong class="update_msg">${update_msg}</strong><span class="update_msg">请仔细核对原密码输入！</span>
            </div>
        </div>


    </form>
</div>
</body>
</html>
