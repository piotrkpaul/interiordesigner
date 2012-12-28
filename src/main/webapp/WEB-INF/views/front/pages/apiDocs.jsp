<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="download" id="user">
    <div class="page-header">
        <h1>
            1. Użytkownik
        </h1>
    </div>
    <div>
       <h3>1.1 Logowanie</h3>

       <div>
           <p class="lead">Informacje</p>
            <table class="table table-hover">
                <tbody>
                    <tr>
                        <td class="bold">Wymaga autoryzacji ?</td>
                        <td>Nie</td>
                    </tr>
                    <tr>
                        <td class="bold">HTTP</td>
                        <td>POST</td>
                    </tr>
                    <tr>
                        <td class="bold">uri</td>
                        <td>/logowanie/</td>
                    </tr>
                    <tr>
                        <td class="bold">Return Type</td>
                        <td>UserEntity (json)</td>
                    </tr>
                </tbody>
            </table>
       </div>
       <div>
           <p class="lead">Parametry</p>

            <table class="table table-hover">
                    <thead>
                    <th>Parametr</th>
                    <th>Wartość</th>
                    <th>Wymagany?</th>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="bold param-info">username</td>
                        <td>
                            Przekazujemy adres email użytkownika.
                            <blockquote>
                                <p><strong>Przykład: </strong> ja@piotrpaul.pl</p>
                            </blockquote>
                        </td>
                        <td class="table-required">Tak</td>
                    </tr>
                    <tr>
                        <td class="bold param-info">password</td>
                        <td>
                            Hash sha1 z hasła użytkownika.
                            <blockquote>
                                <p><strong>Przykład: </strong>dd1a4bddd89315868df7009f38b2cd582b1d7a65</p>
                            </blockquote>
                        </td>
                        <td class="table-required">Tak</td>
                    </tr>
                    </tbody>
                </table>
            </div>

        <div>
            <p class="lead">Przykładowe odpowiedzi</p>

            <b>Poprawna odpowiedź</b>

                <p class="json-example">{<br />
                    "id": 1,<br />
                    "name": "Piotr",<br />
                    "surname": "Paul",    <br />
                    "password": "dd1a4bddd89315868df7009f38b2cd582b1d7a65",<br />
                    "registrationDate": 1352242800000,<br />
                    "email": "ja@piotrpaul.pl",<br />
                    "role": "ROLE_ADMIN"<br />
                    }
                </p>


            <b>Błędne dane logowania</b>
            <blockquote>
                <p><Strong>String :</Strong> WrongCredentionals</p>
            </blockquote>
        </div>
    </div>
    <div>
        <h3>1.2 Rejestracja</h3>

        <div>
            <p class="lead">Informacje</p>
            <table class="table table-hover">
                <tbody>
                <tr>
                    <td class="bold">Wymaga autoryzacji ?</td>
                    <td>Nie</td>
                </tr>
                <tr>
                    <td class="bold">HTTP</td>
                    <td>POST</td>
                </tr>
                <tr>
                    <td class="bold">uri</td>
                    <td>/user/</td>
                </tr>
                <tr>
                    <td class="bold">Return Type</td>
                    <td>UserEntity (json)</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div>
            <p class="lead">Parametry</p>

            <table class="table table-hover">
                <thead>
                <th>Parametr</th>
                <th>Wartość</th>
                <th>Wymagany?</th>
                </thead>
                <tbody>
                <tr>
                    <td class="bold param-info">username</td>
                    <td>
                        Przekazujemy adres email użytkownika.
                        <blockquote>
                            <p><strong>Przykład: </strong> ja@piotrpaul.pl</p>
                        </blockquote>
                    </td>
                    <td class="table-required">Tak</td>
                </tr>
                <tr>
                    <td class="bold param-info">password</td>
                    <td>
                        Hasło jako plaintext.
                        <blockquote>
                            <p><strong>Przykład: </strong> root</p>
                        </blockquote>
                    </td>
                    <td class="table-required">Tak</td>
                </tr>
                <tr>
                    <td class="bold param-info">name</td>
                    <td>
                        Imię użytkownika, jako plaintext.
                        <blockquote>
                            <p><strong>Przykład: </strong> Piotr</p>
                        </blockquote>
                    </td>
                    <td class="table-required">Tak</td>
                </tr>
                <tr>
                    <td class="bold param-info">surname</td>
                    <td>
                       Nazwisko użytkownika, jako plaintext.
                        <blockquote>
                            <p><strong>Przykład: </strong> Paul</p>
                        </blockquote>
                    </td>
                    <td class="table-required">Tak</td>
                </tr>
                </tbody>
            </table>
        </div>

        <div>
            <p class="lead">Przykładowe odpowiedzi</p>

            <b>Poprawna odpowiedź</b>

            <p class="json-example">{<br />
                "id": 1,<br />
                "name": "Piotr",<br />
                "surname": "Paul",    <br />
                "password": "dd1a4bddd89315868df7009f38b2cd582b1d7a65",<br />
                "registrationDate": 1352242800000,<br />
                "email": "ja@piotrpaul.pl",<br />
                "role": "ROLE_ADMIN"<br />
                }
            </p>


            <b>Nie podano kompletnych danych.</b>
            <blockquote>
                <p><Strong>String :</Strong> NotAllRequiredFields</p>
            </blockquote>
        </div>
    </div>
