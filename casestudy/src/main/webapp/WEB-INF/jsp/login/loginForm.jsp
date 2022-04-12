<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp"/>
<form action="/login/loginSubmit" method="POST">
    Email : <input type="text" name="username">
    <br>
    Password : <input type="text" name="password">
    <button type="submit">Submit</button>
</form>


<jsp:include page="../include/footer.jsp"/>