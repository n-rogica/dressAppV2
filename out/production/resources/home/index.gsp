<!DOCTYPE html>
<html>
<html>
<head>
    <meta name="layout" content="main"/>
<<<<<<< HEAD
    <title>Home Page</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Dressapp</h1>        
        <ul>
          <li><g:link controller="user" action="index">Users</g:link></li>
          <li><g:link controller="wardrobe" action="index">wardrobe</g:link></li>
          <li><g:link controller="clothes" action="index">clothes</g:link></li>

=======
    <title>Dressapp Home</title>
    <link rel="stylesheet" href="${resource(file: 'home.css')}" type="text/css">
</head>

<body>

<div id="content" role="main">
    <section class="row">
        <div class="home-welcome">
            <div id="first">
                <h2><g:message code="user.welcome.label" args="[loggedUser.username]"/></h2>

                <h3><g:message code="user.welcome.day.suggestion"/></h3>
                <g:if test="${outfit != null}">
                    <g:render template="/shared/suggestion" model="[outfit: outfit]"/>
                </g:if>
                <button type="button">Otra</button>
            </div>

            <div id="second">
                <ul>
                    <li>Fecha:</li>
                    <li>Temperatura:</li>
                    <li><g:link controller="clothes" action="index">Ubicacion:</g:link></li>
                </ul>

                <div>
                    <ul style="display: inline-grid;">
                        <li class="home-buttons"><g:link controller="wardrobe" action="index">Guardarropa</g:link></li>
                        <li class="home-buttons"><g:link controller="user" action="index">Users</g:link></li>
                        <li class="home-buttons"><g:link controller="suitcase" action="index">Suitcase</g:link></li>
                        <li class="home-buttons"><g:link controller="clothes" action="index">clothes</g:link></li>
                    </ul>
                </div>
            </div>

        </div>
>>>>>>> e4ac7a039bdae12d9dc3598f9a617542da7ba2b2
    </section>
</div>

</body>
</html>
