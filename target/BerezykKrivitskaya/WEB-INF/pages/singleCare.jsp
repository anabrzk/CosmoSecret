<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta contentType="text/html; charset=utf-8"/>


<html>
<head>
    <style type="text/css">

        .btn_form {
            font-family: 'Open Sans', sans-serif;
            cursor: pointer;
            border: none;
            outline: none;
            display: inline-block;
            font-size: 0.85em;
            background: #1D1C1C;
            border-bottom: 4px solid #1D1C1C;
            color: #FFF;
            text-transform: uppercase;
            -webkit-transition: all 0.3s ease-in-out;
            -moz-transition: all 0.3s ease-in-out;
            -o-transition: all 0.3s ease-in-out;
            transition: all 0.3s ease-in-out;
        }

        .btn_form:hover {
            background: #CD5C5C;
            border-bottom: 4px solid #CD5C5C;
        }
    </style>
    <title>CosmoSecrets</title>
    <link href="../../resources/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../../resources/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="../../resources/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="../../resources/css/form.css" rel="stylesheet" type="text/css" media="all"/>


    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="CosmoSecrets Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!--webfont-->
    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic'
          rel='stylesheet' type='text/css'>
    <!-- dropdown -->
    <script src="../../resources/js/jquery.easydropdown.js"></script>
    <link href="../../resources/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="resources/js/hover_pack.js"></script>
    <link rel="stylesheet" href="../../resources/css/etalage.css">
    <script src="../../resources/js/jquery.etalage.min.js"></script>
    <script>
        jQuery(document).ready(function ($) {

            $('#etalage').etalage({
                thumb_image_width: 300,
                thumb_image_height: 400,
                source_image_width: 800,
                source_image_height: 1000,
                show_hint: true,
                click_callback: function (image_anchor, instance_id) {
                    alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                }
            });

        });
    </script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1200);
            });
        });
    </script>

</head>
<body>

<!-- header-section-starts -->
<div class="c-header" id="home">
    <div class="top-header">
        <div class="container">
            <div class="logo">
                <a href="./../../index.jsp"><img src="../../resources/images/1.png" alt=""/></a>
            </div>
            <div class="header-top-right">
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
</div>




<!-- start-single-page -->
<!-- content -->
<div class="container">
    <div class="dreamcrub">
        <ul class="breadcrumbs">


            <li>
                Косметика
                <span>&gt;</span>
            </li>
            <li>
                <span class="red">&nbsp;Увлажнение и питание&nbsp;</span>
            </li>
        </ul>

        <div class="clearfix"></div>
    </div>
</div>
<c:url var="addAction" value="/singleCare/add"/>

<form:form action="${addAction}" commandName="basket">

    <!-- start content -->
    <div class="women_main">
        <div class="container">

            <div class="row single">
                <div class="col-md-9 span-single">
                    <div class="single_left">
                        <div class="grid images_3_of_2">
                            <ul id="etalage">
                                <li>
                                    <a href="optionallink.html">
                                        <img class="etalage_thumb_image"
                                             src="../../resources/images/care/${care.name}1.jpg"
                                             class="img-responsive"/>
                                        <img class="etalage_source_image"
                                             src="../../resources/images/care/${care.name}1.jpg"
                                             class="img-responsive" title=""/>
                                    </a>
                                </li>
                                <li>
                                    <img class="etalage_thumb_image"
                                         src="../../resources/images/care/${care.name}2.jpg"
                                         class="img-responsive"/>
                                    <img class="etalage_source_image"
                                         src="../../resources/images/care/${care.name}2.jpg"
                                         class="img-responsive" title=""/>
                                </li>
                                <li>
                                    <img class="etalage_thumb_image"
                                         src="../../resources/images/care/${care.name}3.jpg"
                                         class="img-responsive"/>
                                    <img class="etalage_source_image"
                                         src="../../resources/images/care/${care.name}3.jpg"
                                         class="img-responsive"/>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>

                        <div class="desc1 span_3_of_2">


                            <h3>${care.name}</h3>
                            <h2>${care.brand}</h2>
                            <p>$ ${care.price}</p>
                            <h style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12pt;">
                                Состав: ${care.consist}</h>
                            <br>
                            <h style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12pt;">Страна
                                производства: ${care.country}</h>
                            <br>
                            <br>
                            <br>

                            <div class="filter-by-color">
                                <h3>Выберите цвет</h3>
                                <ul class="w_nav2">
                                    <li><form:checkbox TYPE="radio" path="color" value="Голубой" checked="checked"/><a class="color1" href="#"></a>
                                    </li>
                                    <li><form:checkbox TYPE="radio" path="color" value="Розовый"/><a class="color2" href="#"></a>
                                    </li>
                                    <li><form:checkbox TYPE="radio" path="color" value="Черный"/><a class="color10" href="#"></a>
                                    </li>
                                    <li><form:checkbox TYPE="radio" path="color" value="Бордовый"/><a class="color4" href="#"></a>
                                    </li>
                                    <li><form:checkbox TYPE="radio" path="color" value="Зеленый"/><a class="color6" href="#"></a>
                                    </li>
                                    <li><form:checkbox TYPE="radio" path="color" value="Оранжевый"/><a class="color19" href="#"></a>
                                    </li>
                                    <li><form:checkbox TYPE="radio" path="color" value="Коричневый"/><a class="color8" href="#"></a>
                                    </li>
                                    <li><form:checkbox TYPE="radio" path="color" value="Желтый"/><a class="color9" href="#"></a></li>
                                    <li><form:checkbox TYPE="radio" path="color" value="Фиолетовый"/><a class="color16" href="#"></a>
                                    </li>
                                    <li><form:checkbox TYPE="radio" path="color" value="Синий"/><a class="color17" href="#"></a></li>
                                    <li><form:checkbox TYPE="radio" path="color" value="Берюзовый"/><a class="color18" href="#"></a>
                                    </li>
                                </ul>

                            </div>

                            <br>
                            <br>


                            <h3>Выбрать объем</h3>
                            <form:select path="size" name="size">
                                <form:option value="50">50</form:option>
                                <form:option value="100">100</form:option>
                                <form:option value="150">150</form:option>
                                <form:option value="200">200</form:option>
                            </form:select>

                            <br>
                            <br>
                            <br>
                            <input class="btn_form" type="submit" value="<spring:message text="Добавить в корзину"/>"/>

                        </div>
                        <div class="clearfix"></div>
                    </div>


                </div>

                <div class="col-md-3 span_1_of_right">
                    <div class="w_nav1">
                        <h4>Все</h4>
                        <ul>
                            <li style="color:red">Макияж</li>
                            <li><a href="<c:url value="/facePage"/>">Лицо</a></li>
                            <li><a href="<c:url value="/eyesPage"/>">Глаза</a></li>
                            <li><a href="<c:url value="/lipsPage"/>">Губы</a></li>
                            <li><a href="<c:url value="/browsPage"/>">Брови</a></li>
                            <li style="color:red">Уходовая косметика</li>
                            <<li><a href="<c:url value="/cleanPage"/>">очищение</a></li>
                            <li><a href="<c:url value="/carePage"/>">Увлажнение</a></li>
                            <li><a href="<c:url value="/antiagePage"/>">Антивозрастной</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form:form>
<!-- end content -->
<!-- content-section-ends -->


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