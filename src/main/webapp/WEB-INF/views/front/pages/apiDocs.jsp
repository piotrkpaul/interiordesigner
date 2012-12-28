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
                Nie wszystkie, wymagane dane zostały przesłane.
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
                    <td>GET</td>
                </tr>
                <tr>
                    <td class="bold">uri</td>
                    <td>/project/</td>
                </tr>
                <tr>
                    <td class="bold">Return Type</td>
                    <td>ArrayList< ProjectDataEntity > (json)</td>
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
                [<span class="inner">   <br />
                <span>{    <br />
                "id": 2,<br />
                "ownerId": "ja@piotrpaul.pl",<br />
                "title": "Koncepcja kuchni",<br />
                "projectDescription": "Kuchnia w nismim budżecie.",<br />
                "dateOfCreation": 1355183589000,<br />
                "dateOfLastEdit": 1355183589000,<br />
                "dataWalls": "",<br />
                "dataObjects": ""<br />
                },  </span><br />
                <span>{<br />
                "id": 6,<br />
                "ownerId": "ja@piotrpaul.pl",<br />
                "title": "Pokoj dzienny",<br />
                "projectDescription": "Drogie meble do pokoju dziennego",<br />
                "dateOfCreation": 1356474406000,<br />
                "dateOfLastEdit": 1356564454000,<br />
                "dataWalls": "",<br />
                "dataObjects": ""<br />
                },  </span>  <br />
                <span>{<br />
                "id": 8,<br />
                "ownerId": "ja@piotrpaul.pl",<br />
                "title": "Biuro",<br />
                "projectDescription": "sample_description",<br />
                "dateOfCreation": 1356703319000,<br />
                "dateOfLastEdit": 1356703319000,<br />
                "dataWalls": "",<br />
                "dataObjects": ""<br />
                },  </span>
                ]  </span>
            </p>


            <b>Błąd autoryzacji.</b>
            <blockquote>
                Podano błędne dane logowania.
                <p><Strong>String :</Strong> WrongCredentionals</p>
            </blockquote>
        </div>

   </div>
    <div>
        <h3>2.2 Pobieranie danych o projekcie</h3>

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
                    <td>GET</td>
                </tr>
                <tr>
                    <td class="bold">uri</td>
                    <td>/project/<b>{id}</b></td>
                </tr>
                <tr>
                    <td class="bold">Return Type</td>
                    <td>ProjectDataEntity (json)</td>
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
                <span class="inner">{<br />
                <span>"id": 8,<br />
                "ownerId": "ja@piotrpaul.pl",<br />
                "title": "Biuro",<br />
                "projectDescription": "sample_description",<br />
                "dateOfCreation": 1356703319000,<br />
                "dateOfLastEdit": 1356703319000,<br />
                "dataWalls": "<b>ArrayList < WallItem > (JSON)</b>",<br />
                "dataObjects": "<b>ArrayList < FurnitureItem > (JSON)</b>"<br /></span>
                } </span>
            </p>

              <br />
            <b>Projekt o podanym ID nie istnieje.</b>
            <blockquote>
                Projekt, którego identyfikator został podany, nie istnieje w bazie danych.
                <p><Strong>String :</Strong> ProjectDoesntExist</p>
            </blockquote>

            <b>Brak uprawnień</b>
            <blockquote>
                Projekt, którego identyfikator został podany, należy do innego użytkownika.
                <p><Strong>String :</Strong> NotAnOwner</p>
            </blockquote>

            <b>Nie podano kompletnych danych.</b>
            <blockquote>
                Błędne dane logowania.
                <p><Strong>String :</Strong> WrongCredentionals</p>
            </blockquote>


        </div>

    </div>
</section>
