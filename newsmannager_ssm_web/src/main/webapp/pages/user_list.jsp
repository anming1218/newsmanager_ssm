<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script>

        function deleteUser(userid) {
            //用户安全提示
            if (confirm("你确定要删除吗？")) {
                //访问路径
                location.href = "${pageContext.request.contextPath}/user/deleteUser.do?userid=" + userid;
            }
        }


        function deleteSelect() {
            if (confirm("您确定要删除选中条目吗？")) {

                var flag = false;
                //判断是否有选中条目
                var cbs = document.getElementsByName("userid");
                for (var i = 0; i < cbs.length; i++) {
                    if (cbs[i].checked) {
                        //有一个条目选中了
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    //表单提交
                    document.getElementById("form").submit();
                }

            }
        }

        //1.获取第一个id
        document.getElementById("firstCb").onclick = function () {

            //2.获取下边列表中所有的cd
            var cbs = document.getElementsByName("userid");
            //3.遍历
            for (var i = 0; i < cbs.length; i++) {
                //4.设置这些cbs【i】的checked状态 = firstCb.checked
                cbs[i].checked = this.checked;
            }

        }

        function startTime() {
            var today = new Date();//定义日期对象
            var yyyy = today.getFullYear();//通过日期对象的getFullYear()方法返回年
            var MM = today.getMonth() + 1;//通过日期对象的getMonth()方法返回年
            var dd = today.getDate();//通过日期对象的getDate()方法返回年
            var hh = today.getHours();//通过日期对象的getHours方法返回小时
            var mm = today.getMinutes();//通过日期对象的getMinutes方法返回分钟
            var ss = today.getSeconds();//通过日期对象的getSeconds方法返回秒
            // 如果分钟或小时的值小于10，则在其值前加0，比如如果时间是下午3点20分9秒的话，则显示15：20：09
            MM = checkTime(MM);
            dd = checkTime(dd);
            mm = checkTime(mm);
            ss = checkTime(ss);
            var day; //用于保存星期（getDay()方法得到星期编号）
            if (today.getDay() == 0) day = "星期日 "
            if (today.getDay() == 1) day = "星期一 "
            if (today.getDay() == 2) day = "星期二 "
            if (today.getDay() == 3) day = "星期三 "
            if (today.getDay() == 4) day = "星期四 "
            if (today.getDay() == 5) day = "星期五 "
            if (today.getDay() == 6) day = "星期六 "
            document.getElementById('nowDateTimeSpan').innerHTML = yyyy + "-" + MM + "-" + dd + " " + hh + ":" + mm + ":" + ss + "   " + day;
            setTimeout('startTime()', 1000);//每一秒中重新加载startTime()方法
        }

        function checkTime(i) {
            if (i < 10) {
                i = "0" + i;
            }
            return i;
        }

    </script>
</head>
<body class="col-center-block" onload="startTime()">

<%--<div th:text="${msg}" id="msg" style="display:none">--%>
<%--</div>--%>
<div class="container">
    <div class="row">
        <div class="col-md-12 fl sj " style="background-color: #007BB5;color: #ffffff">
            欢迎使用新闻管理系统！&nbsp;&nbsp;&nbsp;&nbsp;现在时间：<span style="color: #ffffff;"><span
                id="nowDateTimeSpan"></span></span>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3">
            <img src="${pageContext.request.contextPath}/images/logo.gif" alt="新闻中国"
                 class="img-responsive center-block"/>
        </div>
        <div class="col-md-9">
            <img src="${pageContext.request.contextPath}/images/a_b01.jpg" class="img-responsive"/>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 fl sj " style="background-color: #007BB5;color: #ffffff">
            <div id="status">亲爱的管理员${loginuser.username}，欢迎您！ &#160;&#160;&#160;&#160; <a
                    href="${pageContext.request.contextPath}/home/quit.do"><span style="color: #ffffff">退出登录</span></a>
            </div>

        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <ul class="nav nav-tabs">
                <li role="presentation" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                       aria-expanded="false" style="font-size: large">
                        新闻管理 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <a href="${pageContext.request.contextPath}/newsAndTopics/newsAddWithTopic.do">
                            <li class="myli">增加新闻</li>
                        </a>
                        <a href="${pageContext.request.contextPath}/news/findAll.do">
                            <li class="myli">查看新闻</li>
                        </a>
                    </ul>
                </li>

                <li role="presentation" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                       aria-expanded="false" style="font-size: large">
                        主题管理 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <a href="${pageContext.request.contextPath}/pages/topic_add.jsp">
                            <li class="myli">增加主题</li>
                        </a>
                        <a href="${pageContext.request.contextPath}/topic/findAll.do">
                            <li class="myli">查看主题</li>
                        </a>
                    </ul>
                </li>

                <li role="presentation" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                       aria-expanded="false" style="font-size: large">
                        用户管理 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <a href="${pageContext.request.contextPath}/pages/user_add.jsp">
                            <li class="myli">增加管理员</li>
                        </a>
                        <a href="${pageContext.request.contextPath}/user/findAll.do">
                            <li class="myli">查看管理员</li>
                        </a>
                    </ul>
                </li>

            </ul>
        </div>
    </div>
    <div class="row">
        <div class="jumbotron">
            <h3 style="text-align: center">用户信息列表</h3>
            <div style="float: left;">

                <form class="form-inline" action="${pageContext.request.contextPath}/user/findLikeUser.do"
                      method="post">
                    <div class="form-group">
                        <label for="username_like">姓名</label>
                        <input type="text" name="username_like" class="form-control"
                               id="username_like"/>
                    </div>
                    <div class="form-group">
                        <label for="age_like">年龄</label>
                        <input type="text" name="age_like" class="form-control"
                               id="age_like"/>
                    </div>
                    <div class="form-group">
                        <label for="email_like">邮箱</label>
                        <input type="text" name="email_like" class="form-control"
                               id="email_like"/>
                    </div>
                    <button type="submit" class="btn btn-default">查询</button>
                </form>
            </div>

            <div style="float: right;margin: 5px;">
                <a class="btn btn-primary" href="javascript:void(0);" onclick="deleteSelect()">删除选中</a>
                <a href="${pageContext.request.contextPath}/pages/admin.jsp">
                    <button type="button" class="btn btn-default">返回上一层</button>
                </a>
            </div>

            <form id="form" action="${pageContext.request.contextPath}/user/deleteSelectUser.do" method="post">
                <table border="1" class="table table-bordered table-hover">
                    <tr class="success">
                        <th><input type="checkbox" id="firstCb"></th>
                        <th>编号</th>
                        <th>用户名</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>邮箱</th>
                        <th>操作</th>
                    </tr>

                    <c:forEach items="${pb.list}" var="user" varStatus="s">
                        <tr>
                            <td><input type="checkbox" name="userid" value="${user.userid}"></td>
                            <td>${s.count}</td>
                            <td>${user.username}</td>
                            <td>${user.gender}</td>
                            <td>${user.age}</td>
                            <td>${user.email}</td>
                            <td><a class="btn btn-default btn-sm"
                                   href="${pageContext.request.contextPath}/user/echoUser.do?userid=${user.userid}">修改</a>&nbsp;
                                <a class="btn btn-default btn-sm" href="javascript:deleteUser('${user.userid}');">删除</a>
                            </td>
                        </tr>

                    </c:forEach>


                </table>
            </form>

            <div>
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:if test="${pb.pageNum == 1}">
                        <li class="disabled">
                            </c:if>

                            <c:if test="${pb.pageNum != 1}">
                        <li>
                            </c:if>


                            <a href="${pageContext.request.contextPath}/user/findAll.do?page=${pb.pageNum - 1}&size=${pb.pageSize}"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>


                        <c:forEach begin="1" end="${pb.pages}" var="i">


                            <c:if test="${pb.pageNum == i}">
                                <li class="active"><a
                                        href="${pageContext.request.contextPath}/user/findAll.do?page=${i}&size=${pb.pageSize}">${i}</a>
                                </li>
                            </c:if>
                            <c:if test="${pb.pageNum != i}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/user/findAll.do?page=${i}&size=${pb.pageSize}">${i}</a>
                                </li>
                            </c:if>

                        </c:forEach>


                        <li>
                            <a href="${pageContext.request.contextPath}/user/findAll.do?page=${pb.pageNum + 1}&size=${pb.pageSize}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                        <span style="font-size: 25px;margin-left: 5px;">
                    共${pb.total}条记录，共${pb.pages}页
                </span>

                    </ul>
                </nav>
            </div>
        </div>

    </div>
    <div id="footer" class="row text-center">
        <p class=""> 24小时客户服务热线：010-68988888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160;
            新闻热线：010-627488888 <br/>
            文明办网文明上网举报电话：010-627488888 &#160;&#160;&#160;&#160; 举报邮箱： <a href="#">jubao@jb-aptech.com.cn</a></p>
        <p class="copyright"> Copyright &copy; 1999-2020 News China gov, All Right Reserver <br/>
            新闻中国 版权所有 </p>
    </div>
</div>
</body>
</html>
