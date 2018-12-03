<!DOCTYPE html>

<html>
    <head>
        <meta name="layout" content="main" />
        <title>Dressapp Home</title>

    <style type="text/css">
        .suitcase-suggestions {
            width: 900px;
            margin: 10px auto;
        }
        .subItem{
            font-family: "Verdana", Times, Sans-serif;
            font-size: 20px;
            font-weight: 900;
            display: inline-block;
        }
        .suitcase-img{
            width: 300px;
            margin-left: 90px;
        }
        .grid-container {
            display: grid;
            grid-template-columns: auto auto auto;
            margin-left: 10px;
        }
        .grid-item {
            font-size: 14px;
            text-align: center;
        }
        .deco-box2 {
            margin-top: 20px;
            margin-left: 10px;
            margin-right: 10px;
            border-radius: 3px;
            background-color: #9bcbef;
            padding-bottom: 30px;
        }
        .suitcase-title{
            margin: 10px;
            font-weight: bolder;
            color: #414041;
            font-size: 25px;
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
            <div class="suitcase-suggestions">
                <div style=" display: flex">
                    <div>
                <h1>VALIJAS</h1>
                        <div style=" display: flex;flex-direction: column; width: 300px;">
                            <span><span class="subItem">- Destino: </span> ${suitcase.addresTo}</span>
                            <span>
                                <span class="subItem">- Categorias:</span>
                                <span class="grid-container">
                                    <g:each in="${categories}">
                                        <div class="grid-item"> ~ <g:message code="suitcase.category.${it}"/></div>
                                    </g:each>
                                </span>
                            </span>
                            <span><span class="subItem">- Desde:  </span>${suitcase.fromDate}</span>
                            <span><span class="subItem">- Hasta: </span> ${suitcase.toDate}</span>
                        </div>
                    </div>
                    <div>
                        <img class="suitcase-img" src="${createLink(controller: 'suitcase', action: 'showImage2')}"/>
                    </div>
                </div>
                <div class="deco-box2">
                    <div class="suitcase-title">Valija</div>
                        <g:render template="/shared/suitcase" model="[clothes: suitcase.clothes]"/>
                </div>
                <div class="deco-box2">
                    <div class="suitcase-title">Conjuntos</div>
                    <g:render template="/shared/suitcase" model="[clothes: suitcase.clothes]"/>
                </div>
            </div>
        </div>
    </body>
</html>