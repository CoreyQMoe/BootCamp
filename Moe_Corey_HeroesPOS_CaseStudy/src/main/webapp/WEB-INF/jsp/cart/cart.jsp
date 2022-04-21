<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp"/>

<div class="mainContent">
    <div class="innerContent">
        <h1 id="logo">HeroesPOS</h1>
        <h1 class="pageLabel">Your Cart</h1>
        <div>
            <span>Transaction Number: ${transactionID}</span>
        </div>
        <div style="justify-content: center">
            <div style="justify-content: center">
                <table style="margin-bottom: 4%">
                    <tr style="border: 1px solid #2ebb03">
                        <th style="border: 1px solid #2ebb03">Item Number</th>
                        <th style="border: 1px solid #2ebb03">Item Name</th>
                        <th style="border: 1px solid #2ebb03">Quantity</th>
                        <th style="border: 1px solid #2ebb03">Price</th>
                        <th style="border: 1px solid #2ebb03">Cost</th>
                    </tr>
                    <c:forEach items="${items}" var="item" varStatus="status">
                        <tr style="border: 1px solid #2ebb03">
                            <td style="border: 1px solid #2ebb03">${item.id}</td>
                            <td style="border: 1px solid #2ebb03">${item.name}</td>
                            <td style="border: 1px solid #2ebb03">${quantities[status.index]}</td>
                            <td style="border: 1px solid #2ebb03">${item.price}</td>
                            <td id="cost" style="border: 1px solid #2ebb03">${costs[status.index]}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td style="border: 1px solid #2ebb03">Subtotal:</td>
                        <td style="border: 1px solid #2ebb03">${subtotal}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td style="border: 1px solid #2ebb03">Tax:</td>
                        <td style="border: 1px solid #2ebb03">${tax}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td style="border: 1px solid #2ebb03">Total:</td>
                        <td style="border: 1px solid #2ebb03">${total}</td>
                    </tr>
                </table>
            </div>
            <form action="/cart/cartSubmit" method="post">
                <div>
                    <input type="checkbox" id="differentAddress" name="differentAddress">
                    <label for="differentAddress">Is your shipping address different from your billing address</label>
                </div>
                <div id="shippingAddress">
                    <div class="outerRegDiv">
                        <div class="innerRegDiv">
                            <div>
                                <label for="address">Enter Address:</label>
                            </div>
                            <div>
                                <input type="text" id="address" name="altAddress" placeholder="Enter Address"
                                       value="${form.altAddress}"/>
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
                                <input type="text" id="city" name="altCity" placeholder="Enter City"
                                       value="${form.altCity}"/>
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
                                <input type="text" id="state" name="altState" placeholder="Enter State"
                                       value="${form.altState}"/>
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
                                <input type="number" id="zipCode" name="altZip" placeholder="Enter Zip Code"
                                       value="${form.altZip}"/>
                                <c:forEach items='${bindingResult.getFieldErrors("zipCode")}' var="error">
                                    <div class="error">${error.getDefaultMessage()}</div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="outerRegDiv" style="margin-top: 3%">
                    <div class="innerRegDiv">
                        <div>
                            <label for="ccType">Credit Card Type:</label>
                        </div>
                        <div>
                            <select id="ccType" name="creditCardType">
                                <option value="VISA">VISA</option>
                                <option value="Master Card">Master Card</option>
                                <option value="American Express">American Express</option>
                            </select>
                        </div>
                    </div>
                    <div class="innerRegDiv">
                        <div>
                            <label for="ccNumber">Enter Credit Card Number:</label>
                        </div>
                        <div>
                            <input type="text" id="ccNumber" name="creditCardNumber"
                                   placeholder="Enter Credit Card Number" value="${form.creditCardNumber}"/>
                            <c:forEach items='${bindingResult.getFieldErrors("creditCardNumber")}' var="error">
                                <div class="error">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="outerRegDiv">
                    <div class="innerRegDiv">
                        <div>
                            <label for="ccExp">Credit Card Expiration Date:</label>
                        </div>
                        <div>
                            <input type="text" id="ccExp" name="creditCardExp" placeholder="Enter Expiration Date"
                                   value="${form.creditCardExp}"/>
                            <c:forEach items='${bindingResult.getFieldErrors("creditCardExp")}' var="error">
                                <div class="error">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="innerRegDiv">
                        <div>
                            <label for="ccCSV">Enter CSV:</label>
                        </div>
                        <div>
                            <input type="text" id="ccCSV" name="creditCardCSV" placeholder="Enter CSV Code"
                                   value="${form.creditCardCSV}"/>
                            <c:forEach items='${bindingResult.getFieldErrors("creditCardCSV")}' var="error">
                                <div class="error">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div>
                    <button type="submit" class="btn btn-outline-success" id="payButton">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="../../../pub/js/cart.js"></script>
<jsp:include page="../include/footer.jsp"/>