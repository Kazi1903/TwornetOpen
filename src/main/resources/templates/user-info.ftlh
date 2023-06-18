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
            <b>${user.name} ${user.lastName}</b>
            <br><br>
            <div>
                <img style="width: 300px;height: 300px; border: black;border-style: solid;" src="/avatar/${avatar.id}"/>
                <#if info.umor!=0 || info.marshrut!=0 || info.punktualnost!=0 || info.opryatnost!=0 || info.mestnost!=0 || info.beseda!=0>
                <a style="font-size: 25px;"><b>Достижения:  </b><a>
                        <#if info.umor!=0><img class="icon-dostizh" src="/img/umor.png"></#if>
                        <#if info.marshrut!=0><img class="icon-dostizh" src="/img/marshrut.png"></#if>
                        <#if info.punktualnost!=0><img class="icon-dostizh" src="/img/punktualnost.png"></#if>
                        <#if info.opryatnost!=0><img class="icon-dostizh" src="/img/opryatnost.png"></#if>
                        <#if info.mestnost!=0><img class="icon-dostizh" src="/img/mestny.png"></#if>
                        <#if info.beseda!=0><img class="icon-dostizh" src="/img/beseda.png"></#if>
                    </a>
                    </#if>
            </div>
            <br>
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
                    <div>
                        <label class="punkt" for="umor">
                            <img class="kar_har" src="/img/umor.png">
                            Юмор
                        </label>
                        <input class="rad" type="checkbox" name="umor" id="umor" value="1">

                        <label class="punkt" for="marshrut">
                            <img class="kar_har" src="/img/marshrut.png">
                            Отличный маршрут
                        </label>
                        <input class="rad" type="checkbox" name="marshrut" id="marshrut" value="1">

                        <label class="punkt" for="punktualnost">
                            <img class="kar_har" src="/img/punktualnost.png">
                            Пунктуальность
                        </label>
                        <input class="rad" type="checkbox" name="punktualnost" id="punktualnost" value="1">
                    </div>
                    <br> <br> <br>
                    <div>
                        <label class="punkt" for="opryatnost">
                            <img class="kar_har" src="/img/opryatnost.png">
                            Опрятность
                        </label>
                        <input class="rad" type="checkbox" name="opryatnost" id="opryatnost" value="1">

                        <label class="punkt" for="mestnost">
                            <img class="kar_har" src="/img/mestny.png">
                            Знание местности
                        </label>
                        <input class="rad" type="checkbox" name="mestnost" id="mestnost" value="1">

                        <label class="punkt" for="beseda">
                            <img class="kar_har" src="/img/beseda.png">
                            Приятная беседа
                        </label>
                        <input class="rad" type="checkbox" name="beseda" id="beseda" value="1">
                    </div>
                    <br> <br> <br> <br>
                    <textarea class="otziv__vvod" type="text" name="review" placeholder="Напишите отзыв!"
                              required></textarea>
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
                    <p><b> ${comments.nameOfCreated} </b> оставил(-а) отзыв   <#if comments.umor!=0><img class="icon-otziv" src="/img/umor.png"></#if>
                        <#if comments.marshrut!=0><img class="icon-otziv" src="/img/marshrut.png"></#if>
                        <#if comments.punktualnost!=0><img class="icon-otziv" src="/img/punktualnost.png"></#if>
                        <#if comments.opryatnost!=0><img class="icon-otziv" src="/img/opryatnost.png"></#if>
                        <#if comments.mestnost!=0><img class="icon-otziv" src="/img/mestny.png"></#if>
                        <#if comments.beseda!=0><img class="icon-otziv" src="/img/beseda.png"></#if>

                    </p>
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