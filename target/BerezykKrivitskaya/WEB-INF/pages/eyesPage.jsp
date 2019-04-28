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
    <link href="../../resources/css/form.css" rel="stylesheet" type="text/css" media="all"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="CosmoSecrets Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>

    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic'
          rel='stylesheet' type='text/css'>
    <script src="../../resources/js/jquery.easydropdown.js"></script>
    <link href="../../resources/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="resources/js/hover_pack.js"></script>


</head>
<body>
<div class="c-header" id="home">
    <div class="top-header">
        <div class="container">
            <div class="logo">
                <a href="index.jsp"><img src="../../resources/images/1.png" alt=""/></a>
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

<div class="container">
    <div class="dreamcrub">
        <ul class="breadcrumbs">

            <li>
                Косметика
                <span>&gt;</span>
            </li>
            <li>
                <a href="/singleEyes/${eyes.id}"><span class="red">&nbsp;Глаза&nbsp;</span></a>
            </li>
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
                        <c:url var="addAction" value="/orderEyes"/>

                        <form:form action="${addAction}" commandName="eyes">
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
                            <a href=""><img src="../../resources/images/arrow2.gif" alt="" class="v-middle"></a>
                        </form:form>
                    </div>
                </div>

            </div>




            <div style=" max-height:750px; overflow:auto">
                <% int i = 1;%>

                <c:if test="${!empty listEyes}">
                <c:forEach items="${listEyes}" var="eyes">
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
                                <h3 class="m_1">${eyes.name}</h3>
                                <p class="m_2">${eyes.brand}</p>
                                <a href="/singleEyes/${eyes.id}">
                                    <div class="grid_img">
                                        <div class="css3"><img src="../../resources/images/eyes/${eyes.name}1.jpg" alt=""/></div>
                                        <div class="mask1">
                                            <div class="info"><a href="/singleEyes/${eyes.id}">Быстрый просмотр</a></div>
                                        </div>
                                    </div>
                                    <div class="price">$ ${eyes.price}</div>
                                </a>
                            </div>
                        </div>

                        <ul class="list2"  class="icon1 sub-icon1 profile_img">
                            <li>
                                <ul class="icon1 sub-icon1 profile_img" >
                                    <li><a class="active-icon c1" href="/singleEyes/${eyes.id}">Добавить в корзину</a>
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

    <c:url var="inputAction" value="/findEyes"/>
    <form:form action="${inputAction}" commandName="eyes">
        <section class="sky-form">
            <h4>Фирма</h4>
            <div class="row row1 scroll-pane">
                <div class="col col-4">

                    <c:forEach items="${listEyes}" var="eyes">
                        <label class="checkbox"><input type="radio" name="brand" value="${eyes.brand}"><i></i>${eyes.brand}</label>
                    </c:forEach>
                </div>
                <input type="submit" value="<spring:message text="Поиск"/>"/>
            </div>
        </section>
    </form:form>
    <c:url var="inputAction" value="/findPriceEyes"/>
    <form:form action="${inputAction}" commandName="eyes">
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