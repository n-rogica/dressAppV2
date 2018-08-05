<!DOCTYPE html>
<html>

<style>
.cloth-box {
    display: inline-flex;
    vertical-align: top;
    width: 375px;
    margin: 5px;
}

.cloth-desc {
    font-weight: bold;
    font-size: 18px;
}

.cloth-details {
    font-size: 15px;
}

.show-horizontal {
    border: 1px solid black;
    /*height: 100px;*/
    /*width: 140px;*/
    overflow-y: hidden;
    overflow-x: scroll;
}
</style>

<div class="cloth-box" style="overflow-y: hidden;overflow-x: scroll">
    <g:render template="/shared/clothImg"/>
    <g:render template="/shared/clothImg"/>
    <g:if test="${outfit != null}">
        <g:each in="${outfit.clothes}">
            <g:render template="/shared/clothImg"/>
        </g:each>
    </g:if>
</div>

</html>