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
        <%@include file="/main_quest/static/styless/css/index_css/style.css"%>
    </style>
</head>

<body>
<div class="wrapper">
    <div class="main">
        <img src="${pageContext.request.contextPath}/main_quest/static/images/index_page/index_background.jpg" alt="" class="main__background">
        <div class="main__container _container">
            <div class="main__header header">
                <div class="header__authorization">
                    <img src="${pageContext.request.contextPath}/main_quest/static/images/logo.png" alt="" class="header__logo">
                    <c:choose>
                        <c:when test="${empty sessionScope.user}">
                            <img src="${pageContext.request.contextPath}/main_quest/static/images/registrations.png" alt="authorization" class="authorization__image" id="authorization__image">
                        </c:when>
                        <c:otherwise>
                            <div class="user__email">${sessionScope.user}</div>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
            <div class="hero">
                <div class="hero__petka petka">
                    <text class="petka__text">${requestScope.speechPetka}</text>
                    <img src="${pageContext.request.contextPath}/main_quest/static/images/index_page/petka.png" alt="" class="petka">
                </div>
                <div class="hero__vasiliy vasiliy">
                    <text class="vasiliy__text">${requestScope.speechVasiliy}</text>
                    <img src="${pageContext.request.contextPath}/main_quest/static/images/index_page/vasiliy.png" alt="" class="vasiliy">
                </div>
            </div>
            <button class="start__button button" id="start__button">${requestScope.textStartButton}</button>
        </div>
    </div>
</div>
<script>
    <%@include file="/main_quest/static/js/index_html.js"%>
</script>
</body>
</html>