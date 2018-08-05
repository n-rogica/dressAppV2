<!DOCTYPE html>
<html>

<style>
    .cloth-box{
        border: 2px solid black;
        display: inline-flex;
        vertical-align: top;
        width: 375px;
        margin: 5px;
    }

    .cloth-desc{
        font-weight: bold;
        font-size: 18px;
    }
    .cloth-details{
        font-size: 15px;
    }
</style>

<div class="cloth-box">
    <g:render template="/shared/clothImg" />
    <g:if test="${cloth != null}">
        <div>
            <p class="cloth-desc">${cloth.name}</p>
            <p class="cloth-desc">${cloth.mainColour}</p>
            <p class="cloth-details">Formalidad:${cloth.formality}</p>
            <p class="cloth-details">Resistencia:${cloth.coldResistance}</p>
        </div>
    </g:if>
</div>

</html>