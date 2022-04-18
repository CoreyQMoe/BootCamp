<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../include/header.jsp"/>

<div class="mainContent">
    <div class="innerContent">
        <h1 class="pageLabel">Welcome to</h1>
        <h1 id="logo">HeroesPOS</h1>
        <div>
            <div>
                <a href="../search/itemSearch">To View Items Click Here</a>
            </div>
            <sec:authorize access="hasAuthority('ADMIN')">
                <div>
                    <a href="../search/transactionSearch">To View Transactions Click Here</a>
                </div>
                <div>
                    <a href="../search/userSearch">To View Users Click Here</a>
                </div>
            </sec:authorize>
            <div>
<%--                <a href="../edit/editUser">To Edit Your Profile Click Here</a>--%>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../include/footer.jsp"/>
