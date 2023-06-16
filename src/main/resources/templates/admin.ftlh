<!DOCTYPE html>
<html>
<head>
    <title>2RNET</title>
    <link type="text/css" href="/css/admin.css" rel="stylesheet">
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
<div class="formochka">
    <h1>Панель администратора</h1>
    <table border="1">
        <tr>
            <th>Email</th>
            <th>Номер телефона</th>
            <th>Активность</th>
            <th>Роли</th>
            <th>Бан</th>
            <th>Изменить роль</th>
            <th>Подробная информация</th>
        </tr>
        <#list users as user>
            <tr>
                <th>${user.email}</th>
                <th>${user.phoneNumber}</th>
                <th><#if user.active>true<#else>false</#if></th>
                <th><#list user.roles as role>${role}</#list></th>
                <th>
                    <form action="/admin/user/ban/${user.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" value="Бан">
                    </form>
                </th>
                <th><a href="/admin/user/edit/${user.id}">Редактировние</a></th>
                <th><a href="/user/${user.id}">Подробная информация</a></th>
            </tr>
        <#else>
            <h3>Пользователей нет</h3>
        </#list>
    </table>
</div>
</body>
</html>