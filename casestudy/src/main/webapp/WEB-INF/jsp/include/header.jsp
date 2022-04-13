<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <%--    <link rel="stylesheet" href="./styles/global.css" />--%>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
    />
    <%--    <script type="text/javascript" src="./script/loginPage.js" defer></script>--%>
    <title>Heroes Login</title>
    <script src="jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="container">
    <a href="/index">Index</a>|

    <a href="/ajax">Ajax</a>
    <sec:authorize access="hasAuthority('ADMIN')">
        <a href="/user/search">Search</a>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <a href="/user/register">SignUp</a>
        <a href="/login/login">Login</a>
    </sec:authorize>
        <sec:authorize access="isAuthenticated()">
    <a href="/login/logout">Logout</a>
        <sec:authentication property="principal.username"/>
    </sec:authorize>
    <hr>
