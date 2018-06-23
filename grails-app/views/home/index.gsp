<!DOCTYPE html>
<html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Dressapp Home</title>
</head>
<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h2><g:message code="user.welcome.label" args="[loggedUser.username]" /> </h2>
        <ul>
          <li><g:link controller="user" action="index">Users</g:link></li>
          <li><g:link controller="wardrobe" action="index">wardrobe</g:link></li>
          <li><g:link controller="clothes" action="index">clothes</g:link></li>          
        </ul>
    </section>
</div>

</body>
</html>
