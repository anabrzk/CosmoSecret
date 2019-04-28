<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta contentType="text/html; charset=utf-8"/>
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

    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic'
          rel='stylesheet' type='text/css'>
    <!-- dropdown -->
    <script src="../../resources/js/jquery.easydropdown.js"></script>
    <link href="../../resources/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="resources/js/hover_pack.js"></script>

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
<!-- start login -->
<div class="container">
    <div class="dreamcrub">
        <ul class="breadcrumbs">

            <li>Авторизация</li>&nbsp;

        </ul>
        <div class="clearfix"></div>
    </div>
</div>

<section id="main">
    <div class="login-content">
        <div class="container">
            <div class="login-signup-form">
                <c:url var="addAction" value="/signin/check"/>

                <form:form action="${addAction}" commandName="user">
                    <div class="col-md-5 login text-center">
                        <h4>Войти</h4>
                        <font color="red">${errorLoginus}</font>
                        <h5></h5>
                        <div class="cus_info_wrap">
                            <label class="labelTop">
                                E-mail:
                                <span class="require">*</span>
                            </label>
                            <form:input path="username"/>
                        </div>
                        <div class="clearfix"></div>
                        <font color="red">${errorPasswordus}</font>
                        <div class="cus_info_wrap">
                            <label class="labelTop">
                                Пароль:
                                <span class="require">*</span>
                            </label>
                            <form:input path="password" type="password"/>
                        </div>
                        <div class="clearfix"></div>
                        <div class="sky-form span_99">

                        </div>
                        <div class="botton1">
                            <input type="submit" value="Войти" class="botton">
                        </div>

                    </div>
                </form:form>
                <c:url var="addAction" value="/signin/add"/>

                <form:form action="${addAction}" commandName="user">
                    <div class="col-md-5 sign-up text-center">
                        <h4>Зарегистрироваться</h4>
                        <font color="red">${errorLenghtUsername} ${errorLogin}</font>
                        <div class="cus_info_wrap">
                            <label class="labelTop">
                                E-mail:
                                <span class="require">*</span>
                            </label>
                            <form:input path="username"/>
                        </div>

                        <div class="clearfix"></div>
                        <font color="red">${errorLenghtPassword}</font>
                        <div class="cus_info_wrap">
                            <label class="labelTop">
                                Пароль:
                                <span class="require">*</span>
                            </label>
                            <form:input path="password" type="password"/>
                        </div>
                        <font color="red">${errorPassword}</font>
                        <div class="clearfix"></div>
                        <div class="cus_info_wrap">
                            <label class="labelTop confirmpass">
                                Повторите пароль:
                                <span class="require">*</span>
                            </label>
                            <input type="password" name="val"/>
                        </div>
                        <div class="botton1">
                            <input type="submit" value="Войти" class="botton">
                        </div>

                    </div>
                </form:form>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    </div>
</section>


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