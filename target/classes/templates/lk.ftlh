<!DOCTYPE html>
<html>
<head>
    <title>2RNET</title>
    <link type="text/css" href="/css/lk.css" rel="stylesheet">
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
        <div class="nadpis__verhu"> Ваш личный кабинет</div>
        <hr>
        <div class="uni">
            <div class="inform">
                <div class="nadpis__verhu__nizhe">
                    <b>Основные данные:</b> <br><br>
                </div>
                <div>
                    <img style="width: 400px;height: 400px; border: black;border-style: solid;" src="/avatar/${avatar.id}"/>
                </div><br>
                <b>Фамилия: </b> ${user.lastName}<br>
                <b>Имя: </b> ${user.name}<br>
                <b>Отчество: </b> ${user.fatherName}<br><br>
                <b>Номер телефона: </b> ${user.phoneNumber}<br>
                <b>Email: </b> ${user.email}<br><br>

                <div class="inform_podr">
                    <div class="nadpis__verhu__nizhe">
                        <b>Дополнительные данные:</b>
                    </div><br>
                    <b>О себе: </b> ${info.inform}<br><br>
                    <b>Интересы: </b> ${info.obrazovanie}<br><br>
                </div>

                <form action="/neweks" method="get">
                    <button class="create_button">Создать экскурсию</button>
                </form>
                <form action="/edit_my_info" method="get">
                    <button class="edit_button">Изменить данные</button>
                </form>
            </div>

        </div>
        <hr>
        <div class="vash__ekskurs">Ваши экскурсии:</div>
        <br>
        <#list products as product>
            <li class="product-wrapper">
                <div class="card">
                    <div>
                        <img src="/images/${product.previewImageId}" height="150px" width="150px"/>
                    </div>
                    <h3>${product.title}</h3>
                    <p class="price">${product.price} руб.</p>
                    <form action="/product/${product.id}" method="get">
                        <button class="prosmotr_button">Посмотреть</button>
                    </form>
                    <form action="/product/delete/${product.id}" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button class="delete_button">Удалить</button>
                    </form>

                </div>
            </li>
        <#else>
            <h3 style="color: gray">Экскурсий пока что нет</h3>
        </#list>

        <#if errorMessage??>
            <h2 style="color: red">${errorMessage}</h2>
        </#if>
    </div>
</div>
</body>
</html>