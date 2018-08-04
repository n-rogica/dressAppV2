<!DOCTYPE html>
<html>
<head>

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
    <div>
        <p class="cloth-desc">Descripcion</p>
        <p class="cloth-desc">Color</p>
        <p class="cloth-details">Formalidad:</p>
        <p class="cloth-details">Resistencia:</p>
    </div>
</div>

</html>