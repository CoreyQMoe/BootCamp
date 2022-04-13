<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp"/>

<div class="mainContent">
    <div class="topButtons">
        <a href="../search/itemSearch" id="itemPageButton" class="btn btn-outline-success" role="button" >Items</a>
        <a href="userSearch" id="userPageButton" class="btn btn-outline-success" role="button">Users</a>
    </div>
    <div class="innerContent">
        <h1 class="pageLabel">Transactions</h1>
        <h1 id="logo">HeroesPOS</h1>
        <form action="" style="padding-bottom: 4%" id="searchForm" name="searchForm">
            <div>
                <table class="userTable">
                    <tr>
                        <th><label for="idSearch">Transaction ID</label></th>
                        <th><label for="customerFirstNameSearch">Customer First Name</label></th>
                        <th><label for="customerLastNameSearch">Customer Last Name</label></th>
                        <th><label for="totalSearch">Total</label></th>
                        <th><label for="paymentTypeSearch">Payment Type</label></th>
                        <th><label for="orderDateSearch">Order Date</label></th>
                    </tr>
                    <tr>
                        <td>
                            <input class="tableSearch" type="number" id="idSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="text" id="customerFirstNameSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="text" id="customerLastNameSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="text" id="totalSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="text" id="paymentTypeSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="date" id="orderDateSearch"/>
                        </td>
                    </tr>
                    <c:forEach items="${transactions}" var="transaction">
                        <tr>
                            <td>${transaction.id}</td>
                            <td>${transaction.user.firstName}</td>
                            <td>${transaction.user.lastName}</td>
                            <td>${transaction.total}</td>
                            <td>${transaction.payment}</td>
                            <td>${transaction.created}</td>
                            <td><a href="">Edit</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>