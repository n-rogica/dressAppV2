<!DOCTYPE html>
<html>
<head>

    <style>
        .cloth-list{
            height:500px;
            width:433px;
            border:3px solid #9bcbef;
            font:16px/26px Georgia, Garamond, Serif;
            overflow:auto;
        }
    </style>

    <div class="cloth-list">
        <g:each var="i" in="${ (0..< outfit.clothes.size()) }">
            <g:render template="/shared/clothDescriptionBox" model="[cloth: outfit.clothes.getAt(i)]"/>
        </g:each>
    </div>

</html>