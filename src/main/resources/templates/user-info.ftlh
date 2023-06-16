<!DOCTYPE html>
<html>
<head>
    <title>2RNET</title>
    <link type="text/css" href="/css/testuserinfo.css" rel="stylesheet">
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

<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>

<div class="ramka">
    <div class="cartochka">
        <div class="nadpis__verhu"> Подробная информация о пользователе ${user.name}</div>
        <hr>
        <div class="inform">
            <b>${user.name} ${user.lastName}</b><br><br>
            <div>
                <img style="width: 300px;height: 300px; border: black;border-style: solid;" src="/avatar/${avatar.id}"/>
            </div><br>
            <b>Номер телефона: </b> ${user.phoneNumber}<br>
            <b>Email: </b> ${user.email}<br><br>

            <b>О себе: </b>${info.inform}<br><br>
            <b>Интересы: </b>${info.obrazovanie}<br><br>

        </div>
        <hr>
        <div class="vash__ekskurs">Все экскурсии выбранного пользователя:</div>
        <br>
        <div class="spisok_ekskurs">
            <#list products as product>
                <div class="spisok_ekskurs_shtuka">
                <div class="ekskurs_ref">
                    <a class="nav__link1" href="/product/${product.id}">${product.title}</a>
                </div>
                    <div class="kartinka">
                        <img src="/images/${product.previewImageId}"/>
                    </div>
                <div class="ekskurs_price">
                    <p>${product.price} руб.</p>
                </div>
                </div>
            <#else>
                <h3 style="color: gray">Экскурсий пока что нет</h3>
            </#list>
        </div>
    </div>

<br>
    <#if polzovatel.email??>
    <div class="otziv_form">
        <!-- Форма отправки отзыва -->
        <form action="/user/${user.id}" method="post">
            <div class="otziv">
                <p class="otiv_nadpis">Напишите отзыв для ${user.name} : </p>
                <textarea class="otziv__vvod" type="text" name="review" placeholder="Напишите отзыв!" required></textarea>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <br>
                <button class="otziv_button">Отправить</button>
                <br><br>
            </div>
        </form>
    </div>
</#if>

    <!-- Форма отображения отзыва -->
    <div class="spisok_review">
        <#list comment as comments>
            <div class="user_review">
                <div class="nadpis_name_user_comment">
                    <p><b> ${comments.nameOfCreated} </b> оставил(-а) отзыв</p>
                </div>
                <div class="time_of_created">
                    <p>Дата публикации: ${comments.dateOfCreated}</p>
                </div>
                <div class="user_review_comment">
                    <p><i>${comments.review}</i></p>
                </div>
                <hr>
            </div>
        </#list>
    </div>
</div>
</body>
</html>