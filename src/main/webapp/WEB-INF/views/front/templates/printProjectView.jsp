<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Interior Designer - cloud-based web application for your interior projects</title>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" />
    <style>
        body {
            padding: 10px 20px 10px 20px;
        }
        .projectTableInfo {
            width: 100%; float: left;
            margin-bottom: 20px;
            outline: 1px dashed #808080;
        }
        .projectTableInfo h1 {
            width: 100%;
            margin: 20px 20px 0px 20px;
        }
        .projectTableInfo .projectDescription {
            width: 100%;
            margin: 10px 20px 10px 20px;
            font-family: Verdana; font-size: 14px; line-height: 1.5;
        }
        .projectDataViewer {
        /* for firefox, safari, chrome, etc. */
            -webkit-transform: rotate(-90deg);
            -moz-transform: rotate(-90deg);
            /* for ie */
            filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=3);

            position: relative;
            float: left; width: 100%;
            background: url("${pageContext.request.contextPath}/resources/img/grid.png") top left;
            min-height: 1320px;
            outline: 1px solid #939393;
        }
        .projectTableInfo .dates {
            font-size: 11px;
        }

    </style>
</head>
<body data-spy="scroll" data-target=".bs-docs-sidebar" id="#top-of-page" onload="print();">
    <div class="projectTableInfo">
        <h1>
            Nazwa projektu: ${projectDataEntity.title}
        </h1>
        <p class="projectDescription">
            ${projectDataEntity.projectDescription}
        </p>
        <p class="projectDescription dates">
            Data stworzenia: ${projectDataEntity.dateOfCreation}<br />
            Data ostatniej edycji: ${projectDataEntity.dateOfLastEdit}
        </p>
    </div>
    <div class="projectDataViewer">
        ${furnitureHtml}
        ${wallsHtml}
    </div>
</body>
</html>
