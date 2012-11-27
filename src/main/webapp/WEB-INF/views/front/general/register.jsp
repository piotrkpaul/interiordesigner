<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <sf:form method="post" class="form-signin" commandName="userEntity">
        <h2 class="form-signin-heading">Rejestracja</h2>
        <sf:errors path="name" cssClass="alert alert-error" element="div" />
        <sf:input path="name" min="3" maxlength="15" id="user_name" class="input-block-level" placeholder="Imię"/>
        <sf:errors path="surname" cssClass="alert alert-error" element="div" />
        <sf:input path="surname" min="3" maxlength="30" id="user_surname" class="input-block-level"
                  placeholder="Nazwisko"/>
        <sf:errors path="email" cssClass="alert alert-error" element="div" />
        <sf:input path="email" min="5" maxlength="64" id="user_email" class="input-block-level" placeholder="Email"/>
        <sf:errors path="password" cssClass="alert alert-error" element="div" />
        <sf:input path="password" min="3" maxlength="60" id="user_pasword" class="input-block-level" placeholder="Hasło"/>
        <input type="submit" value="Rejestracja" class="btn btn-success" />
    </sf:form>

</div>
<!-- /container -->

<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
<style type="text/css">
    body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
    }
</style>
</html>
