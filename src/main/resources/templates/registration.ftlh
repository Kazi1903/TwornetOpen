<!DOCTYPE html>
<html>
<head>
    <title>2RNET</title>
    <link type="text/css" href="/css/registration.css" rel="stylesheet">
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

    <#if errorMessage??>
        <h2 style="color: red">${errorMessage}</h2>
    </#if>

    <form action="/registration" method="post" enctype="multipart/form-data">
        <div class="con">
            <header class="head-form">
                <h2>Регистрация</h2>
            </header>
            <div class="pole">
                Фамилия: <input class="form-input" type="text" name="lastName" placeholder="Петров" required><br><br>
                Имя: <input class="form-input" type="text" name="name"placeholder="Роман" required><br><br>

                Отчество: <input class="form-input" type="text" name="fatherName" placeholder="Олегович"required><br><br>
                Номер телефона: <input class="form-input" type="tel" name="phoneNumber" placeholder="+7**********" maxlength="12" required><br><br>

                Эл. почта: <input class="form-input" type="email" name="email" placeholder="***@mail.***" required><br><br>
                Пароль: <input class="form-input" type="password" name="password" placeholder="123456" minlength="6" required><br><br>
            </div>
            <div>
                Загрузите аватарку: <input type="file" name="file1" required/>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button class="log-in"> Зарегистрироваться</button>
            <a href="/login">Уже зарегистрировались? Вам сюда!</a>
        </div>
    </form>
</div>
</body>
</html>