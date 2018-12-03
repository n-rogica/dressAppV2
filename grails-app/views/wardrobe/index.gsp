<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />

        <g:set var="entityName" value="${message(code: 'wardrobe.label', default: 'Wardrobe')}" />
        %{--<title><g:message code="default.list.label" args="[entityName]" /></title>--}%

        <style>
    .wardrobe-page{
        width: 1000px;
        margin: 0 auto;
    }

        .deco-box {
            margin-top: 20px;
            margin-left: 10px;
            margin-right: 10px;
            border-radius: 3px;
            background-color: #8c6956;
        }

    .deco-box2 {
        margin-top: 20px;
        margin-left: 10px;
        margin-right: 10px;
        border-radius: 3px;
        background-color: #5f5c85;
        padding-bottom: 30px;
    }
    .suggestion-title {
        width: 400px;
        margin: 10px auto;
        font-weight: bolder;
        color: white;
        font-size: 25px;
    }
    </style>
    </head>

    <body>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                %{--<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>--}%
            </ul>
        </div>
        <section class="wardrobe-page">
            <h1><g:message code="default.list.label" args="[wardrobe.user.username]" /></h1>
            <div style="display: inline-flex">
                <section class="deco-box">
                    <div class="suggestion-title"><g:message code="default.wardrobe.cloth.label"/></div>
                    <g:render template="/shared/clothSearchList" model="[clothlist: wardrobe.clothes]"/>
                </section>
                <section class="deco-box2">
                    <div class="suggestion-title"><g:message code="default.wardrobe.outfits.label"/></div>
                    <g:render template="/shared/outfitSearchList" model="[outfitlist: wardrobe.outfits]"/>
                    %{--<button class="suitcase-button" action="deleteAll">Borrar</button>--}%
                </section>
            </div>
        </section>
    </body>
</html>