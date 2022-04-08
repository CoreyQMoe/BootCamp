<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp"/>

<div class="mainContent">
    <div class="innerContent">
        <h1 class="pageLabel">Register for</h1>
        <h1 id="logo">Heroes</h1>
        <form action="/user/registerPage" method="post" style="padding-bottom: 4%" id="registrationForm" name="registrationForm">
            <div class="outerRegDiv">
                <div class="innerRegDiv">
                    <div>
                        <label for="firstName">Enter First Name:</label>
                    </div>
                    <div>
                        <input type="text" id="firstName" name="firstName" placeholder="Enter First Name"/>
                        <p id="firstNameError" class="errorMessage" name="firstNameError">
                            First name cannot be blank
                        </p>
                    </div>
                </div>
                <div class="innerRegDiv">
                    <div>
                        <label for="lastName">Enter Last Name:</label>
                    </div>
                    <div>
                        <input type="text" id="lastName" name="lastName" placeholder="Enter Last Name"/>
                        <p id="lastNameError" class="errorMessage" name="lastNameError">
                            Last name cannot be blank
                        </p>
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
                        <p id="passwordError" class="errorMessage">
                            Password cannot be blank
                        </p>
                    </div>
                </div>
                <div class="innerRegDiv">
                    <div>
                        <label for="confirmPassword">Confirm Password:</label>
                    </div>
                    <div>
                        <input type="password" id="confirmPassword" name="confirmPassword"
                               placeholder="Confirm Password"/>
                        <p id="confirmPasswordError" class="errorMessage">
                            Password cannot be blank
                        </p>
                    </div>
                </div>
            </div>
            <div>
                <label for="email">Enter Email:</label>
            </div>
            <div>
                <input type="email" id="email" name="email" placeholder="Enter Email"/>
                <p id="emailError" class="errorMessage">
                    Email cannot be blank
                </p>
            </div>
            <div class="outerRegDiv">
                <div class="innerRegDiv">
                    <div>
                        <label for="address1">Enter Address:</label>
                    </div>
                    <div>
                        <input type="text" id="address1" name="address1" placeholder="Enter Address 1"/>
                        <p id="address1Error" class="errorMessage">
                            Adresss cannot be blank
                        </p>
                    </div>
                </div>
                <div class="innerRegDiv">
                    <div>
                        <label for="address2">Enter Address:</label>
                    </div>
                    <div>
                        <input type="text" id="address2" name="address2" placeholder="Enter Address 2"/>
                    </div>
                </div>
            </div>
            <div class="outerRegDiv">
                <div class="innerRegDiv">
                    <div>
                        <label for="city">Enter City:</label>
                    </div>
                    <div>
                        <input type="text" id="city" name="city" placeholder="Enter City"/>
                        <p id="cityError" class="errorMessage">
                            City cannot be blank
                        </p>
                    </div>
                </div>
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
                        <p id="stateError" class="errorMessage">
                            Please select a state
                        </p>
                    </div>
                </div>
            </div>
            <div>
                <label for="zip">Enter Zip Code:</label>
            </div>
            <div>
                <input type="number" id="zip" name="zip" placeholder="Enter Zip Code"/>
                <p id="zipError" class="errorMessage">
                    Zip code cannot be blank
                </p>
            </div>
            <div>
                <a
                        href="loginPage.html"
                        id="submitButton"
                        class="btn btn-outline-success"
                        role="button"
                        style="margin-right: 5%;"
                >Submit</a
                >
                <a
                        id="clearButton"
                        class="btn btn-outline-success"
                        role="button"
                        style="margin-left: 5%;"
                >Clear</a
                >
            </div>

        </form>
    </div>
</div>


<jsp:include page="../include/footer.jsp"/>