</section>
<section class="download" id="project">
    <div class="page-header">
        <h1>
            2. Projekty
        </h1>
    </div>
    <div>
        <h3>2.1 Pobieranie listy projektów</h3>

        <div>
            <p class="lead">Informacje</p>
            <table class="table table-hover">
                <tbody>
                <tr>
                    <td class="bold">Wymaga autoryzacji ?</td>
                    <td>TAK</td>
                </tr>
                <tr>
                    <td class="bold">HTTP</td>
                    <td>POST</td>
                </tr>
                <tr>
                    <td class="bold">uri</td>
                    <td>/project/</td>
                </tr>
                <tr>
                    <td class="bold">Return Type</td>
                    <td>List< ProjectDataEntity > (json)</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div>
            <p class="lead">Parametry</p>

            <table class="table table-hover">
                <thead>
                <th>Parametr</th>
                <th>Wartość</th>
                <th>Wymagany?</th>
                </thead>
                <tbody>
                <tr>
                    <td class="bold param-info">username</td>
                    <td>
                        Przekazujemy adres email użytkownika.
                        <blockquote>
                            <p><strong>Przykład: </strong> ja@piotrpaul.pl</p>
                        </blockquote>
                    </td>
                    <td class="table-required">Tak</td>
                </tr>
                <tr>
                    <td class="bold param-info">password</td>
                    <td>
                        Hash sha1 z hasła użytkownika.
                        <blockquote>
                            <p><strong>Przykład: </strong>dd1a4bddd89315868df7009f38b2cd582b1d7a65</p>
                        </blockquote>
                    </td>
                    <td class="table-required">Tak</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div>
            <p class="lead">Przykładowe odpowiedzi</p>

            <b>Poprawna odpowiedź</b>

            <p class="json-example">
                [

                    [
                        2,
                        1355183589000,
                        1355183589000,
                        "ja@piotrpaul.pl",
                        "fsdfdsfdsfds",
                        "fdsfdsfdsfsdfds"
                    ],
                    [
                        3,
                        1355440734000,
                        1355440734000,
                        "ja@piotrpaul.pl",
                        "Zupełnie nowy p",
                        "fdsfdsfdsfdsfdsfsdsdf"
                    ],
                    [
                        5,
                        1356473973000,
                        1356473973000,
                        "ja@piotrpaul.pl",
                        "Projekt REST",
                        "Projekt stworzony przez rest"
                    ],
                    [
                        6,
                        1356474406000,
                        1356564454000,
                        "ja@piotrpaul.pl",
                        "project title",
                        "description"
                    ]
                ]
            </p>


            <b>Nie podano kompletnych danych.</b>
            <blockquote>
                <p><Strong>String :</Strong> NotAllRequiredFields</p>
            </blockquote>
        </div>

   </div>
    </section>
