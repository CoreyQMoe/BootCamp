<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp"/>

<div class="mainContent">
    <div class="innerContent">
        <%--        <sec:authorize access="!isAuthenticated()">--%>
        <%--            <h1 class="pageLabel">Register For</h1>--%>
        <%--        </sec:authorize>--%>
        <%--        <sec:authorize access="isAuthenticated()">--%>
        <h1 class="pageLabel">Edit User For</h1>
        <%--        </sec:authorize>--%>
        <h1 id="logo">HeroesPOS</h1>
        <form action="/edit/editUserSubmit/${form.id}" method="post" style="padding-bottom: 4%" id="registrationForm"
              name="registrationForm">
            <div class="outerRegDiv">
                <div class="innerRegDiv">
                    <input type="hidden" name="id" value="${form.id}" )>
                    <div>
                        <label for="firstName">Enter First Name:</label>
                    </div>
                    <div>
                        <input type="text" id="firstName" name="firstName" placeholder="Enter First Name"
                               value="${form.firstName}"/>
                        <c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">
                            <div class="error">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
                <div class="innerRegDiv">
                    <div>
                        <label for="lastName">Enter Last Name:</label>
                    </div>
                    <div>
                        <input type="text" id="lastName" name="lastName" placeholder="Enter Last Name"
                               value="${form.lastName}"/>
                        <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">
                            <div class="error">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <%--            <sec:authorize access="isAuthenticated()">--%>
            <%--                <div class="outerRegDiv">--%>
            <%--                    <div class="innerRegDiv">--%>
            <%--                        <div>--%>
            <%--                            <label for="password">Enter Password:</label>--%>
            <%--                        </div>--%>
            <%--                        <div>--%>
            <%--                            <input type="password" id="password" name="password" placeholder="Enter Password"--%>
            <%--                                   value="${form.password}"/>--%>
            <%--                            <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">--%>
            <%--                                <div class="error">${error.getDefaultMessage()}</div>--%>
            <%--                            </c:forEach>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                    <div class="innerRegDiv">--%>
            <%--                        <div>--%>
            <%--                            <label for="confirmPassword">Confirm Password:</label>--%>
            <%--                        </div>--%>
            <%--                        <div>--%>
            <%--                            <input type="password" id="confirmPassword" name="confirmPassword"--%>
            <%--                                   placeholder="Confirm Password" value="${form.confirmPassword}"/>--%>
            <%--                            <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">--%>
            <%--                                <div class="error">${error.getDefaultMessage()}</div>--%>
            <%--                            </c:forEach>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </sec:authorize>--%>
            <div class="outerRegDiv">
                <div class="innerRegDiv">
                    <div>
                        <label for="phoneNumber">Enter Phone Number:</label>
                    </div>
                    <div>
                        <input type="tel" id="phoneNumber" name="phoneNumber" placeholder="Enter Phone Number"
                               value="${form.phoneNumber}"/>
                        <c:forEach items='${bindingResult.getFieldErrors("phoneNumber")}' var="error">
                            <div class="error">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
                <div class="innerRegDiv">
                    <div>
                        <label for="email">Enter Email:</label>
                    </div>
                    <div>
                        <input type="email" id="email" name="email" placeholder="Enter Email" value="${form.email}"/>
                        <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
                            <div class="error">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="outerRegDiv">
                <div class="innerRegDiv">
                    <div>
                        <label for="address">Enter Address:</label>
                    </div>
                    <div>
                        <input type="text" id="address" name="address" placeholder="Enter Address"
                               value="${form.address}"/>
                        <c:forEach items='${bindingResult.getFieldErrors("address")}' var="error">
                            <div class="error">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>

                <div class="innerRegDiv">
                    <div>
                        <label for="city">Enter City:</label>
                    </div>
                    <div>
                        <input type="text" id="city" name="city" placeholder="Enter City" value="${form.city}"/>
                        <c:forEach items='${bindingResult.getFieldErrors("city")}' var="error">
                            <div class="error">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="outerRegDiv">
                <div class="innerRegDiv">
                    <div>
                        <label for="state">Enter State:</label>
                    </div>
                    <div>
                        <input type="text" id="state" name="state" placeholder="Enter State" value="${form.state}"/>
                        <c:forEach items='${bindingResult.getFieldErrors("state")}' var="error">
                            <div class="error">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
                <div class="innerRegDiv">
                    <div>
                        <label for="zipCode">Enter Zip Code:</label>
                    </div>
                    <div>
                        <input type="number" id="zipCode" name="zipCode" placeholder="Enter Zip Code"
                               value="${form.zipCode}"/>
                        <c:forEach items='${bindingResult.getFieldErrors("zipCode")}' var="error">
                            <div class="error">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div>
                <button id="submitButton" class="btn btn-outline-success" type="submit">Submit</button>
                <sec:authorize access="hasAuthority('ADMIN')">
                    <c:if test="${form.active == 1}">
                        <button id="deactivateButton" class="btn btn-outline-success" type="submit"
                                formaction="/edit/flipUserActivation/${form.id}">
                            Deactivate
                        </button>
                    </c:if>
                    <c:if test="${form.active == 0}">
                        <button id="activateButton" class="btn btn-outline-success" type="submit"
                                formaction="/edit/flipUserActivation/${form.id}">
                            Activate
                        </button>
                    </c:if>
                </sec:authorize>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>