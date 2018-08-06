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

    <div class="cloth-list">
        <g:each in="${outfitlist}">
            <g:render template="/shared/outfitDescriptionBox" model="[outfit: it]"/>
        </g:each>
    </div>

</html>