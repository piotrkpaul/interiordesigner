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
                    <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <sec:authorize access="isAuthenticated()">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Projekt <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Wszystkie projekty</a></li>
                                <li><a href="#">Twoje projekty</a></li>
                                <li><a href="#">Nowy projekt</a></li>
                            </ul>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <li><a href="${pageContext.request.contextPath}/rejestracja">Rejestracja</a></li>
                        <li><a href="${pageContext.request.contextPath}/logowanie">Logowanie</a></li>
                    </sec:authorize>
                    <li><a href="${pageContext.request.contextPath}/api">Dokumentacja API</a></li>
                    <li><a href="${pageContext.request.contextPath}/about">O aplikacji</a></li>
                </ul>
                <sec:authorize access="isAuthenticated()">
                    <div class="pull-right navUserInfo">
                        <div class="btn-group">
                            <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">
                                <sec:authentication property="principal.username" />
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/moje-konto">Ustawienia</a></li>
                                <li><a href="j_spring_security_logout">Wyloguj</a></li>
                            </ul>
                        </div>
                    </div>
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