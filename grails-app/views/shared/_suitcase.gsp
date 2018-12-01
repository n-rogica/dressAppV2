<!DOCTYPE html>
<html>
<head>

    <style>
        .suitcase-cloth-list{
            height:250px;
            width:900px;
            border: 3px solid #9bcbef;
            font:16px/26px Georgia, Garamond, Serif;
            overflow:auto;
        }
    </style>

    <div class="suitcase-cloth-list">
        <g:each var="i" in="${ (0..< clothes.size()) }">
            <g:render template="/shared/clothDescriptionBox" model="[cloth: clothes.getAt(i)]"/>
        </g:each>
    </div>

</html>