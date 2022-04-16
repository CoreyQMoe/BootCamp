<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp"/>

<div class="mainContent">
    <div class="innerContent">
        <h1 class="pageLabel">Transactions</h1>
        <h1 id="logo">HeroesPOS</h1>
        <form action="/admin/transactionSearchSubmit" style="padding-bottom: 4%" id="searchForm" name="searchForm">
            <div>
                <label for="searchCriteria" style="margin-right: 2%">Search Criteria:</label>
                <input type="text" id="searchCriteria" name="searchCriteria"
                       placeholder="Select Search Field Below">
                <button id="searchButton" class="btn btn-outline-success" type="submit">Search</button>
            </div>
            <c:forEach items='${bindingResult.getFieldErrors("searchCriteria")}' var="error">
                <div class="error">
                        ${error.getDefaultMessage()}</div>
            </c:forEach>
            <c:forEach items='${bindingResult.getFieldErrors("searchRadio")}' var="error">
                <div class="error">${error.getDefaultMessage()}</div>
            </c:forEach>
            <table class="userTable">
                <tr>
                    <th>
                        <input type="radio" id="idSearch" name="searchRadio" value="id">
                        <label for="idSearch">Transaction ID</label>
                    </th>
                    <th>
                        <input type="radio" id="userFirstNameSearch" name="searchRadio" value="firstName">
                        <label for="userFirstNameSearch">Customer First Name</label>
                    </th>
                    <th>
                        <input type="radio" id="userLastNameSearch" name="searchRadio" value="lastName">
                        <label for="userLastNameSearch">Customer Last Name</label>
                    </th>
                    <th>
                        <input type="radio" id="totalSearch" name="searchRadio" value="total">
                        <label for="totalSearch">Total</label>
                    </th>
                    <th>
                        <input type="radio" id="statusSearch" name="searchRadio" value="status">
                        <label for="statusSearch">Status</label>
                    </th>
                    <th>
                        <input type="radio" id="createdSearch" name="searchRadio" value="created">
                        <label for="createdSearch">Created</label>
                    </th>
                    <th>Edit</th>
                </tr>
                <c:forEach items="${transactions}" var="transaction">
                    <tr>
                        <td>${transaction.id}</td>
                        <td>${transaction.user.firstName}</td>
                        <td>${transaction.user.lastName}</td>
                        <td>${transaction.total}</td>
                        <td>${transaction.status}</td>
                        <td>${transaction.created}</td>
                        <td><a href="/edit/editTransaction/${transaction.id}">Edit</a></td>
                    </tr>
                </c:forEach>
            </table>

        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>