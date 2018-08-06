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
    height: 100%;
}
</style>

<div class="container">
    <img src="${createLink(controller: 'home', action: 'displayimage',params:[id: image.id])}"/>
</div>

</html>