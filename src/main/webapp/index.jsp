<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta contentType="text/html; charset=utf-8"/>


<html>
<head>
    <title>CosmoSecrets</title>
    <link href="resources/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <script src="resources/js/jquery.min.js"></script>
    <link href="resources/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="CosmoSecrets Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>

    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic'
          rel='stylesheet' type='text/css'>
    <script src="resources/js/jquery.easydropdown.js"></script>
    <link href="resources/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="resources/js/scripts.js" type="text/javascript"></script>
</head>
<body>
<div class="header" id="home">
    <div class="top-header">
        <div class="container">
            <div class="logo">
                <a href="index.jsp"><img src="resources/images/1.png" alt=""/></a>
            </div>
            <div class="header-top-right">

                <script src="resources/js/classie.js"></script>
                <script src="resources/js/uisearch.js"></script>


                <a href="<c:url value="/basket"/>"><i class="cart"></i></a>
            </div>
            <div class="navigation">
                <div>
                    <label class="mobile_menu" for="mobile_menu">
                        <span>Меню</span>
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
    <div class="banner">
        <div class="signing text-right">
            <div class="container">
                <div class="sign-in">
                    <a href="<c:url value="/signin"/>">Войти</a>
                </div>
                <div class="sign-up1">
                    <a href="<c:url value="/exit"/>">Выйти</a>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="banner-info text-center">
            <i class="shipping"></i>
            <h3>Лучшая косметика</h3>
            <h3>для самых прекрасных</h3>
            <p></p>
            <a href="<c:url value="/facePage"/>">Все товары</a>
        </div>
    </div>
</div>
<div class="content">

    <div class="container">
        <div class="products-section">
            <div class="products-section-head text-center">
                <h3><span>А</span>кции</h3>
            </div>
            <div class="products-section-grids">

                <div id="portfoliolist">


                    <div class="portfolio card mix_all" data-cat="card" style="display: inline-block; opacity: 1;">
                        <div class="portfolio-wrapper">
                            <a href="<c:url value="/singleFace/1"/>" class="b-link-stripe b-animate-go  thickbox">
                                <img src="./resources/images/face/Основа1.jpg" class="img-responsive" alt=""/>
                                <div class="b-wrapper">
                                    <div class="atc"><p> Добавить к корзину</p></div>
                                </div>
                            </a>
                            <div class="title">
                                <div class="colors">
                                    <h4>Основа</h4>
                                    <h2>GOSH</h2>
                                </div>
                                <div class="main-price">
                                    <h3>$<span>36.90</span></h3>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>

                    <div class="portfolio card mix_all" data-cat="card" style="display: inline-block; opacity: 1;">
                        <div class="portfolio-wrapper">
                            <a href="<c:url value="/singleFace/4"/>" class="b-link-stripe b-animate-go  thickbox">
                                <img src="./resources/images/face/Основа-пудра1.jpg" class="img-responsive" alt=""/>
                                <div class="b-wrapper">
                                    <div class="atc"><p> Добавить к корзину</p></div>
                                </div>
                            </a>
                            <div class="title">
                                <div class="colors">
                                    <h4>ОСНОВА-ПУДРА</h4>
                                    <h2>PUВRA</h2>
                                </div>
                                <div class="main-price">
                                    <h3>$<span>20</span></h3>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>

                    <div class="portfolio card mix_all" data-cat="card" style="display: inline-block; opacity: 1;">
                        <div class="portfolio-wrapper">
                            <a href="<c:url value="/singleFace/8"/>" class="b-link-stripe b-animate-go  thickbox">
                                <img src="./resources/images/face/Палетка1.jpg" class="img-responsive" alt=""/>
                                <div class="b-wrapper">
                                    <div class="atc"><p> Добавить к корзину</p></div>
                                </div>
                            </a>
                            <div class="title">
                                <div class="colors">
                                    <h4>ПАЛЕТКА</h4>
                                    <h2>Kit</h2>
                                </div>
                                <div class="main-price">
                                    <h3>$<span>56</span></h3>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>


                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
        </div>



    </div>
</div>


<div class="footer">
    <div class="up-arrow">
        <a class="scroll" href="#home"><img src="resources/images/up.png" alt=""/></a>
    </div>
    <div class="container">
        <div class="copyrights">
            <p>Copyright &copy; 2019 @CosmoSecrets</p>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</div>
</body>
</html>