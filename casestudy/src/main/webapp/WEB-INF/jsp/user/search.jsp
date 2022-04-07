<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />


<%--<c:if test="${empty form.id}">--%>
    <h1>Search</h1>
<%--action defaults to the same page and method defaults to GET--%>
<form action="/user/search" method="GET">
    <input type="text"  name="search" placeholder="Enter Search Criteria" value="${search}"/>
    <button type="submit">Submit</button>
</form>

<table class="table">
    <tr>
        <th>Email</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
<c:forEach items="${users}" var="user">
    <tr scope="row">
        <td>${user.email}</td>
        <td>${user.firstName}</td>
        <td>${user.email}<br></td>
    </tr>
</c:forEach>
</table>
<jsp:include page="../include/footer.jsp" />