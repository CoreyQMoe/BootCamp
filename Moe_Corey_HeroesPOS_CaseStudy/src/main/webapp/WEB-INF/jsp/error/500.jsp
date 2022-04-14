<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>
<style>
    body {
        background-image: url("../../../pub/images/404.jpg");
        height:100%;
        background-position: top center;
        background-repeat: no-repeat;
        background-size: cover;
        overflow: auto;
    }

    p {
        color: white;
        text-align: center;
    }
    h1, h3 {
        color: #f70a04;
        text-shadow: 1px 1px white;
        text-align: center;
    }
</style>

<h1>Error Page</h1>

<c:if test="${not empty requestUrl}">
    <p>${requestUrl}</p>
</c:if>
<h3>Stack Trace</h3>
<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>
<c:if test="${not empty stackTrace}">
    <p>${stackTrace}</p>
</c:if>
<h3>Root Cause</h3>
<c:if test="${not empty rootCause}">
    <p>${rootCause}</p>
</c:if>
<c:if test="${not empty rootTrace}">
    <p>${rootTrace}</p>
</c:if>


<jsp:include page="../include/footer.jsp"/>