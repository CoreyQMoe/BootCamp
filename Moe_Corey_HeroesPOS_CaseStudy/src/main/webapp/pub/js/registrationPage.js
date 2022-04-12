// let submitRegistration = document.getElementById("submitButton");
// submitRegistration.addEventListener("click", validateRegistration);
let cancelRegistration = document.getElementById("clearButton");
cancelRegistration.addEventListener("click", reset);

// function validateRegistration(e) {
//     e.preventDefault();
//     var count = 0;
//     if(validateFirstName()) {
//         count++;
//         console.log("1");
//     }
//     if(validateLastName()) {
//         count++;
//         console.log("2");
//     }
//     if(validatePassword()) {
//         count++;console.log("3");
//     }
//     if(validateConfirmPassword()) {
//         count++;console.log("4");
//     }
//     if(validateEmail()) {
//         count++;console.log("5");
//     }
//     if(validateAddress()) {
//         count++;console.log("6");
//     }
//     if(validateCity()) {
//         count++;console.log("7");
//     }
//     if(validateState()) {
//         count++;console.log("8");
//     }
//     if(validateZip()){
//         count++;console.log("89");
//     }
//     console.log(count);
//     if(count == 9) {
//         document.getElementById("registrationForm").submit();
//         window.location.href = "loginPage.html";
//     }
// }
//
// function validateFirstName() {
//     let firstNameText = firstName.value;
//     var result = true;
//
//     if(firstNameText == "") {
//         document.registrationForm.firstName.focus();
//         document.getElementById("firstNameError").style.visibility = "visible";
//
//         result = false;
//     } else if (firstNameText.includes(" ")) {
//         document.registrationForm.firstName.focus();
//         document.getElementById("firstNameError").innerHTML = "First name cannot have a space"
//         document.getElementById("firstNameError").style.visibility = "visible";
//
//         result = false;
//     } else if (firstNameText.match(/\d/)) {
//         document.registrationForm.firstName.focus();
//         document.getElementById("firstNameError").innerHTML = "First name cannot have a number"
//         document.getElementById("firstNameError").style.visibility = "visible";
//
//         result = false;
//     }else {
//         document.getElementById("firstNameError").style.visibility = "hidden";
//     }
//     return result;
// }
//
// function validateLastName() {
//     let lastNameText = lastName.value;
//     var result = true;
//
//     if(lastNameText == "") {
//         document.registrationForm.lastName.focus();
//         document.getElementById("lastNameError").style.visibility = "visible";
//
//         result = false;
//     } else if (lastNameText.includes(" ")) {
//         document.registrationForm.lastName.focus();
//         document.getElementById("lastNameError").innerHTML = "Last name cannot have a space"
//         document.getElementById("lastNameError").style.visibility = "visible";
//
//         result = false;
//     } else if (lastNameText.match(/\d/)) {
//         document.registrationForm.lastName.focus();
//         document.getElementById("lastNameError").innerHTML = "Last name cannot have a number"
//         document.getElementById("lastNameError").style.visibility = "visible";
//
//         result = false;
//     }else {
//         document.getElementById("lastNameError").style.visibility = "hidden";
//     }
//     return result;
// }
//
// function validatePassword() {
//     let passwordText = password.value;
//     var result = true;
//
//     if(passwordText == "") {
//         document.registrationForm.password.focus();
//         document.getElementById("passwordError").style.visibility = "visible";
//
//         result = false;
//     } else if(passwordText.length < 8 || passwordText.length > 20) {
//         document.registrationForm.password.focus();
//         document.getElementById("passwordError").innerHTML = "Password must contain between eight and twenty characters"
//         document.getElementById("passwordError").style.visibility = "visible";
//
//         result = false;
//     } else if(!(passwordText.match(/[a-z]/))) {
//         document.registrationForm.password.focus();
//         document.getElementById("passwordError").innerHTML = "Password must contain at least one lowercase letter"
//         document.getElementById("passwordError").style.visibility = "visible";
//
//         result = false;
//     } else if(!(passwordText.match(/[A-Z]/))) {
//         document.registrationForm.password.focus();
//         document.getElementById("passwordError").innerHTML = "Password must contain at least one uppercase letter"
//         document.getElementById("passwordError").style.visibility = "visible";
//
//         result = false;
//     } else if(!(passwordText.match(/\d/))) {
//         document.registrationForm.password.focus();
//         document.getElementById("passwordError").innerHTML = "Password must contain at least one number"
//         document.getElementById("passwordError").style.visibility = "visible";
//
//         result = false;
//     } else if(!(passwordText.match(/[@$!%*#?&]/))) {
//         document.registrationForm.password.focus();
//         document.getElementById("passwordError").innerHTML = "Password must contain at least one special character"
//         document.getElementById("passwordError").style.visibility = "visible";
//
//         result = false;
//     } else {
//         document.getElementById("passwordError").style.visibility = "hidden";
//     }
//     return result;
// }
//
// function validateConfirmPassword() {
//     let confirm = confirmPassword.value;
//     var result = true;
//
//     if(confirm == "") {
//         document.registrationForm.confirmPassword.focus();
//         document.getElementById("confirmPasswordError").style.visibility = "visible";
//
//         result = false;
//     } else if(password.value != confirm) {
//         document.registrationForm.confirmPassword.focus();
//         document.getElementById("confirmPasswordError").innerHTML = "Passwords do not match"
//         document.getElementById("confirmPasswordError").style.visibility = "visible";
//
//         result = false;
//     }
//     return result;
// }
//
// function validateEmail() {
//     let eMail = email.value;
//     result = true;
//
//     if(eMail == "")  {
//         document.registrationForm.firstName.focus();
//         document.getElementById("emailError").style.visibility = "visible";
//
//         result = false;
//     } else if (!(eMail.match(/[a-z0-9]+@[a-z]+\.[a-z]{2,3}/))) {
//         document.registrationForm.firstName.focus();
//         document.getElementById("emailError").innerHTML = "Email in an incorrect format"
//         document.getElementById("emailError").style.visibility = "visible";
//
//         result = false;
//     } else {
//         document.getElementById("emailError").style.visibility = "hidden";
//     }
//     return result;
// }
//
// function validateAddress() {
//     let addressText = address1.value;
//     var result = true;
//
//     if(addressText == "") {
//         document.registrationForm.address1.focus();
//         document.getElementById("address1Error").style.visibility = "visible";
//
//         result = false;
//     } else  {
//         document.getElementById("emailError").style.visibility = "hidden";
//     }
//     return result;
// }
//
// function validateCity() {
//     let cityText = city.value;
//     var result = true;
//
//     if(cityText == "") {
//         document.registrationForm.city.focus();
//         document.getElementById("cityError").style.visibility = "visible";
//
//         result = false;
//     } else  if(cityText.match(/\d/)) {
//         document.registrationForm.city.focus();
//         document.getElementById("cityError").innerHTML = "City cannot contain a number"
//         document.getElementById("cityError").style.visibility = "visible";
//     } else  {
//         document.getElementById("emailError").style.visibility = "hidden";
//     }
//     return result;
// }
//
// function validateState() {
//     let stateValue = state.value;
//     var result = true;
//     if(stateValue == 0) {
//         document.registrationForm.state.focus();
//         document.getElementById("stateError").style.visibility = "visible";
//         result = false;
//     } else {
//         document.getElementById("stateError").style.visibility = "hidden";
//     }
//     return result;
// }
//
// function validateZip() {
//     let zipCode = zip.value;
//     var result = true;
//     if(zipCode == "") {
//         document.registrationForm.zip.focus();
//         document.getElementById("zipError").style.visibility = "visible";
//         result = false;
//     } else if(zipCode < 501 && zipCode > 99950) {
//         document.registrationForm.zip.focus();
//         document.getElementById("zipError").innerHTML = "Please enter a valid zip code"
//         document.getElementById("zipError").style.visibility = "visible";
//         result = false;
//     } else {
//         document.getElementById("zipError").style.visibility = "hidden";
//     }
//     return result;
// }

function reset() {
    location.reload();
}