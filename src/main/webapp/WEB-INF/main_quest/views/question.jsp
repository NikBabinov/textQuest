<!DOCTYPE html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/main_quest/static/images/favicon.png"
          type="image/png">
    <style>
        <%@include file="/main_quest/static/styless/css/question_css/style.css"%>
    </style>
    <title>Петька на коне</title>
</head>
<body>
<div class="wrapper">
    <div class="main">
        <div class="main__container _container">
            <div class="main_background">
                <img src="${pageContext.request.contextPath}/main_quest/static/images/question_page/main_background_1200.png"
                     alt="" class="images-1200">
                <img src="${pageContext.request.contextPath}/main_quest/static/images/question_page/main_background_900.png"
                     alt="" class="images-900">
                <img src="${pageContext.request.contextPath}/main_quest/static/images/question_page/main_background_600.png"
                     alt="" class="images-600">
                <div class="hero__text">
                    <text class="vasiliy__text">${requestScope.speechVasiliy}</text>
                </div>
            </div>
            <div class="main__hover-action">
                <div class="main__hover-smithy" id="main__hover-smithy"></div>
                <div class="main__hover-road" id="main__hover-road"></div>
            </div>
        </div>
    </div>
</div>
<script>
    <%@include file="/main_quest/static/js/question_html.js"%>
</script>
</body>

</html>