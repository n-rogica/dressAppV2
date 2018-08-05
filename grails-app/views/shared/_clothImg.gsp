<!DOCTYPE html>
<html>

<style>
.container {
    margin: 4px;
    width: 150px;
    height: 100px;
}

/* resize images */
.container img {
    width: 100%;
    height: auto;
}
</style>

<div class="container">
    <img src="${createLink(controller: 'home', action: 'showImage')}"/>
</div>

</html>