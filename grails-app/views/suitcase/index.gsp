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
                    <form id="trip-form" action="/suitcase/suggestion">
                        A donde vamos?<br>
                        <select name="where" form="trip-form">
                            <option value="volvo">Volvo</option>
                            <option value="saab">Saab</option>
                            <option value="opel">Opel</option>
                            <option value="audi">Audi</option>
                        </select>
                        <br>
                        Desde:<br>
                        <input type="date" id="fromDate" name="trip-start"
                               value="2018-12-04"
                               min="2018-12-03" max="2030-12-31">
                        <br>
                        Hasta:<br>
                        <input type="date" id="toDate" name="trip-end"
                               value="2018-12-04"
                               min="2018-12-03" max="2030-12-31">
                        <br>
                        Formalidad del viaje:<br>
                        <input type="text" name="formality" value="">
                        <br>
                        Maximo de maletas:<br>
                        <input type="number" name="quantity"
                               min="1" max="3" step="1" value="1">
                        <br><br>
                        <input class="suitcase-button" type="submit" value="ARMAR">
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