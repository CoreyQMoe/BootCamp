<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" type="text/css" href="../../../pub/css/global.css"/>
    <title>HeroesPOS</title>
</head>
<body>
<div style="margin: 1%">
    <sec:authorize access="isAuthenticated()">
        <span class="headLink">Logged in as: <sec:authentication property="principal.username"/></span>
        &nbsp; | &nbsp;<a class="headLink" href="/login/logout">Logout</a>
        &nbsp; | &nbsp;<a class="headLink" href="../search/itemSearch">Items</a>
        <sec:authorize access="hasAuthority('ADMIN')">
            &nbsp; | &nbsp;<a class="headLink" href="../search/transactionSearch">Transactions</a>
            &nbsp; | &nbsp;<a class="headLink" href=../search/userSearch>Users</a>
        </sec:authorize>
            &nbsp; | &nbsp;<a class="headLink" href="#">Cart</a>
            &nbsp; | &nbsp;<a class="headLink" href="#">Profile</a>
    </sec:authorize>
</div>