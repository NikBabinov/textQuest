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
        <%@include file="/main_quest/static/styless/css/lastPage_css/style.css"%>
    </style>
</head>
<body>
<div class="wrapper">
    <div class="main">
        <div class="main__container _container">
            <div class="main_background">
                <img src="${pageContext.request.contextPath}/main_quest/static/images/last_page/main_background_1200.png"
                     alt="" class="images-1200">
            </div>
            <div class="main__hero">
                <img src="${pageContext.request.contextPath}/main_quest/static/images/last_page/hero_1200.png" alt="" class="hero-1200">
                <img src="${pageContext.request.contextPath}/main_quest/static/images/last_page/hero_900.png" alt="" class="hero-900">
                <img src="${pageContext.request.contextPath}/main_quest/static/images/last_page/hero_600.png" alt="" class="hero-600">
                <div class="hero__text">
                    <text class="vasiliy__text">${requestScope.speechVasiliy}</text>
                </div>
            </div>
            <button class="button button-indexHtml" id="button-indexHtml">${requestScope.buttonIndexHtml}</button>
        </div>
    </div>
</div>
<script>
    <%@include file="/main_quest/static/js/lastPage_html.js"%>
</script>
</body>
</html>
