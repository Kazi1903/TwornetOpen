<!DOCTYPE html>
<html>
<head>
    <title>2RNET</title>
    <link type="text/css" href="/css/neweks.css" rel="stylesheet">
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

<div class="overlay">
    <form action="/product/create" method="post" enctype="multipart/form-data">
        <div class="con">

            <header class="head-form">
                <h2>Создать новую экскурсию</h2>
            </header>

            <div class="pole">
                <div class="nadpisiform">
                    Название экскурсии: <input type="text" name="title"
                                               placeholder="Увлекательная экскурсия..." required/><br><br>
                    Описание: <input type="text" name="description" placeholder="Проведу по местам...."
                                     required/><br><br>
                    Цена: <input type="number" name="price" placeholder="₽₽₽₽₽" required/><br><br>
                    <select name="city" required>
                        <option value="">Выберите город из списка</option>
                        <#list cities as cit >
                            <option value="${cit.name}">${cit.name}</option>
                        </#list>
                    </select>

                </div>
                <div class="claseks">
                    <p>Классифицируйте экскурсию:</p>
                    <div class="form_radio_btn">
                        <input class="vibor" id="radio-1" type="radio" name="classification" value="Архитектурная"
                               checked>
                        <label for="radio-1">Архитектурная</label>
                    </div>
                    <div class="form_radio_btn">
                        <input class="vibor" id="radio-2" type="radio" name="classification" value="Искусствоведческая">
                        <label for="radio-2">Искусствоведческая</label>
                    </div>
                    <div class="form_radio_btn">
                        <input class="vibor" id="radio-3" type="radio" name="classification" value="Историческая">
                        <label for="radio-3">Историческая</label>
                    </div>
                    <div class="form_radio_btn">
                        <input class="vibor" id="radio-4" type="radio" name="classification" value="Литературная">
                        <label for="radio-4">Литературная</label>
                    </div>
                    <div class="form_radio_btn">
                        <input class="vibor" id="radio-5" type="radio" name="classification" value="Природоведческая">
                        <label for="radio-5">Природоведческая</label>
                    </div>
                    <div class="form_radio_btn">
                        <input class="vibor" id="radio-6" type="radio" name="classification" value="Производственная">
                        <label for="radio-6">Производственная</label>
                    </div>
                </div>
                Первая фотография: <input type="file" name="file1" required/>
                Вторая фотография: <input type="file" name="file2" required/>
                Третья фотография: <input type="file" name="file3" required/>

            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button class="log-in">Добавить экскурсию</button>
        </div>
    </form>
</div>
</body>
</html>