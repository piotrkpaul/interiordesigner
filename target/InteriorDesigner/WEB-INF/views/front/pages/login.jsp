<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!-- Main hero unit for a primary marketing message or call to action -->
<div class="hero-unit">
    <h1>Logowanie</h1>

    <p>Za pomocą tego formularza, możesz zalogować sie do naszego systemu.</p>

    <form method="post" class="signin" action="j_spring_security_check">

        <p>
            Email: <input id="email" name="j_username" type="email" />
        </p>
        <p>
            Hasło: <input id="password" name="j_password" type="password" />
        </p>
        <p>
            Zapamiętaj <input id="remember_me" name="_spring_security_remember_me" type="checkbox" />
        </p>
        <p>
            <input name="commit" class="btn btn-primary btn-large" type="submit" value="Zaloguj" />
        </p>

    </form>

</div>
