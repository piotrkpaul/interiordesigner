<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">

    <form method="post" class="form-signin" action="j_spring_security_check">
        <h2 class="form-signin-heading">Logowanie</h2>
            <input id="email" name="j_username" type="email" class="input-block-level" placeholder="Email">
            <input type="password" name="j_password" class="input-block-level" placeholder="Hasło">
            <label class="checkbox">
                <input id="remember_me" name="_spring_security_remember_me" type="checkbox" /> Zapamiętaj mnie
            </label>
            <p>
                <input name="commit" class="btn btn-primary btn-large" type="submit" value="Zaloguj" />
            </p>
    </form>
</div> <!-- /container -->

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
