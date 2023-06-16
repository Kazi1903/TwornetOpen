<!DOCTYPE html>
<html>
<head>
    <title>2RNET</title>
    <link type="text/css" href="/css/login.css" rel="stylesheet">
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
    <form action="/login" method="post">
        <div class="con">

            <header class="head-form">
                <h2>Вход</h2>
                <p>Введите Ваш логин и пароль</p>
            </header>

            <br>
            <div class="field-set">
                <input class="form-input" id="txt-input" type="email" name="username" placeholder="Имя пользователя" required>
                <br>
                <input class="form-input" type="password" placeholder="Пароль" id="pwd" name="password" required>
                <br>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button class="log-in"> Войти</button>
            </div>
            <div class="other">
                <a href="/registration">Не успели зарегистрироваться? Вам сюда!</a>
            </div>
        </div>
    </form>

</div>
</body>
</html>