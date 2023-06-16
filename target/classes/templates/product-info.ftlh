<!DOCTYPE html>
<html>
<head>
    <title>2RNET</title>
    <link type="text/css" href="/css/cartochka.css" rel="stylesheet">
</head>
<body>
<header class="header">
    <div class="container">
        <div class="header__inner">
            <nav></nav>
            <div class="header__logo"><a class="nav__link" href="/">2RNET</a></div>
            <nav></nav>
        </div>
    </div>
</header>


<div class="ramka">
    <div class="cartochka">
        <div class="nadpis__verhu"> Подробная информация о экскурсии</div>
        <hr>
        <div class="kartinki">
            <#list images as img>
                <img class="displayed " src="/images/${img.id}" id="img" tabindex="1"/><br><br>
            </#list>
        </div>

        <div class="inform">
            <b>Название экскурсии: </b>${product.title}<br><br>
            <b>Цена: </b>${product.price} руб.<br><br>
            <b>Город: </b> ${product.city}<br><br>
            <b>Тип экскурсии: </b>${product.classification}<br><br>
            <b>Описание: </b>${product.description}<br><br>


            <b>Экскурсовод: </b><a
                    href="/user/${product.user.id}">${product.user.name} ${product.user.fatherName}</a><br><br><br>

        </div>
    </div>
</div>
</body>
</html>