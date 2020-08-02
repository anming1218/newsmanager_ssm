<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>新闻中国</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
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
            vcode.src = "${pageContext.request.contextPath}/login/checkCode.do?time=" + new Date().getTime();
        }

        function goto() {
            location.href = "http://conferences.caixin.com/2020/caixinsummersummit2020/";
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
        <div class="col-md-12">
            <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/login/userLogin.do"
                  method="post">
                <label>登录名：</label>
                <div class="form-group">
                    <input type="text" name="username" class="form-control" value="" placeholder="请输入用户名">
                </div>
                <label>密码：</label>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" value="" placeholder="请输入密码">
                </div>
                <label>验证码：</label>
                <input type="text" name="verifycode" id="verifycode" placeholder="请输入验证码"
                       class="form-control"/>
                <a href="javascript:refreshCode();">
                    <img src="${pageContext.request.contextPath}/login/checkCode.do" title="看不清点击刷新" id="vcode"/>
                </a>
                <label id="error"> </label>

                <!-- 出错显示的信息框 -->
                <strong>${login_msg}</strong>
                <button type="submit" class="btn btn-default">登录</button>
            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-md-3"><img src="${pageContext.request.contextPath}/images/logo.gif" class="img-responsive center-block" alt="新闻中国"/></div>
        <div class="col-md-9"><img src="${pageContext.request.contextPath}/images/a_b01.jpg" class="img-responsive " alt=""/></div>
    </div>

    <div class="row">
        <div class="col-md-3">
            <div class="row">
                <div class="col-md-12"><img src="${pageContext.request.contextPath}/images/localnews.gif" width="350" height="90"
                                            class="img-responsive center-block" alt="国内新闻"/>
                </div>
            </div>
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
            <div class="row">
                <div class="col-md-12"><img src="${pageContext.request.contextPath}/images/foriennews.gif" width="350" height="90"
                                            class="img-responsive center-block" alt="国际新闻"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
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
            <div class="row">
                <div class="col-md-12"><img src="${pageContext.request.contextPath}/images/moneynews.gif" width="350" height="90"
                                            class="img-responsive center-block" alt="财经新闻"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
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
        <div class="col-md-9">
            <div class="row">
                <div class="col-md-12 class_type"><img src="${pageContext.request.contextPath}/images/class_type.gif"></div>
            </div>
            <div class="row">
                <div class="col-md-8">
                    <div class="row">
                        <div class="panel-footer col-md-12">
                            <ul class="list-group">
                                <a href="#" class="list-group-item  list-group-item-info">
                                    <h4 class="list-group-item-heading text-center"
                                        href="http://conferences.caixin.com/2020/caixinsummersummit2020/">
                                        2020财新夏季峰会~重启全球信心</h4>
                                    <a href="http://conferences.caixin.com/2020/caixinsummersummit2020/"><img
                                            src="${pageContext.request.contextPath}/images/guanggao.gif" class="img-responsive" alt="广告"/></a>
                                </a>
                            </ul>
                            <ul class="list-group">
                                <c:forEach items="${pb.list}" var="news" varStatus="s">
                                    <a href="${pageContext.request.contextPath}/home/readNews.do?nid=${news.nid}"
                                       class="list-group-item ">
                                        <h4 class="list-group-item-heading" style="font-family: 黑体">
                                            [${news.topic.topicname}]&nbsp;${news.title}</h4>
                                        <p class="list-group-item-text" style="font-family: 新宋体">${news.summary}</p>
                                    </a>
                                </c:forEach>
                            </ul>

                            <div class="col-md-12">
                                <nav aria-label="Page navigation">

                                    <ul class="pagination">
                                        <c:if test="${pb.pageNum == 1}">
                                        <li class="disabled">
                                            </c:if>

                                            <c:if test="${pb.pageNum != 1}">
                                        <li>
                                            </c:if>


                                            <a href="${pageContext.request.contextPath}/home/homeNews.do?page=${pb.pageNum - 1}&size=${pb.pageSize}"
                                               aria-label="Previous">
                                                <span aria-hidden="true">&laquo;</span>
                                            </a>
                                        </li>


                                        <c:forEach begin="1" end="${pb.pages}" var="i">


                                            <c:if test="${pb.pageNum == i}">
                                                <li class="active"><a
                                                        href="${pageContext.request.contextPath}/home/homeNews.do?page=${i}&size=${pb.pageSize}">${i}</a>
                                                </li>
                                            </c:if>
                                            <c:if test="${pb.pageNum != i}">
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/home/homeNews.do?page=${i}&size=${pb.pageSize}">${i}</a>
                                                </li>
                                            </c:if>

                                        </c:forEach>


                                        <li>
                                            <a href="${pageContext.request.contextPath}/home/homeNews.do?page=${pb.pageNum + 1}&size=${pb.pageSize}"
                                               aria-label="Next">
                                                <span aria-hidden="true">&raquo;</span>
                                            </a>
                                        </li>
                                        <span style="font-size: 25px;margin-left: 5px;">共${pb.total}条记录，共${pb.pages}页</span>
                                    </ul>
                                </nav>


                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-12">
                            <img src="${pageContext.request.contextPath}/images/newszhibo.jpg" class="img-responsive center-block" alt="新闻直播间"/>
                        </div>
                        <div class="col-md-12">
                            <table width="100%" border="0" cellpadding="2" cellspacing="2"
                                   style="border:#FAD378 1px solid;background-color:#FEFCED" align="center">
                                <tr>
                                    <td>
                                        <div class="xwx">
                                            <MaRQUEE scrollamount="2" behavior="scroll" width="100%" direction="up"
                                                     height="400" align="top" onMouseOver="stop()" onMouseOut="start()">
                                                <ul>
                                                    <c:forEach items="${realtimenews}" var="realtimenews">
                                                        <li>
                                                            <a href="${pageContext.request.contextPath}/home/readNews.do?nid=${realtimenews.nid}">${realtimenews.title}</a>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </MaRQUEE>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12"><img src="${pageContext.request.contextPath}/images/resou.gif" width="400" height="90"
                                                    class="img-responsive center-block" alt="实时热搜"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="list-group side_list">
                                <a class="list-group-item list-group-item-warning text-center">
                                    实 时 热 搜
                                </a>
                                <c:forEach items="${hotnews}" var="hotnews" varStatus="s">
                                    <a href="${pageContext.request.contextPath}/home/readNews.do?nid=${hotnews.nid}"
                                       class="list-group-item" style="font-size: small;color: #0078B6">${s.count}.&nbsp;&nbsp;${hotnews.title}<img
                                            src="${pageContext.request.contextPath}/images/re.jpg" class="img-responsive pull-right"></a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" id="friend">
        <div class="col-md-12">
            <h1 class="friend_t"><img src="${pageContext.request.contextPath}/images/friend_ico.gif" alt="合作伙伴"/></h1>
        </div>

        <div class="col-md-12 jumbotron">
            <div class="row">
                <div class="col-xs-6 col-md-3">
                    <a href="http://www.xinhuanet.com/" class="thumbnail xinhua">
                        <img src="${pageContext.request.contextPath}/images/xinhua.gif" class="img-responsive" alt="新华网">
                    </a>
                </div>

                <div class="col-xs-6 col-md-3">
                    <a href="https://www.baidu.com/" class="thumbnail">
                        <img src="${pageContext.request.contextPath}/images/baidu.gif" class="img-responsive" alt="百度">
                    </a>
                </div>

                <div class="col-xs-6 col-md-3">
                    <a href="http://www.google.cn/" class="thumbnail">
                        <img src="${pageContext.request.contextPath}/images/geogle.gif" class="img-responsive" alt="谷歌">
                    </a>
                </div>

                <div class="col-xs-6 col-md-3">
                    <a href="https://www.huanqiu.com/" class="thumbnail">
                        <img src="${pageContext.request.contextPath}/images/huanqiu.gif" class="img-responsive" alt="环球网">
                    </a>
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