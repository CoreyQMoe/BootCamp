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

    h1, h3, p {
        color: #f70a04;
        text-align: center;
    }
    h1, h3 {
        text-shadow: 2px 2px white;
    }
</style>

<h1 style="color: #760201;">Error Page</h1>

<c:if test="${not empty requestUrl}">
    <p style="color: #760201;">${requestUrl}</p>
</c:if>
<h3 style="color: color: #760201;">Stack Trace</h3>
<c:if test="${not empty message}">
    <p style="color: #760201;">${message}</p>
</c:if>
<c:if test="${not empty stackTrace}">
    <p style="color: #760201;">${stackTrace}</p>
</c:if>
<h3 style="color: #760201;">Root Cause</h3>
<c:if test="${not empty rootCause}">
    <p style="color: #760201;">${rootCause}</p>
</c:if>
<c:if test="${not empty rootTrace}">
    <p style="color: #760201;">${rootTrace}</p>
</c:if>


<jsp:include page="../include/footer.jsp"/>