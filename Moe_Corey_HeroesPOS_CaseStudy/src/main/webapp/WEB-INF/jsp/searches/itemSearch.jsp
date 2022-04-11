<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp"/>

<div class="mainContent">
    <div class="topButtons">
        <a href="#" id="transactionPageButton" class="btn btn-outline-success" role="button">Transactions</a>
        <a href="#" id="userPageButton" class="btn btn-outline-success" role="button">Users</a>
    </div>
    <div class="innerContent">
        <h1 class="pageLabel">Items</h1>
        <h1 id="logo">HeroesPOS</h1>
        <form action="" style="padding-bottom: 4%" id="searchForm" name="searchForm">
            <div class="userTable">
                <table>
                    <tr>
                        <th><label for="idSearch">Item ID</label></th>
                        <th><label for="nameSearch">Name</label></th>
                        <th><label for="descriptionSearch">Description</label></th>
                        <th><label for="priceSearch">Price</label></th>
                        <th><label for="activeSearch">Active</label></th>
                        <th><label for="createdSearch">Create Date</label></th>
                        <th>Edit</th>
                    </tr>
                    <tr>
                        <td>
                            <input class="tableSearch" type="text" id="idSearch"/>
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
                            <input class="tableSearch" type="text" id="activeSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="text" id="createdSearch"/>
                        </td>
                    </tr>

                </table>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>