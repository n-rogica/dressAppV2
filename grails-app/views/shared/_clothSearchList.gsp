<!DOCTYPE html>
<html>
<head>

    <style>
    .cloth-list{
        height:500px;
        width:450px;
        border:1px solid #ccc;
        font:16px/26px Georgia, Garamond, Serif;
        overflow:auto;
        border-radius: 3px;
    }
    </style>

    <div class="cloth-list">
        <g:each in="${clothlist}">
            <g:render template="/shared/clothDescriptionBox" model="[cloth: it]"/>
        </g:each>
    </div>

</html>