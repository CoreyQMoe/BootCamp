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
        <form action="/search/itemSearchSubmit" id="searchForm" name="searchForm" method="post">
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
                <table>
                    <tr>
                        <th>
                            <input type="radio" id="idSearch" name="searchRadio" value="id">
                            <label for="idSearch">Item ID</label>
                        <th>
                            <input type="radio" id="nameSearch" name="searchRadio" value="name">
                            <label for="nameSearch">Name</label>
                        </th>
                        <th>
                            <input type="radio" id="descriptionSearch" name="searchRadio" value="description">
                            <label for="descriptionSearch">Description</label>
                        </th>
                        <th>
                            <input type="radio" id="priceSearch" name="searchRadio" value="price">
                            <label for="priceSearch">Price</label>
                        </th>
                        <sec:authorize access="hasAuthority('ADMIN')">
                            <th>
                                <input type="radio" id="activeSearch" name="searchRadio" value="active">
                                <label for="activeSearch">Active</label>
                            </th>
                            <th>
                                <input type="radio" id="createdSearch" name="searchRadio" value="created">
                                <label for="createdSearch">Create Date</label></th>
                            <th>Edit</th>
                        </sec:authorize>
                        <th>Add To Cart</th>
                    </tr>
                    <c:forEach items="${items}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.description}</td>
                            <td>${item.price}</td>
                            <sec:authorize access="hasAuthority('ADMIN')">
                                <td>${item.active}</td>
                                <td>${item.created}</td>
                                <td><a href="/edit/editItem/${item.id}">Edit</a></td>
                            </sec:authorize>
                            <td><a href="">Add To Cart</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>