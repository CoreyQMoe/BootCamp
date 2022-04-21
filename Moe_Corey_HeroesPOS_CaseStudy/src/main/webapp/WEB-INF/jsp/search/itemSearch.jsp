<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp"/>

<div class="mainContent">
    <div class="innerContent">
        <h1 class="pageLabel">Items</h1>
        <h1 id="logo">HeroesPOS</h1>
        <sec:authorize access="hasAuthority('ADMIN')">
            <a href="/edit/newItem" id="editItemButton" class="btn btn-outline-success">Create New Item</a>
        </sec:authorize>
        <form action="/search/itemSearchSubmit" id="searchForm" name="searchForm" method="get">
            <div>
                <label for="searchCriteria" style="margin-right: 2%">Search Criteria:</label>
                <input type="text" id="searchCriteria" name="searchCriteria"
                       placeholder="Select Search Field Below">
                <button id="searchButton" class="btn btn-outline-success" type="submit">Search</button>
            </div>
            <c:forEach items='${bindingResult.getFieldErrors("searchCriteria")}' var="error">
                <div class="error">${error.getDefaultMessage()}</div>
            </c:forEach>
            <c:forEach items='${bindingResult.getFieldErrors("searchRadio")}' var="error">
                <div class="error">${error.getDefaultMessage()}</div>
            </c:forEach>
            <div class="itemTable">
                <table class="searchTable">
                    <tr class="searchTable">
                        <th class="searchTable">
                            <input type="radio" id="idSearch" name="searchRadio" value="id">
                            <label for="idSearch">Item ID</label>
                        <th class="searchTable">
                            <input type="radio" id="nameSearch" name="searchRadio" value="name">
                            <label for="nameSearch">Name</label>
                        </th>
                        <th class="searchTable">
                            <input type="radio" id="descriptionSearch" name="searchRadio" value="description">
                            <label for="descriptionSearch">Description</label>
                        </th>
                        <th class="searchTable">
                            <input type="radio" id="priceSearch" name="searchRadio" value="price">
                            <label for="priceSearch">Price</label>
                        </th>
                        <sec:authorize access="hasAuthority('ADMIN')">
                            <th class="searchTable">
                                <input type="radio" id="activeSearch" name="searchRadio" value="active">
                                <label for="activeSearch">Active</label>
                            </th>
                            <th class="searchTable">
                                <input type="radio" id="createdSearch" name="searchRadio" value="created">
                                <label for="createdSearch">Create Date</label></th>
                            <th class="searchTable">Edit</th>
                        </sec:authorize>
                        <th class="searchTable">Add To Cart</th>
                    </tr>
                    <c:forEach items="${items}" var="item">
                        <tr class="searchTable">
                            <td class="searchTable">${item.id}</td>
                            <td class="searchTable">${item.name}</td>
                            <td class="searchTable">${item.description}</td>
                            <td class="searchTable">${item.price}</td>
                            <sec:authorize access="hasAuthority('ADMIN')">
                                <td class="searchTable">${item.active}</td>
                                <td class="searchTable">${item.created}</td>
                                <td class="searchTable"><a href="/edit/editItem/${item.id}">Edit</a></td>
                            </sec:authorize>
                            <c:if test="${item.active ==1}">
                                <td class="searchTable"><a class="addToCart" href="/cart/addToCart/${item.id}">Add To Cart</a></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
    </div>
</div>
<script src="../../../pub/js/cart.js"></script>
<jsp:include page="../include/footer.jsp"/>