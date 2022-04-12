let submitLogin = document.getElementById("loginButton");
submitLogin.addEventListener("click", validateLogin);

function validateLogin(e) {
    e.preventDefault();
    var count = 0;
    if(validateUsername()) {
        count++;
    }
    if(validatePassword()) {
        count++;
    }
    if(count == 2) {
        window.location.href = "tablePage.html"
        // Change this shit
    }
}

function validateUsername() {
    let usernameText = username.value;
    var result = true;

    if(usernameText == "") {
        document.loginForm.username.focus();
        document.getElementById("usernameError").style.visibility = "visible";
        result = false;
    } else {
        document.getElementById("usernameError").style.visibility = "hidden";
    }
    return result;
}

function validatePassword() {
    let passwordText = password.value;
    var result = true;
    if(passwordText == "") {
        document.loginForm.password.focus();
        document.getElementById("passwordError").style.visibility = "visible";
        result = false;
    } else {
        document.getElementById("passwordError").style.visibility = "hidden";
    }
    return result;
}