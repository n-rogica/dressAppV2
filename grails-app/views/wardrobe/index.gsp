<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />

        <style type="text/css">
            .dropArea {
                width: 500px;
                height: 300px;
                padding: 10px;
                border: 1px solid #aaaaaa;
                overflow:auto;
            }
        </style>
        <g:set var="entityName" value="${message(code: 'wardrobe.label', default: 'Wardrobe')}" />
        %{--<title><g:message code="default.list.label" args="[entityName]" /></title>--}%

        <script>
            function allowDrop(ev) {
                ev.preventDefault();
            }

            function drop(ev) {
                ev.preventDefault();
                var data = ev.dataTransfer.getData("text");
                ev.target.appendChild(document.getElementById(data));
            }
        </script>
    </head>

    <body>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                %{--<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>--}%
            </ul>
        </div>
        <section class="row">
            <h1><g:message code="default.list.label" args="[wardrobe.user.username]" /></h1>
            <div style="display: inline-flex">
                <section class="row">
                    <g:render template="/shared/clothSearchList" model="[clothlist: wardrobe.clothes]"/>
                %{--</div>--}%
                </section>
                <section class="row">
                    <h1>ARMA TU OUTFIT</h1>
                        <div class="dropArea" id="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
                    <br>
                    <p><g:message code="default.wardrobe.outfits.label"/></p>
                    <div style="display: inline-flex; margin:10px;width:100%">
                    <input type="text" name="searchWardrobe">
                        <button>Buscar</button>
                    </div>
                    <g:render template="/shared/outfitSearchList" model="[outfitlist: wardrobe.outfits]"/>
                    <button class="suitcase-button" action="deleteAll">Borrar</button>
                </section>
            </div>
        </section>
    </body>
</html>