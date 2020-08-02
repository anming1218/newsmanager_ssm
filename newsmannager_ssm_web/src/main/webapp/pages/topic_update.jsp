<%--
  Created by IntelliJ IDEA.
  User: wang
  Date: 2020/5/24
  Time: 22:46
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
    <title>修改主题</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改主题</h3>
    <form action="${pageContext.request.contextPath}/topic/updateTopic.do" method="post">
        <!--  隐藏域 提交id-->
        <input type="hidden" name="tid" value="${topic.tid}">

        <div class="form-group">
            <label for="topicname">主题名称：</label>
            <input type="text" class="form-control" id="topicname" name="topicname" value="${topic.topicname}"
                   placeholder="请输入主题名"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <a href="${pageContext.request.contextPath}/topic/findAll.do"> <input class="btn btn-default"
                                                                                        type="button" value="返回"/></a>
        </div>
    </form>
</div>
</body>
</html>

