<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp"/>

<div class="mainContent">
    <div class="innerContent">
        <h1 class="pageLabel">Items</h1>
        <h1 id="logo">HeroesPOS</h1>
        <form action="" style="padding-bottom: 4%" id="searchForm" name="searchForm">
            <label for="searchCriteria">Search Criteria:</label> &nbsp; <input type="text" id="searchCriteria">
            <div class="itemTable">
                <table>
                    <tr>
                        <th><input type="radio" id="idSearch" name="searchRadio" value="ID"><label for="idSearch">Item ID</label></th>
                        <th><input type="radio" id="nameSearch" name="searchRadio"><label for="nameSearch">Name</label></th>
                        <th><input type="radio" id="descriptionSearch" name="searchRadio"><label for="descriptionSearch">Description</label></th>
                        <th><input type="radio" id="priceSearch" name="searchRadio"><label for="priceSearch">Price</label></th>
                        <sec:authorize access="hasAuthority('ADMIN')">
                            <th><input type="radio" id="activeSearch" name="searchRadio"><label for="activeSearch">Active</label></th>
                            <th><input type="radio" id="createdSearch" name="searchRadio"<label for="createdSearch">Create Date</label></th>
                            <th>Edit</th>
                        </sec:authorize>
                            <th>Add Item</th>
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
                                <td><a href="/admin/itemEdit/${user.id}">Edit</a></td>
                            </sec:authorize>
                            <td><a href="">Add Item</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>