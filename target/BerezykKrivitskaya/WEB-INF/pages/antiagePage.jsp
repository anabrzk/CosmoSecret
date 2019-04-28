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


<!-- start Face-page -->
<!-- content-section-starts -->
<div class="container">
    <div class="dreamcrub">
        <ul class="breadcrumbs">

            <li class="home">
                <a href="./../../index.jsp" title="Вернуться на главную страницу"><img src="../../resources/images/home.png" alt=""/></a>&nbsp;
                <span>&gt;</span>
            </li>
            <li>
                Косметика
                <span>&gt;</span>
            </li>
            <li>
                <a href="/singleAntiage/${antiage.id}"><span class="red">&nbsp;Антивозрастной&nbsp;</span></a>
            </li>
        </ul>
        <ul class="previous">
            <li><a href="./../../index.jsp">Вернуться на предыдущую страницу</a></li>
        </ul>
        <div class="clearfix"></div>
    </div>
</div>
<div class="container">
    <div class="ft-ball">
        <div class="cont span_2_of_3">
            <div class="mens-toolbar">
                <div class="sort">
                    <div class="sort-by">
                        <label>Сортировка по цене</label>

                        <c:url var="addAction" value="/orderAntiage"/>

                        <form:form action="${addAction}" commandName="antiage">
                            <label>
                                <select  name="val" onChange="submit()">
                                    <option value="">
                                        Сортировать
                                    </option>
                                    <option value="asc">
                                        По возрастанию
                                    </option>
                                    <option value="desk">
                                        По убыванию
                                    </option>
                                </select>
                            </label>
                            <a href=""><img src="../../resources/images/arrow2.gif" alt="" class="v-middle"></a>
                        </form:form>



                    </div>
                </div>

            </div>




            <div style=" max-height:750px; overflow:auto">
                <% int i = 1;%>

                <c:if test="${!empty listAntiage}">
                <c:forEach items="${listAntiage}" var="antiage">
                <%
                    if (i % 3 == 1) {
                %>
                <div class="box1" >
                    <%
                        }
                    %>
                    <div class="col_1_of_single1 span_1_of_single1">
                        <div class="view1 view-fifth1">
                            <div class="top_box">
                                <h3 class="m_1">${antiage.name}</h3>
                                <p class="m_2">${antiage.brand}</p>
                                <a href="/singleAntiage/${antiage.id}">
                                    <div class="grid_img">
                                        <div class="css3"><img src="../../resources/images/antiage/${antiage.name}1.jpg" alt=""/></div>
                                        <div class="mask1">
                                            <div class="info"><a href="/singleAntiage/${antiage.id}">Быстрый просмотр</a></div>
                                        </div>
                                    </div>
                                    <div class="price">$ ${antiage.price}</div>
                                </a>
                            </div>
                        </div>

                        <ul class="list2 icon1 sub-icon1 profile_img">
                            <li>
                                <ul class="icon1 sub-icon1 profile_img" >
                                    <li><a class="active-icon c1" href="/singleAntiage/${antiage.id}">Добавить в корзину</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <%if (i % 3 != 0) {%>
                        <div class="clear"></div>
                    </div>
                    <%} else {%>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
            <%
                }
                i++;
            %>


            </c:forEach>
            </c:if>
        </div>
    </div>
</div>

<div class="rsidebar span_1_of_left">

    <c:url var="inputAction" value="/findAntiage"/>
    <form:form action="${inputAction}" commandName="antiage">
        <section class="sky-form">
            <h4>Фирма</h4>
            <div class="row row1 scroll-pane">
                <div class="col col-4">

                    <c:forEach items="${listAntiage}" var="antiage">
                        <label class="checkbox"><input type="radio" name="brand" value="${antiage.brand}"><i></i>${antiage.brand}</label>
                    </c:forEach>
                </div>
                <input type="submit" value="<spring:message text="Поиск"/>"/>
            </div>
        </section>
    </form:form>
    <c:url var="inputAction" value="/findPriceAntiage"/>
    <form:form action="${inputAction}" commandName="antiage">
        <section class="sky-form">
            <h4>Цена</h4>
            <div class="row row1 scroll-pane">
                <div class="col col-4">

                    <label class="checkbox"><input type="radio" name="price" value="50"><i></i>$50</label>
                    <label class="checkbox"><input type="radio" name="price" value="100"><i></i>$100</label>
                    <label class="checkbox"><input type="radio" name="price" value="150"><i></i>$150</label>
                    <label class="checkbox"><input type="radio" name="price" value="200"><i></i>$200</label>
                    <label class="checkbox"><input type="radio" name="price" value="250"><i></i>$250</label>
                </div>
                <input type="submit" value="<spring:message text="Поиск"/>"/>
            </div>
        </section>
    </form:form>
</div>

<div class="clearfix"></div>
</div>
</div>
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