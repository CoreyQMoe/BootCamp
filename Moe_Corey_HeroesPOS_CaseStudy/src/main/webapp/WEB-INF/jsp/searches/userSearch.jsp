<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp"/>

<div class="mainContent">
    <div class="topButtons">
        <a href="#" id="itemPageButton" class="btn btn-outline-success" role="button">Items</a>
        <a href="#" id="transactionPageButton" class="btn btn-outline-success" role="button">Transactions</a>
    </div>
    <div class="innerContent">
        <h1 class="pageLabel">Users</h1>
        <h1 id="logo">HeroesPOS</h1>
        <form action="" style="padding-bottom: 4%" id="searchForm" name="searchForm">
            <div class="userTable">
                <table>
                    <tr>
                        <th><label for="idSearch">User ID</label></th>
                        <th><label for="firstNameSearch">First Name</label></th>
                        <th><label for="lastNameSearch">Last Name</label></th>
                        <th><label for="emailSearch">Email</label></th>
                        <th><label for="phoneNumberSearch">Phone Number</label></th>
                        <th><label for="activeSearch">Active</label></th>
                        <th><label for="createdSearch">Create Date</label></th>
                        <th>Edit</th>
                    </tr>
                    <tr>
                        <td>
                            <input class="tableSearch" type="text" id="idSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="text" id="firstNameSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="text" id="lastNameSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="text" id="emailSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="text" id="phoneNumberSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="text" id="activeSearch"/>
                        </td>
                        <td>
                            <input class="tableSearch" type="text" id="createdSearch"/>
                        </td>
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
                            <td><a href="">Edit</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>