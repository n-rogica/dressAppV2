<!DOCTYPE html>
<html>
<head>

    <style>
    .suitcase-cloth-list{
        height:250px;
        border: 3px solid #414041;
        font:16px/26px Georgia, Garamond, Serif;
        overflow:auto;
        margin: 3px;
    }
    </style>

    <div class="suitcase-cloth-list">
        <g:each var="i" in="${ (0..< outfits.size()) }">
            <g:render template="/shared/outfitDescriptionBoxSuitcase" model="[outfit: outfits.getAt(i)]"/>
        </g:each>
    </div>

</html>