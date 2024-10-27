<!DOCTYPE html>
<html lang="ru">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/main_quest/static/images/favicon.png" type="image/png">
    <title>Авторизация</title>
    <style>
        <%@include file="/main_quest/static/styless/css/login_css/style.css"%>
    </style>
</head>
<body>
<div class="main" id="main">
    <div class="main__container header__login-form" id="header__login-form">
        <form action="" method="post" class="login__form " id="login__form" spellcheck="false">
            <legend class="login__legend" id="login__legend">Авторизуйтесь для доступа</legend>
            <p class="login__paragraph">
                <label class="login__label" for="login__email">Введите email</label>
                <input type="email" class="login__email" id="login__email" name="login__email">
            </p>
            <p class="login__paragraph margin-bottom">
                <label class="login__label" for="login__password">Введите пароль</label>
                <input type="password" class="login__password" id="login__password" name="login__password">
            </p>
            <p class="login__paragraph-checkbox">
                <label class="login__label-checkbox" for="login__password-show">
                    показать пароль
                </label>
                <input type="checkbox" class="login__password-show" id="login__password-show">
            </p>

            <p class="login__paragraph-button">
                <input type="submit" class="login__button" id="login__button" value="авторизоваться">
            </p>
            <p class="login__paragraph-text">Если вы еще не прошли регистрацию<br> <a
                    href="${pageContext.request.contextPath}/registration" id="registration__link">пройдите
                по ссылке</a>
            </p>
        </form>
    </div>
</div>
<script charset="utf-8">
    <%@include file="/main_quest/static/js/login_html.js"%>
</script>
</body>
</html>
