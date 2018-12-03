<!DOCTYPE html>
<html>
<head>

    <style>
    .cloth-list{
        height:600px;
        margin: 3px;
        border:1px solid #ccc;
        font:16px/26px Georgia, Garamond, Serif;
        overflow:auto;
        background-color: white;
        border-radius: 3px;
    }
    </style>

    <div class="cloth-list">
        <g:each in="${outfitlist}">
            <g:if test="${it.visible}">
                <g:render template="/shared/outfitDescriptionBox" model="[outfit: it]"/>
            </g:if>
        </g:each>
    </div>

</html>