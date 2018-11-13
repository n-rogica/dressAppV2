<!DOCTYPE html>
<html>
<head>

    <style>
    .cloth-list{
        height:500px;
        width:430px;
        border:1px solid #ccc;
        font:16px/26px Georgia, Garamond, Serif;
        overflow:auto;
    }
    </style>

    <div>
        <p><g:message code="default.wardrobe.cloth.label"/></p>
    </div>
    <input type="text" name="searchWardrobe">
    <div class="cloth-list">
        <g:each in="${clothlist}">
            <g:render template="/shared/clothDescriptionBox" model="[cloth: it]"/>
        </g:each>
    </div>

</html>