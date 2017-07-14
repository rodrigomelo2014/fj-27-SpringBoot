<%@taglib tagdir="/WEB-INF/tags" prefix="template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<fmt:message key="authors.list.page.title" var="title"/>
<template:page title="${title}">
    <sec:authorize access="hasRole('ADMIN')">
        <a href="/authors/form"><fmt:message key="authors.list.new.author.link"/></a>
    </sec:authorize>

<table>
    <thead>
        <th><fmt:message key="authors.list.table.head.name"/></th>
        <th><fmt:message key="authors.list.table.head.actions"/></th>
    </thead>
    <tbody>
        <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.name}</td>
            <td></td>

        </tr>
        </c:forEach>
    </tbody>
</table>
</template:page>