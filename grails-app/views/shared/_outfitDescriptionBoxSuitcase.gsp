<!DOCTYPE html>
<html>

<style>
    .outfit-box {
        border: 2px solid black;
        width: 800px;
        margin: 5px;
        margin-left: 30px;
        background-color: white;
        overflow-y: hidden;
        overflow-x: scroll;
    }

    ::-webkit-scrollbar {
        width: 12px;
        height: 12px;
    }

    ::-webkit-scrollbar-track {
        border: 1px solid #32414d;
        border-radius: 10px;
    }

    ::-webkit-scrollbar-thumb {
        background: #8e9191;
        border-radius: 10px;
    }

    ::-webkit-scrollbar-thumb:hover {
        background: #c0e4fa;
    }

    .outfit-desc {
        margin-left: 5px ;
        font-weight: bold;
        font-size: 18px;
    }

    .outfit-details {
        font-size: 15px;
        margin-left: 5px;
    }

    .show-horizontal {
        display: inline-flex;
        vertical-align: top;
    }
</style>

<div class="outfit-box">
    <g:if test="${outfit != null}">
        <div><p class="outfit-desc ">${outfit.description}</p></div>
        <div class="show-horizontal">
        <g:each in="${outfit.clothes}">
            <g:render template="/shared/clothImg" model="[cloth:it]"/>
        </g:each>
        </div>
        <div style="display: inline-flex">
            <p class="outfit-details">Formalidad:1</p>
            <p class="outfit-details">Resistencia:2</p>
        </div>
    </g:if>
</div>

</html>