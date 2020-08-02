<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>${news.title}</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <!--导入本地css-->
    <link href="${pageContext.request.contextPath}/css/mynews.css" rel="stylesheet" type="text/css">

    <script type="text/javascript">
        //切换验证码
        function refreshCode() {
            //1.获取验证码图片对象
            var vcode = document.getElementById("vcode");

            //2.设置其src属性，加时间戳
            vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time=" + new Date().getTime();
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
<div class="container">
    <div class="row">
        <div class="col-md-12 fl sj " style="background-color: #007BB5;color: #ffffff">
            新闻中国欢迎您！&nbsp;&nbsp;&nbsp;&nbsp;现在时间：<span style="color: #ffffff;"><span id="nowDateTimeSpan"></span></span>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3"><img src="${pageContext.request.contextPath}/images/logo.gif"
                                   class="img-responsive center-block" alt="新闻中国"/></div>
        <div class="col-md-9"><img src="${pageContext.request.contextPath}/images/a_b01.jpg" class="img-responsive "
                                   alt=""/></div>
    </div>

    <div class="row">
        <div class="col-md-3">
            <div class="row">
                <div class="col-md-12"><img src="${pageContext.request.contextPath}/images/localnews.gif" width="350"
                                            height="90"
                                            class="img-responsive center-block" alt="国内新闻"/>
                </div>
            </div>
            <div class="row">
                <div class="row">
                    <div class="col-md-12 ">

                        <div class="list-group side_list">
                            <a class="list-group-item list-group-item-success text-center">
                                微 观 中 国
                            </a>
                            <c:forEach items="${localnewss}" var="localnews">
                                <a href="${pageContext.request.contextPath}/home/readNews.do?nid=${localnews.nid}"
                                   class="list-group-item">${localnews.title}</a>
                            </c:forEach>

                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12"><img src="${pageContext.request.contextPath}/images/foriennews.gif" width="350"
                                            height="90"
                                            class="img-responsive center-block" alt="国际新闻"/>
                </div>
            </div>
            <div class="row">
                <div class="row">
                    <div class="col-md-12 side_list fl">
                        <div class="list-group side_list">
                            <a class="list-group-item list-group-item-danger text-center">
                                环 球 要 闻
                            </a>
                            <c:forEach items="${foriennewss}" var="foriennews">
                                <a href="${pageContext.request.contextPath}/home/readNews.do?nid=${foriennews.nid}"
                                   class="list-group-item">${foriennews.title}</a>
                            </c:forEach>

                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12"><img src="${pageContext.request.contextPath}/images/moneynews.gif" width="350"
                                            height="90"
                                            class="img-responsive center-block" alt="财经新闻"/>
                </div>
            </div>
            <div class="row">
                <div class="row">
                    <div class="col-md-12 side_list fl">
                        <div class="list-group side_list">
                            <a class="list-group-item list-group-item-info text-center">
                                生 财 有 道
                            </a>
                            <c:forEach items="${moneynewss}" var="moneynews">
                                <a href="${pageContext.request.contextPath}/home/readNews.do?nid=${moneynews.nid}"
                                   class="list-group-item">${moneynews.title}</a>
                            </c:forEach>

                        </div>
                    </div>
                </div>
            </div>

        </div>


        <div class="col-md-9">
            <div class="row">
                <div class="col-md-12 class_type"><img src="${pageContext.request.contextPath}/images/class_type.gif">
                </div>
            </div>

            <div class="row">
                <div class="nmr fr center-block">
                    <div class="wz">
                        <span>您现在的位置：<a href="${pageContext.request.contextPath}/home/homeNews.do">首页</a>&nbsp;>&nbsp;<a>${news.topic.topicname}</a></span>
                    </div>

                    <div class="nei n1">
                        <div class="con">
                            <h1>${news.title}</h1>
                            <div class="info">
                                发布时间：${news.creattimeStr}&nbsp;&nbsp;修改时间：${news.modifytimeStr}&nbsp;&nbsp;来源：${news.author}&nbsp;&nbsp;查看：${news.frequency}
                                &nbsp;&nbsp;次
                            </div>
                            <div>
                                <p class="summary">摘要：${news.summary}
                                </p>
                            </div>
                            <div class="cont">
                                <p style="font-family: -webkit-standard;">${news.content}</p>
                            </div>
                        </div>
                    </div>
                </div>
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