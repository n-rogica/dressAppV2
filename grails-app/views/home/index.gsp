<!DOCTYPE html>
<html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Dressapp Home</title>
    <link rel="stylesheet" href="${resource(file: 'home.css')}" type="text/css">

    <style>
        .homepage{
            width: 1000px;
            margin: 0 auto;
        }
    .container {
        position: relative;
        width: 100%;
        max-width: 400px;
    }

    .container img {
        width: 100%;
        height: auto;
    }

    .container .btn {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        -ms-transform: translate(-50%, -50%);
        background-color: #555;
        color: white;
        font-size: 20px;
        padding: 12px 24px;
        border: none;
        cursor: pointer;
        border-radius: 5px;
        text-align: center;
    }

    .container .btn:hover {
        background-color: black;
    }

        .grid-container {
            display: grid;
            grid-template-columns: auto auto auto;
            padding: 10px;
        }
        .grid-item {
            background-color: rgba(255, 255, 255, 0.8);
            border: 1px solid rgba(0, 0, 0, 0.8);
            padding: 20px;
            font-size: 30px;
            text-align: center;
        }
        .suggestion-area {
            margin-top: 20px;
            border-radius: 3px;
        }
        .suggestion-title {
            width: 300px;
            margin: 10px auto;
            font-weight: bolder;
            color: white;
            font-size: 25px;
        }
        .button-cool {
            width: 100%;
            margin-top: 10px;
            background-color: #555;
            color: white;
            font-size: 20px;
            padding: 12px 24px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            text-align: center;
        }
        .button-cool:hover {
            background-color: black;
        }
    </style>

</head>

<body>

<div class="homepage" role="main">
        <div class="home-welcome">
            <div id="first">
                <h2><g:message code="user.welcome.label" args="[loggedUser.username]"/></h2>

                <g:if test="${!loggedUser.dressed}">
                    <div class="suggestion-area" style="background-color: #646364">
                        <div class="suggestion-title "><g:message code="user.welcome.day.suggestion"/></div>

                        <g:if test="${outfit != null}">
                            <g:render template="/shared/suggestion" model="[outfit: outfit]"/>
                        </g:if>
                    </div>
                </g:if>

                <g:if test="${loggedUser.dressed}">
                    <div class="suggestion-area" style="background-color: #5c598c">
                        <div class="suggestion-title "><g:message code="user.welcome.day.currentOutfit"/></div>

                        <g:if test="${outfit != null}">
                            <g:render template="/shared/suggestion" model="[outfit: outfit]"/>
                        </g:if>
                    </div>
                </g:if>


                <g:if test="${!loggedUser.dressed}">
                    %{--<div class="grid-container options">--}%
                        %{--<g:each in="${categories}">--}%
                            %{--<div><input class="grid-item" type="checkbox" name="category" value="${it}"><g:message code="suitcase.category.${it}"/></div>--}%
                        %{--</g:each>--}%
                    %{--</div>--}%
                    <g:link controller="home" action="another"><button class="button-cool" type="button">Otra sugerencia</button></g:link>
                    <g:link controller="home" action="useOutfit"><button class="button-cool" type="button">Usar conjunto</button></g:link>
                </g:if>

                <g:if test="${loggedUser.dressed}">
                    <g:link controller="home" action="undress"><button style="background-color: #5c598c" class="button-cool"  type="button">Dejar de usar</button></g:link>
                </g:if>


            </div>

            <div id="second">
                <ul>
                    <li>Fecha:</li>
                    <li>Temperatura:</li>
                    <li><g:link controller="clothes" action="index">Ubicacion:</g:link></li>
                </ul>

                <div>
                    <ul style="display: inline-grid;">
                        <div class="container">
                            <img src="${createLink(controller: 'home', action: 'showWardrobeImg')}" alt="Guardarropa" style="width:100%">
                        <g:link controller="wardrobe" action="index"><button class="btn">Guardarropa</button></g:link>
                        </div>
                        <div class="container">
                            <img src="${createLink(controller: 'home', action: 'showTripImg')}" alt="Guardarropa" style="width:100%">
                            <g:link controller="suitcase" action="index"><button class="btn">Viaje</button></g:link>
                        </div>
                    </ul>
                </div>
            </div>

        </div>
</div>

</body>

</html>
