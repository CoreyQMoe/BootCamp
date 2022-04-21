var elements = document.getElementsByClassName("addToCart");

var myFunction = function() {
    alert("Item added to cart");
};

for (var i = 0; i < elements.length; i++) {
    elements[i].addEventListener('click', myFunction, false);
}

let differentAddress = document.getElementById("differentAddress");
differentAddress.addEventListener("click", toggleAddress);

function toggleAddress() {
    if (document. getElementById('differentAddress').checked) {
        document.getElementById("shippingAddress").style.display = "block"
    }
    if (!document. getElementById('differentAddress').checked) {
        document.getElementById("shippingAddress").style.display = "none"
    }
}
$(document).ready(costFunction());