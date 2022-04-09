<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../include/header.jsp"/>

<div class="bg">
    <div class="mainContent">
        <div class="innerContent">
            <h1 class="pageLabel">Login to</h1>
            <h1 id="logo">Heroes</h1>
            <form action="" style="padding-bottom: 4%" name="loginForm">
                <div>
                    <label for="username">Enter Username:</label>
                </div>
                <div>
                    <input type="text" id="username" name="username" placeholder="Enter Username" />
                    <p id="usernameError" class="errorMessage" name="usernameError">
                        Username cannot be blank
                    </p>
                </div>
                <div>
                    <label for="password">Enter Password:</label>
                </div>
                <div>
                    <input type="text" id="password" name="password" placeholder="Enter Password" />
                    <p id="passwordError" class="errorMessage">
                        Password cannot be blank
                    </p>
                </div>
                <div>
                    <a
                            href="#"
                            id="loginButton"
                            class="btn btn-outline-success"
                            role="button"
                    >Login</a
                    >
                </div>
            </form>
            <div id="newUserLink">
                <a href="register.jsp">Register New User</a>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../include/footer.jsp"/>
