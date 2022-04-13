<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp"/>

<div class="bg">
    <div class="mainContent">
        <div class="innerContent">
            <h1 class="pageLabel">Login to</h1>
            <h1 id="logo">HeroesPOS</h1>
            <form action="/login/loginSubmit" style="padding-bottom: 4%" name="loginForm" method="POST">
                <div>
                    <label for="username">Enter Email Address:</label>
                </div>
                <div>
                    <input type="text" id="username" name="username" placeholder="Enter Email Address" />
                    <p id="usernameError" class="errorMessage" name="usernameError">
                        Username cannot be blank
                    </p>
                </div>
                <div>
                    <label for="password">Enter Password:</label>
                </div>
                <div>
                    <input type="password" id="password" name="password" placeholder="Enter Password" />
                    <p id="passwordError" class="errorMessage">
                        Password cannot be blank
                    </p>
                </div>
                <div>
                    <button type="submit" id="loginButton" class="btn btn-outline-success">Login</button>
                </div>
            </form>
            <div>
                <a href="../user/register">To Register Click Here</a>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../include/footer.jsp"/>
