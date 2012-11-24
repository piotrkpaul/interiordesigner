<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#contact">Contact</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li class="divider"></li>
                            <li class="nav-header">Nav header</li>
                            <li><a href="#">Separated link</a></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>
                </ul>
                <sec:authorize access="isAuthenticated()">
                    Jesteś zalogowany jako <a href="#"><sec:authentication property="principal.username" /></a>
                    <a class="btn  pull-right" href="j_spring_security_logout" />Wyloguj</a>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <form method="post" class="signin navbar-form pull-right" action="j_spring_security_check">
                        <input id="email" name="j_username" type="email" class="span2" placeholder="Email" />
                        <input id="password" name="j_password" type="password" class="span2" placeholder="Hasło" />
                        <input name="commit" class="btn" type="submit" value="Zaloguj" />
                    </form>
                </sec:authorize>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>