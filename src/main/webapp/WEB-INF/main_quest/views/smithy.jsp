<!DOCTYPE html>
<html lang="ru">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/main_quest/static/images/favicon.png" type="image/png">
    <title>Петька на коне</title>
    <style>
        <%@include file="/main_quest/static/styless/css/smithy_css/style.css"%>
    </style>
</head>

<body>
<div class="wrapper">
    <div class="main">
        <div class="main__container _container">
            <div class="main__background image">
                <img src="${pageContext.request.contextPath}/main_quest/static/images/smithy_page/smithy_background_1200.png" alt="" class="images-1200">
                <img src="${pageContext.request.contextPath}/main_quest/static/images/smithy_page/smithy_background_900.png" alt="" class="images-900">
                <img src="${pageContext.request.contextPath}/main_quest/static/images/smithy_page/smithy_background_600.png" alt="" class="images-600">
            </div>
            <div class="main__game-table table">
                <div class="table__row row-1">
                    <div class="table__cell cell-1"></div>
                    <div class="table__cell cell-2"></div>
                    <div class="table__cell cell-3"></div>
                    <div class="table__cell cell-4"></div>
                    <div class="table__cell cell-5"></div>
                </div>
                <div class="table__row row-2">
                    <div class="table__cell cell-6" id="table__cell cell-6"></div>
                    <div class="table__cell cell-7" id="table__cell cell-7"></div>
                    <div class="table__cell cell-8"></div>
                    <div class="table__cell cell-9"></div>
                    <div class="table__cell cell-10"></div>
                </div>
                <div class="table__row row-3">
                    <div class="table__cell cell-11" id="table__cell cell-11"></div>
                    <div class="table__cell cell-12" id="table__cell cell-12">

                    </div>
                    <div class="table__cell cell-13">
                        <c:if test="${requestScope.horseshoe != 'horseshoe'}">
                            <img src="${pageContext.request.contextPath}/main_quest/static/images/smithy_page/horseshoe.png" alt="" class="horseshoe" id="horseshoe">
                        </c:if>
                    </div>
                    <div class="table__cell cell-14"></div>
                    <div class="table__cell cell-15"></div>
                </div>
                <div class="table__row row-4">
                    <div class="table__cell cell-16"></div>
                    <div class="table__cell cell-17">
                        <c:if test="${requestScope.saddle != 'saddle'}">
                            <img src="${pageContext.request.contextPath}/main_quest/static/images/smithy_page/saddle.png" alt="" class="saddle" id="saddle">
                        </c:if>

                    </div>
                    <div class="table__cell cell-18">

                    </div>
                    <div class="table__cell cell-19"></div>
                    <div class="table__cell cell-20"></div>
                </div>
                <div class="table__row row-5">
                    <div class="table__cell cell-21"></div>
                    <div class="table__cell cell-22"></div>
                    <div class="table__cell cell-23"></div>
                    <div class="table__cell cell-24"></div>
                    <div class="table__cell cell-25"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    <%@include file="/main_quest/static/js/smithy_html.js"%>
</script>
</body>

</html>