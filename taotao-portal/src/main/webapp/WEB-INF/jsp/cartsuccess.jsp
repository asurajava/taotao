<%--
  Created by IntelliJ IDEA.
  User: Asura
  Date: 2017/4/18
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

%>
<!DOCTYPE html>
<!-- saved from url=(0084)https://cart.jd.com/addToCart.html?rcd=1&pid=3764785&pc=1&nr=1&rid=1492490528117&em= -->
<html class="root61">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" async="" src="./商品已成功加入购物车_files/conversion_async.js"></script>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="/css/saved_resource.css">
    <link rel="stylesheet" type="text/css" href="/css/base.css">
    <link rel="stylesheet" type="text/css" href="/css/addtocart-album.css">
    <title>商品已成功加入购物车</title>
    <script type="text/javascript" async="" src="./商品已成功加入购物车_files/wl.js"></script>
    <script async="" src="./商品已成功加入购物车_files/gtm.js"></script>
    <script type="text/javascript">
        window.pageConfig = {compatible: true};
    </script>
    <script type="text/javascript" src="./商品已成功加入购物车_files/saved_resource(1)"></script>
    <link rel="stylesheet" type="text/css" href="/css/saved_resource(2).css">
    <script></script>
</head>
<body>
<jsp:include page="commons/header.jsp" />

<div class="main">
    <div class="success-wrap">
        <div class="w" id="result">
            <div class="m succeed-box">
                <div class="mc success-cont">
                    <div class="success-lcol">
                        <div class="success-top"><b class="succ-icon"></b>
                            <h3 class="ftx-02">商品已成功加入购物车！</h3></div>
                        <div class="p-item">
                            <div class="p-img"><a href="https://item.jd.com/3764785.html" target="_blank"><img
                                    src="./商品已成功加入购物车_files/58d09324N1c8cd214.jpg"
                                    clstag="pageclick|keycount|201601152|11"></a></div>
                            <div class="p-info">
                                <div class="p-name"><a href="https://item.jd.com/3764785.html" target="_blank"
                                                       clstag="pageclick|keycount|201601152|2"
                                                       title="志高（CHIGO）大1匹 一级能效 智能 变频 冷暖 空调挂机 除甲醛除PM2.5 NEW-GV9BJ3H1Y2（成龙签名款）">志高（CHIGO）大1匹
                                    一级能效 智能 变频 冷暖 空调挂机 除甲醛除PM2.5 NEW-GV9BJ3H1Y2（成龙签名款）</a></div>
                                <div class="p-extra"><span class="txt" title="大1匹">颜色：大1匹</span><span class="txt"
                                                                                                      title="一级能效 智能挂机">尺码：一级能效 智能挂机</span><span
                                        class="txt">/  数量：1</span></div>
                            </div>
                            <div class="clr"></div>
                        </div>
                    </div>
                    <div class="success-btns success-btns-new">
                        <div class="success-ad"><a
                                href="https://cart.jd.com/addToCart.html?rcd=1&pid=3764785&pc=1&nr=1&rid=1492490528117&em=#none"></a>
                        </div>
                        <div class="clr"></div>
                        <div><a class="btn-tobback" href="https://item.jd.com/3764785.html" target="_blank"
                                clstag="pageclick|keycount|201601152|3">查看商品详情</a><a class="btn-addtocart"
                                                                                     href="http://localhost:8082/cart/cart.html"
                                                                                     id="GotoShoppingCart"
                                                                                     clstag="pageclick|keycount|201601152|4"><b></b>去购物车结算</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="commons/footer.jsp" />
</body>
</html>
