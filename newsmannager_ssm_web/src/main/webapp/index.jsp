<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<body>
<a href="${pageContext.request.contextPath}/user/findAll.do">查询所有用户</a>
<a href="${pageContext.request.contextPath}/topic/findAll.do">查询所有主题</a>
<a href="${pageContext.request.contextPath}/news/findAll.do">查询所有新闻</a>
<a href="${pageContext.request.contextPath}/pages/user_add.jsp">增加用户</a>
<a href="${pageContext.request.contextPath}/pages/topic_add.jsp">增加主题</a>
<a href="${pageContext.request.contextPath}/newsAndTopics/newsAddWithTopic.do">增加新闻</a>
<a href="${pageContext.request.contextPath}/pages/home.jsp">主页</a>

</body>
</html>
