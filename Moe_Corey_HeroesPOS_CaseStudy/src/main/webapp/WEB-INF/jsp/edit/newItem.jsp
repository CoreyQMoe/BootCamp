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
            <div>
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
            <div>
                <button id="submitButton" class="btn btn-outline-success" style="margin-right: 5%;">Submit</button>
                <button id="clearButton" class="btn btn-outline-success" style="margin-left: 5%;">Clear</button>
                <c:if test="${not empty form.id}">
                    <c:if test="${form.active == 1}">
                        <button id="deactivateButton" class="btn btn-outline-success" style="margin-right: 5%;">
                            Deactivate
                        </button>
                    </c:if>
                    <c:if test="${form.active == 1}">
                        <button id="activateButton" class="btn btn-outline-success" style="margin-right: 5%;">Activate
                        </button>
                    </c:if>
                    <button id="deleteButton" class="btn btn-outline-success" style="margin-left: 5%;">Delete</button>
                </c:if>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>