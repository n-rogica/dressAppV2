<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'wardrobe.label', default: 'Wardrobe')}" />
        %{--<title><g:message code="default.list.label" args="[entityName]" /></title>--}%
    </head>

    <style>
        .cloth-list{
            height:500px;
            width:430px;
            border:1px solid #ccc;
            font:16px/26px Georgia, Garamond, Serif;
            overflow:auto;
        }
    </style>

    <body>
        <a href="#list-wardrobe" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                %{--<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>--}%
            </ul>
        </div>
        <section class="row">
            <section class="row">
            <div class="content scaffold-list" role="main">
                <h1><g:message code="default.list.label" args="[wardrobe.user.username]" /></h1>
                <div class="cloth-list">
                    <g:each in="${wardrobe.clothes}">
                        <g:render template="/shared/clothDescriptionBox" model="[cloth:it]"/>
                    </g:each>
                </div>
            </div>
            </section>
            <section class="row">
                <div class="content scaffold-list" role="main">
                    <h1><g:message code="default.list.label" args="[wardrobe.user.username]" /></h1>

                    <g:each in="${wardrobe.clothes}">
                        <g:render template="/shared/clothDescriptionBox" model="[cloth:it]"/>
                    </g:each>
                </div>
            </section>
        </section>
    </body>
</html>