<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp"/>

<c:if test="${empty form.id}">
    <h1>Sign Up</h1>
</c:if>
<c:if test="${not empty form.id}">
    <h1>Edit</h1>
</c:if>

<form action="/user/registerSubmit" method="GET">
    <input type="hidden" name="id" value="${form.id}">
    Email<input type="email" name="email" id="emailID" value="${form.email}">

    <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
        <div>${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    First Name <input type="text" name="firstName" id="firstNameID" value="${form.firstName}">
    <br><c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">
    <div style="color: red;">${error.getDefaultMessage()}</div>
</c:forEach>
    <br>
    Last Name <input type="text" name="lastName" id="lastNameID" value="${form.lastName}">

    <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">
        <div style="color: red;">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    Password <input type="password" name="password" id="passwordID" value="${form.password}">

    <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">
        <div style="color: red;">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    Confirm Password <input type="password" name="confirmPassword" id="confirmPasswordID"
                            value="${form.confirmPassword}">
    <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
        <div style="color: red;">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    Check Box <input type="checkbox" name="checkbox">
    <br>
    <button type="submit">Submit</button>

</form>
<%--<c:if test="${not empty errorMessages}">--%>
<%--    <br>--%>
<%--    <C:forEach itesms="${errorMessages}" var="message">--%>
<%--        <div style="color: red;">--%>
<%--            ${message}--%>
<%--        </div>--%>
<%--    </C:forEach>--%>
<%--</c:if>--%>

<%--<c:if test="${bindingReulst.hasErrors()}">--%>
<%--    <br>--%>
<%--    <C:forEach itesms="${bindingReulst.getAllErrors()}" var="error">--%>
<%--        <div style="color: red;">--%>
<%--                ${error.getDefaultMessage()}--%>
<%--        </div>--%>
<%--    </C:forEach>--%>
<%--</c:if>--%>

<jsp:include page="../include/footer.jsp"/>