<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp"/>

<div class="mainContent">
    <div class="innerContent">
        <h1 class="pageLabel">Users</h1>
        <h1 id="logo">HeroesPOS</h1>
        <form action="/admin/userSearchSubmit" style="padding-bottom: 4%" id="searchForm" name="searchForm">
            <div>
                <label for="searchCriteria" style="margin-right: 2%">Search Criteria:</label>
                <input type="text" id="searchCriteria" name="searchCriteria"
                       placeholder="Select Search Field Below">
                <button id="searchButton" class="btn btn-outline-success" type="submit">Search</button>
            </div>
            <c:forEach items='${bindingResult.getFieldErrors("searchCriteria")}' var="error">
                <div style="color: #f70a04; margin-bottom: 1%">
                        ${error.getDefaultMessage()}</div>
            </c:forEach>
            <c:forEach items='${bindingResult.getFieldErrors("searchRadio")}' var="error">
                <div style="color: #f70a04; margin-bottom: 1%">${error.getDefaultMessage()}</div>
            </c:forEach>
            <div class="userTable">
                <table>
                    <tr>
                        <th>
                            <input type="radio" id="idSearch" name="searchRadio" value="id">
                            <label for="idSearch">User ID</label>
                        </th>
                        <th>
                            <input type="radio" id="firstNameSearch" name="searchRadio" value="firstName">
                            <label for="firstNameSearch">First Name</label>
                        </th>
                        <th>
                            <input type="radio" id="lastNameSearch" name="searchRadio" value="lastName">
                            <label for="lastNameSearch">Last Name</label>
                        </th>
                        <th>
                            <input type="radio" id="emailSearch" name="searchRadio" value="email">
                            <label for="emailSearch">Email</label>
                        </th>
                        <th>
                            <input type="radio" id="phoneNumberSearch" name="searchRadio" value="phoneNumber">
                            <label for="phoneNumberSearch">Phone Number</label>
                        </th>
                        <th>
                            <input type="radio" id="activeSearch" name="searchRadio" value="active">
                            <label for="activeSearch">Active</label>
                        </th>
                        <th>
                            <input type="radio" id="createdSearch" name="searchRadio" value="created">
                            <label for="createdSearch">Created</label>
                        </th>
                        <th>Edit</th>
                    </tr>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.email}</td>
                            <td>${user.phoneNumber}</td>
                            <td>${user.active}</td>
                            <td>${user.created}</td>
                            <td><a href="#"${user.id}">Edit</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>