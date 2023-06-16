<!DOCTYPE html>
<html>
<head>
    <title>2RNET</title>
    <link type="text/css" href="/css/mainstyle.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.min.js"></script>
<script >
    $(document).ready(function () {
        $("select").select2();
    });
</script>


</head>
<body>
<header class="header">
    <div class="container">
        <div class="header__inner">
            <div class="header__logo"><a class="nav__link" href="/">2RNET</a></div>
            <div class="promo__nadpis">Поиск экскурсоводов</div>
            <nav class="nav">
                <#if user.email??>
                    <a class="nav__link" href="/lk">${user.name} ${user.fatherName}</a>
                    <a>
                    <form action="/logout" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button class="button-64" type="submit" role="button"><span class="text">Выйти</span></button>
                    </form>
                    </a>
                    <#if user.isAdmin()>
                        <a class="nav__link" href="/admin">Панель администратора</a>
                    </#if>
                <#else>
                    <a class="nav__link" href="/registration">Регистрация</a>
                    <a class="nav__link" href="/login">Войти</a>

                </#if>
            </nav>
        </div>
    </div>
</header>

<div class="intro">
    <div class="container">
        <div class="poiskform">
            <form action="/" method="get">

                <input type="text" name="title" value="" placeholder="Начните поиск экскурсоводов с 2RNET!">
                <button class="poiskbutton" type="submit" value="Поиск"></button>
                <hr>
                <div class="select__class">
                    <select name="city">
                        <option value="">Выберите город из списка</option>
                        <#list cities as cit >
                            <option value="${cit.name}">${cit.name}</option>
                        </#list>
                    </select>

                    <select name="classification">
                        <option value="">Выберите тип из списка</option>
                        <option value="Архитектурная">Архитектурная</option>
                        <option value="Искусствоведческая">Искусствоведческая</option>
                        <option value="Историческая">Историческая</option>
                        <option value="Литературная">Литературная</option>
                        <option value="Природоведческая">Природоведческая</option>
                        <option value="Производственная">Производственная</option>

                    </select>
                </div>
            </form>
        </div>
    </div>

    <ul class="productsclearfix">
        <#list products as product>
            <li class="product-wrapper">
                <div class="card">
                    <div>
                        <img src="/images/${product.previewImageId}" height="250px"/>
                    </div>
                    <h3>${product.title}</h3>
                    <p class="price">${product.price} руб.</p>
                    <form action="/product/${product.id}" method="get">
                        <button class="prosmotr_button">Посмотреть</button>
                    </form>
                    <#if user.isAdmin()>
                        <form action="/product/delete/${product.id}" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <button class="delete_button">Удалить</button>
                        </form>
                    </#if>
                </div>
            </li>
        <#else>
            <h3 style="color: gray">Экскурсий пока что нет</h3>
        </#list>
    </ul>
</div>
</body>
</html>