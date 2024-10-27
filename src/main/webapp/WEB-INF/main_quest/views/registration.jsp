<!DOCTYPE html>
<html lang="ru">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="UTF-8">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/main_quest/static/images/favicon.png" type="image/png">
    <title>Регистрация</title>
    <style>
        <%@include file="/main_quest/static/styless/css/registration_css/style.css"%>
    </style>
</head>
<body>
<div class="main" id="main">
    <div class="main__container user-registration" id="user-registration">
        <form action="" spellcheck="false" class="user-registration__form" id="user-registration__form">
            <legend class="user-registration__legend" id="user-registration__legend">Регистрация пользователя</legend>
            <p class="user-registration__paragraph-l" id="user-registration__paragraph-l">
                <label class="user-registration__label" for="user-registration__email-1">Введите email</label>
                <input type="email" class="user-registration__email-1" id="user-registration__email-1">
            </p>
            <p class="user-registration__paragraph" id="mail-registration__paragraph">
                <label class="user-registration__label" id="email__label" for="user-registration__email">Введите
                    email</label>
                <input type="email" class="user-registration__email" id="user-registration__email">
            </p>
            <p class="user-registration__paragraph" id="password-registration__paragraph">
                <label class="user-registration__label" for="user-registration__password" id="password__label">Введите
                    пароль</label>
                <input type="password" class="user-registration__password" id="user-registration__password"
                       placeholder="не менее 6-ти символов">
            </p>
            <p class="user-registration__paragraph" id="repeat-registration__paragraph">
                <label class="user-registration__label" id="repeat-password__label"
                       for="user-registration__password-repeat">Повторите
                    пароль</label>
                <input type="password" class="user-registration__password-repeat"
                       id="user-registration__password-repeat">
            </p>
            <p class="user-registration__paragraph-checkbox">
                <label class="user-registration__label-checkbox" for="user-registration__password-show">
                    показать пароль
                </label>
                <input type="checkbox" class="user-registration__password-show" id="user-registration__password-show">
            </p>
            <p class="user-registration__paragraph-button" id="user-registration__paragraph-button"></p>
            <p class="user-recovery__paragraph-button" id="user-recovery__paragraph-button"></p>

        </form>
    </div>
</div>
<script charset="utf-8">
    <%@include file="/main_quest/static/js/registration_html.js"%>
</script>
</body>
</html>
