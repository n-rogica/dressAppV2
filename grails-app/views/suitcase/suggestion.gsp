<!DOCTYPE html>

<html>
    <head>
        <meta name="layout" content="main" />
        <title>Dressapp Home</title>

    <style type="text/css">
        .trip-image {
            width: 400px;
            height: 200px;
            margin:15px auto;
            border: 2px solid black;
        }
    </style>
    </head>
    <body>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        </ul>
    </div>
        <div>
            <div class="suitcase-form">
                <button class="suitcase-button">VER VALIJAS ARMADAS</button>
                <div class="trip-form">
                    <h1>LLEGO LA HORA DE VIAJAR!</h1>
                    <div style="width:400px; margin:0 auto;">
                        <img class="trip-image" src="${createLink(controller: 'suitcase', action: 'showImage')}"/>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>