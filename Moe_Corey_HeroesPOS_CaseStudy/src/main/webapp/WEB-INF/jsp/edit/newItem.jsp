<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp"/>

<div class="mainContent">
    <div class="innerContent">
        <c:if test="${empty form.id}">
            <h1 class="pageLabel">New Item</h1>
        </c:if>
        <c:if test="${not empty form.id}">
            <h1 class="pageLabel">Edit Item</h1>
        </c:if>
        <h1 id="logo">HeroesPOS</h1>
        <form action="/edit/newItemSubmit" style="padding-bottom: 4%" id="registrationForm" name="registrationForm"
              method="get">
            <div class="outerRegDiv">
                <div class="innerRegDiv">
                    <input type="hidden" name="id" value="${form.id}">
                    <div>
                        <label for="itemName">Item Name:</label>
                    </div>
                    <div>
                        <input type="text" id="itemName" name="name" placeholder="Enter Item Name"
                               value="${form.name}"/>
                    </div>
                    <c:forEach items='${bindingResult.getFieldErrors("name")}' var="error">
                        <div class="error">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </div>
                <div class="innerRegDiv">
                    <div>
                        <label for="itemDescription">Enter Item Description:</label>
                    </div>
                    <div>
                        <input type="text" id="itemDescription" name="description"
                               placeholder="Enter Item Description" value="${form.description}"/>
                    </div>
                    <c:forEach items='${bindingResult.getFieldErrors("description")}' var="error">
                        <div class="error">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </div>
            </div>
            <div class="outerRegDiv">
                <div class="innerRegDiv">
                    <div>
                        <label for="itemPrice">Enter Price:</label>
                    </div>
                    <div>
                        <input type="text" id="itemPrice" name="price" placeholder="Enter Price" value="${form.price}"/>
                    </div>
                    <c:forEach items='${bindingResult.getFieldErrors("price")}' var="error">
                        <div class="error">${error.getDefaultMessage()}</div>
                    </c:forEach>
                </div>
                <div class="innerRegDiv">
                    <div>
                        <label for="itemActive">Enter Active:</label>
                    </div>
                    <div>
                        <input type="text" id="itemActive" name="active" placeholder="Enter Active"
                               value="${form.active}"/>
                    </div>
                </div>
            </div>
            <div>
                <button id="submitButton" class="btn btn-outline-success">Submit</button>
                <c:if test="${not empty form.id}">
                    <button type="submit" formaction="/edit/deleteItem/${form.id}" id="deleteButton"
                            class="btn btn-outline-success">Delete
                    </button>
                </c:if>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>