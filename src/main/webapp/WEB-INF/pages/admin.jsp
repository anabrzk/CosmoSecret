<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta contentType="text/html; charset=utf-8"/>
<!DOCTYPE html>
<html>
<head>
    <title>CosmoSecrets</title>
    <link href="../../resources/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <script src="../../resources/js/jquery.min.js"></script>
    <link href="../../resources/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="CosmoSecrets Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>

    <!--webfont-->
    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic'
          rel='stylesheet' type='text/css'>
    <!-- dropdown -->
    <script src="../../resources/js/jquery.easydropdown.js"></script>
    <link href="../../resources/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="js/hover_pack.js"></script>

</head>
<body>
<!-- header-section-starts -->
<div class="c-header" id="home">
    <div class="top-header">
        <div class="container">
            <div class="logo">
                <a href="../../index.jsp"><img src="../../resources/images/1.png" alt=""/></a>
            </div>
            <div class="header-top-right">

                <script src="../../resources/js/classie.js"></script>
                <script src="../../resources/js/uisearch.js"></script>

                <a href="<c:url value="/basket"/>"><i class="cart"></i></a>
            </div>
            <div class="navigation">
                <div>
                    <label class="mobile_menu" for="mobile_menu">
                        <span>Menu</span>
                    </label>
                    <input id="mobile_menu" type="checkbox">
                    <ul class="nav">
                        <li class="dropdown1"><a href="#">Макияж</a>
                            <ul class="dropdown2">
                                <li><a href="<c:url value="/facePage"/>">Лицо</a></li>
                                <li><a href="<c:url value="/eyesPage"/>">Глаза</a></li>
                                <li><a href="<c:url value="/lipsPage"/>">Губы</a></li>
                                <li><a href="<c:url value="/browsPage"/>">Брови</a></li>
                            </ul>
                        </li>

                        <li class="dropdown1"><a href="#">Уходовая косметика</a>
                            <ul class="dropdown2">
                                <li><a href="<c:url value="/cleanPage"/>">Очищение</a></li>
                                <li><a href="<c:url value="/carePage"/>">Увлажнение и питание</a></li>
                                <li><a href="<c:url value="/antiagePage"/>">Антивозрастной уход</a></li>
                            </ul>
                        </li>
                        <li><a href="<c:url value="/contact"/>">Контакты</a></li>
                        <div class="clearfix"></div>
                    </ul>

                </div>
            </div>
        </div>
    </div>
</div>
<br>
<div class="container">
    <div class="dreamcrub">
        <ul class="breadcrumbs">
            <li>
                <span class="red">&nbsp;Заказы клиентов&nbsp;</span>
            </li>
        </ul>
        <div class="clearfix"></div>
    </div>
</div>


<div class="container"  style="overflow:auto">
    <div class="coats sing-c text-center">

        <c:if test="${!empty baskView}">

            <table border="1">

                <c:forEach items="${baskView}" var="bask">

                    <tr>
                        <td><img src="../../resources/images/${bask.nameEn}/${bask.name}1.jpg" alt="" width="90"/></td>
                        <td>Тип: ${bask.type}<br>
                            Название: ${bask.name}<br>
                            Оттенок: ${bask.color}<br>
                            Объем: ${bask.size}<br>
                        </td>
                        <td width="80" align="center">$ ${bask.price}</td>
                        <td width="80" align="center">${bask.username}</td>

                    </tr>
                </c:forEach>

            </table>
        </c:if>

    </div>

</div>

<div class="footer">
    <div class="up-arrow">
        <a class="scroll" href="#home"><img src="../../resources/images/up.png" alt=""/></a>
    </div>
    <div class="container">
        <div class="copyrights">
            <p>Copyright &copy; 2018 @CosmoSecrets</p>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</body>
</html>