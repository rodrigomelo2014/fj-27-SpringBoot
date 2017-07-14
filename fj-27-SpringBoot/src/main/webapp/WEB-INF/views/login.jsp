<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="template" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:message key="login.page.title" var="title"/>
<template:page title="${title}">

    <form:form servletRelativeAction="/login" method="post">
        <div>
            <label for="username"><fmt:message key="login.form.username" /></label>
            <input id="username" type="text" name="username">
        </div>

        <div>
            <label for="password"><fmt:message key="login.form.password"/></label>
            <input type="password" id="password" name="password">
        </div>

        <div>
            <button type="submit"><fmt:message key="login.form.button.submit"/></button>
        </div>
    </form:form>

</template:page>