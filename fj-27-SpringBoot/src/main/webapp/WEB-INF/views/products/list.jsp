<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="template" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<fmt:message key="products.list.page.title" var="title"/>
<template:page title="${title}">

<sec:authorize access="hasRole('ADMIN')">
    <a href="/products/form"><fmt:message key="products.list.new.product.link"/></a>
</sec:authorize>
<table>
    <thead>
        <th><fmt:message key="products.list.table.head.title"/> </th>
        <th><fmt:message key="products.list.table.head.number-of-pages"/></th>
        <th><fmt:message key="products.list.table.head.release-date"/></th>
        <th><fmt:message key="products.list.table.head.prices"/></th>
        <th><fmt:message key="products.list.table.head.authors"/></th>
        <th><fmt:message key="products.list.table.head.actions"/></th>
    </thead>
    <tbody>
        <c:forEach items="${pageable.iterator()}" var="product">
        <tr>
            <td>${product.title}</td>
            <td>${product.numberOfPages}</td>
            <td>${product.releaseDate}</td>
            <td>
                <ul>
                    <c:forEach items="${product.prices}" var="price">
                        <li>${price.bookType} - ${price.value}</li>
                    </c:forEach>
                </ul>
            </td><td>
                <ul>
                    <c:forEach items="${product.authors}" var="author">
                        <li>${author.name}</li>
                    </c:forEach>
                </ul>
            </td>
            <td></td>

        </tr>

        </c:forEach>
    </tbody>

</table>
<ul>
    <c:forEach begin="0" end="${pageable.totalPages}" varStatus="status">
    <li>
        <a href="?page=${status.index}">${status.index + 1}</a>
    </li>
    </c:forEach>
</ul>
</template:page>