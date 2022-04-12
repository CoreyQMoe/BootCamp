<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp"/>

<div class="mainContent">
    <div class="innerContent">
        <h1 class="pageLabel">Register for</h1>
        <h1 id="logo">HeroesPOS</h1>
        <form action="/user/registerSubmit" method="post" style="padding-bottom: 4%" id="registrationForm"
              name="registrationForm">
            <div class="outerRegDiv">
                <div class="innerRegDiv">
                    <div>
                        <label for="firstName">Enter First Name:</label>
                    </div>
                    <div>
                        <input type="text" id="firstName" name="firstName" placeholder="Enter First Name"/>
                        <c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">
                            <div style="color: #f70a04;">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
                <div class="innerRegDiv">
                    <div>
                        <label for="lastName">Enter Last Name:</label>
                    </div>
                    <div>
                        <input type="text" id="lastName" name="lastName" placeholder="Enter Last Name"/>
                        <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">
                            <div style="color: #f70a04;">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="outerRegDiv">
                <div class="innerRegDiv">
                    <div>
                        <label for="password">Enter Password:</label>
                    </div>
                    <div>
                        <input type="password" id="password" name="password" placeholder="Enter Password"/>
                        <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">
                            <div style="color: #f70a04;">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
                <div class="innerRegDiv">
                    <div>
                        <label for="confirmPassword">Confirm Password:</label>
                    </div>
                    <div>
                        <input type="password" id="confirmPassword" name="confirmPassword"
                               placeholder="Confirm Password"/>
                        <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
                            <div style="color: #f70a04;">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="outerRegDiv">
                <div class="innerRegDiv">
                    <div>
                        <label for="phoneNumber">Enter Phone Number:</label>
                    </div>
                    <div>
                        <input type="tel" id="phoneNumber" name="phoneNumber" placeholder="Enter Phone Number"/>
                        <c:forEach items='${bindingResult.getFieldErrors("phoneNumber")}' var="error">
                            <div style="color: #f70a04;">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
                <div class="innerRegDiv">
                    <div>
                        <label for="email">Enter Email:</label>
                    </div>
                    <div>
                        <input type="email" id="email" name="email" placeholder="Enter Email"/>
                        <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
                            <div style="color: #f70a04;">${error.getDefaultMessage()}</div>
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
                        <input type="text" id="address" name="address" placeholder="Enter Address"/>
                        <c:forEach items='${bindingResult.getFieldErrors("address")}' var="error">
                            <div style="color: #f70a04;">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>

                <div class="innerRegDiv">
                    <div>
                        <label for="city">Enter City:</label>
                    </div>
                    <div>
                        <input type="text" id="city" name="city" placeholder="Enter City"/>
                        <c:forEach items='${bindingResult.getFieldErrors("city")}' var="error">
                            <div style="color: #f70a04;">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="outerRegDiv">
                <div class="innerRegDiv" style="margin-left: 5%;">
                    <div>
                        <label for="state">Select State:</label>
                    </div>
                    <div>
                        <select name="state" id="state">
                            <option value="0" selected disabled hidden>Select a State</option>
                            <option value="AL">Alabama</option>
                            <option value="AK">Alaska</option>
                            <option value="AZ">Arizona</option>
                            <option value="AR">Arkansas</option>
                            <option value="CA">California</option>
                            <option value="CO">Colorado</option>
                            <option value="CT">Connecticut</option>
                            <option value="DE">Delaware</option>
                            <option value="DC">District Of Columbia</option>
                            <option value="FL">Florida</option>
                            <option value="GA">Georgia</option>
                            <option value="HI">Hawaii</option>
                            <option value="ID">Idaho</option>
                            <option value="IL">Illinois</option>
                            <option value="IN">Indiana</option>
                            <option value="IA">Iowa</option>
                            <option value="KS">Kansas</option>
                            <option value="KY">Kentucky</option>
                            <option value="LA">Louisiana</option>
                            <option value="ME">Maine</option>
                            <option value="MD">Maryland</option>
                            <option value="MA">Massachusetts</option>
                            <option value="MI">Michigan</option>
                            <option value="MN">Minnesota</option>
                            <option value="MS">Mississippi</option>
                            <option value="MO">Missouri</option>
                            <option value="MT">Montana</option>
                            <option value="NE">Nebraska</option>
                            <option value="NV">Nevada</option>
                            <option value="NH">New Hampshire</option>
                            <option value="NJ">New Jersey</option>
                            <option value="NM">New Mexico</option>
                            <option value="NY">New York</option>
                            <option value="NC">North Carolina</option>
                            <option value="ND">North Dakota</option>
                            <option value="OH">Ohio</option>
                            <option value="OK">Oklahoma</option>
                            <option value="OR">Oregon</option>
                            <option value="PA">Pennsylvania</option>
                            <option value="RI">Rhode Island</option>
                            <option value="SC">South Carolina</option>
                            <option value="SD">South Dakota</option>
                            <option value="TN">Tennessee</option>
                            <option value="TX">Texas</option>
                            <option value="UT">Utah</option>
                            <option value="VT">Vermont</option>
                            <option value="VA">Virginia</option>
                            <option value="WA">Washington</option>
                            <option value="WV">West Virginia</option>
                            <option value="WI">Wisconsin</option>
                            <option value="WY">Wyoming</option>
                        </select>
                        <c:forEach items='${bindingResult.getFieldErrors("state")}' var="error">
                            <div style="color: #f70a04;">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
                <div class="innerRegDiv">
                    <div>
                        <label for="zipCode">Enter Zip Code:</label>
                    </div>
                    <div>
                        <input type="number" id="zipCode" name="zipCode" placeholder="Enter Zip Code"/>
                        <c:forEach items='${bindingResult.getFieldErrors("zipCode")}' var="error">
                            <div style="color: #f70a04;">${error.getDefaultMessage()}</div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div>
                <button
                        id="submitButton"
                        class="btn btn-outline-success"
                        type="submit"
                        style="margin-right: 5%;"
                >Submit
                </button>
                <a
                        id="clearButton"
                        class="btn btn-outline-success"
                        role="button"
                        style="margin-left: 5%;"
                >Clear</a>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>