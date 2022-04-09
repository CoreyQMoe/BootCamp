<jsp:include page="../include/header.jsp"/>

<h1>AJAX</h1>

<script>
$(document).ready(function() {
    $("myRange").addEventListener("change", function() {
        document.getElementById("rangeValue").textContent = $("myRange").value;
    }, false);
});
</script>

<div class="slidecontainer">
    <input type="range" min="1" max="100" value="50" class="slider" id="myRange">
</div>

<script>
    var slider = document.getElementById("myRange");
    var output = document.getElementById("rangeValue");
    output.innerHTML = slider.value; // Display the default slider value

    // Update the current slider value (each time you drag the slider handle)
    slider.oninput = function() {
        output.innerHTML = this.value;
    }
</script>



<jsp:include page="../include/footer.jsp"/>