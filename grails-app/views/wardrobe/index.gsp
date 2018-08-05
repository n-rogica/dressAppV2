<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'wardrobe.label', default: 'Wardrobe')}" />
        %{--<title><g:message code="default.list.label" args="[entityName]" /></title>--}%
    </head>

    <style>
        .cloth-listt{
            height:500px;
            width:430px;
            border:1px solid #ccc;
            font:16px/26px Georgia, Garamond, Serif;
            overflow:auto;
        }

    </style>

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
                <g:render template="/shared/outfitSearchList" model="[outfitlist: wardrobe.outfits]"/>
            </section>
            </div>
        </section>
    </body>
</html>