<!DOCTYPE html>
<html>

<style>
    .cloth-box{
        border: 2px solid black;
        display: inline-flex;
        vertical-align: top;
        width: 400px;
        margin: 5px;
    }

    .cloth-box:hover{
        background-color: #d3f1ff;
    }

    .cloth-desc{
        font-weight: bold;
        font-size: 18px;
    }
    .cloth-details{
        font-size: 13px;
    }
    .cloth-details-title{
        font-weight: bold;
    }

</style>

<div id="${cloth.name+cloth.id}" draggable="true" ondragstart="drag(event)" class="cloth-box">
    <g:if test="${cloth != null}">
        <g:render template="/shared/clothImg" model="[cloth: cloth]"/>
        <div>
            <p class="cloth-desc">${cloth.name}</p>
            <p class="cloth-desc">${cloth.mainColour}</p>
            <p class="cloth-details "><span class="cloth-details-title">Formalidad: </span><g:message code="cloth.formality.${cloth.formality}"/></p>
            <p class="cloth-details"><span class="cloth-details-title">Resistencia: </span><g:message code="cloth.coldResistance.${cloth.coldResistance}"/></p>
            <p class="cloth-details"><span class="cloth-details-title">Usos: </span>${cloth.usesCount}</p>
        </div>
        <div></div>
    </g:if>
</div>

<script>
    function drag(ev) {
        ev.dataTransfer.setData("text", ev.target.id);
    }
</script>

</html>