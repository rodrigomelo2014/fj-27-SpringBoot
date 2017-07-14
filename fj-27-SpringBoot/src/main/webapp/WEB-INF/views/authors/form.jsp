<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="template" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:message key="authors.form.page.title" var="title"/>
<template:page title="${title}">
    <form:form servletRelativeAction="/authors" commandName="author" method="post">

        <form:hidden path="id"/>

        <div>
            <form:label path="name"><fmt:message key="authors.form.label.name"/></form:label>
            <form:input path="name"/>
            <form:errors path="name"/>
        </div>

        <div>
            <button type="submit"><fmt:message key="authors.form.submit.button"/> </button>
        </div>

    </form:form>
</template:page>