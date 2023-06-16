<!DOCTYPE html>
<html>
<head>
    <title>2RNET</title>
    <link type="text/css" href="/css/edit_user_info.css" rel="stylesheet">
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

    <form action="/edit_info_user" method="post">
        <div class="con">
            <header class="head-form">
                <h2>Изменение данных</h2>
            </header>
            <div class="pole">
                Фамилия: <input class="form-input" type="text" name="lastName" placeholder="Петров" value="${user.lastName}" required><br><br>
                Имя: <input class="form-input" type="text" name="name" placeholder="Роман" required value="${user.name}" required><br><br>
                Отчество: <input class="form-input" type="text" name="fatherName" placeholder="Олегович" value="${user.fatherName}" required><br><br>
                Номер телефона: <input class="form-input" type="text" name="phoneNumber" placeholder="+7**********" value="${user.phoneNumber}" required><br><br>

                О себе:<input class="form-input" type="text" name="inform" placeholder="Умный, смешной и харизматичный..." value="${info.inform}" required><br><br>
                Интересы:<input class="form-input" type="text" name="obrazovanie" placeholder="Мне нравится..." value="${info.obrazovanie}" required><br><br>

            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button class="log-in">Сохранить изменения</button>
        </div>
    </form>
</div>
</body>
</html>