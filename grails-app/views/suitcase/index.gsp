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
        .title{
            margin-left: 10px;
        }
        .options{
            margin-left: 16px;
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
                    <h1 class="title">LLEGO LA HORA DE VIAJAR!</h1>
                    <div style="width:400px; margin:0 auto;">
                        <img class="trip-image" src="${createLink(controller: 'suitcase', action: 'showImage')}"/>
                    </div>
                    <form id="trip-form" action="/suitcase/suggestion">
                        <h2 class="title">Donde viajas:</h2>
                        <select  class="options" name="where" form="trip-form">
                            <option value="Buenos Aires">Buenos Aires</option>
                            <option value="Miami">Miami</option>
                            <option value="Moscu">Moscu</option>
                            <option value="Tokyo">Tokyo</option>
                        </select>
                        <br>
                        <h2 class="title">Desde:</h2>
                        <input class="options" type="date" id="fromDate" name="trip-start"
                               value="2018-12-04"
                               min="2018-12-03" max="2030-12-31">
                        <br>
                        <h2 class="title">Hasta:</h2>
                        <input class="options" type="date" id="toDate" name="trip-end"
                               value="2018-12-04"
                               min="2018-12-03" max="2030-12-31">
                        <br>
                        <h2 class="title">Seleccione acorde al tipo de viaje:</h2>
                        <div class="grid-container options">
                            <g:each in="${categories}">
                                <div><input class="grid-item" type="checkbox" name="category" value="${it}"><g:message code="suitcase.category.${it}"/></div>
                            </g:each>
                        </div>
                        <h2 class="title">Maximo de valijas:</h2>
                        <input class="options" type="number" name="quantity"
                               min="1" max="3" step="1" value="1">
                        <br><br>
                        <input style="width: 100px; margin: 10px 200px" class="suitcase-button" type="submit" value="ARMAR">
                    </form>
                </div>

            </div>
        </div>
        %{--<a href="#list-suitcase" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>--}%
        %{--<div class="nav" role="navigation">--}%
            %{--<ul>--}%
                %{--<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>--}%
                %{--<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>--}%
            %{--</ul>--}%
        %{--</div>--}%
        %{--<div id="list-suitcase" class="content scaffold-list" role="main">--}%
            %{--<h1><g:message code="default.list.label" args="[entityName]" /></h1>--}%
            %{--<g:if test="${flash.message}">--}%
                %{--<div class="message" role="status">${flash.message}</div>--}%
            %{--</g:if>--}%
            %{--<f:table collection="${suitcaseList}" />--}%

            %{--<div class="pagination">--}%
                %{--<g:paginate total="${suitcaseCount ?: 0}" />--}%
            %{--</div>--}%
        %{--</div>--}%
    </body>
</html>