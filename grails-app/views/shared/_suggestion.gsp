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
        <g:each var="i" in="${ (0..<5) }">
            <li>${i} <g:render template="/shared/clothDescriptionBox" /></li>
        </g:each>
    </div>

</html>