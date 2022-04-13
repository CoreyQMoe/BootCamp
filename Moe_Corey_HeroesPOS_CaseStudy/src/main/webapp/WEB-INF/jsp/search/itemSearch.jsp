<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp"/>

<div class="mainContent">
    <sec:authorize access="hasAuthority('ADMIN')">
        <div class="topButtons">
            <a href="../admin/transactionSearch" id="transactionPageButton" class="btn btn-outline-success"
               role="button">Transactions</a>
            <a href="../admin/userSearch" id="userPageButton" class="btn btn-outline-success" role="button">Users</a>
        </div>
    </sec:authorize>
    <div class="innerContent">
        <h1 class="pageLabel">Items</h1>
        <h1 id="logo">HeroesPOS</h1>
        <form action="" style="padding-bottom: 4%" id="searchForm" name="searchForm">
            <div class="itemTable">
                <table>
                    <tr>
                        <th><label for="idSearch">Item ID</label></th>
                        <th><label for="nameSearch">Name</label></th>
                        <th><label for="descriptionSearch">Description</label></th>
                        <th><label for="priceSearch">Price</label></th>
                        <th><label for="activeSearch">Active</label></th>
                        <th><label for="createdSearch">Create Date</label></th>
                        <sec:authorize access="hasAuthority('ADMIN')">
                            <th>Edit</th>
                        </sec:authorize>
                        <sec:authorize access="hasAuthority('USER')">
                            <th>Add Item</th>
                        </sec:authorize>
                    </tr>
                    <tr>
                        <td>
                            <input class="tableSearch" type="number" id="idSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="text" id="nameSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="text" id="descriptionSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="text" id="priceSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="number" id="activeSearch" min="0" max="1"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="date" id="createdSearch"/>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <c:forEach items="${items}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.description}</td>
                            <td>${item.price}</td>
                            <td>${item.active}</td>
                            <td>${item.created}</td>
                            <sec:authorize access="hasAuthority('ADMIN')">
                                <td><a href="/admin/itemEdit/${user.id}">Edit</a></td>
                            </sec:authorize>
                            <sec:authorize access="hasAuthority('USER')">
                                <td><a href="">Add Item</a></td>
                            </sec:authorize>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>