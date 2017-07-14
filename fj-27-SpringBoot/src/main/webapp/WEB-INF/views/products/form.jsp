<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="template" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:message key="products.form.page.title" var="title"/>
<template:page title="${title}">
    <form:form servletRelativeAction="/products" commandName="product" method="post" enctype="multipart/form-data">

        <form:hidden path="id"/>

        <div>
            <form:label path="title"><fmt:message key="products.form.label.title"/></form:label>
            <form:input path="title"/>
            <form:errors path="title"/>
        </div>
        
        <div>
            <form:label path="description"><fmt:message key="products.form.label.description"/></form:label>
            <form:textarea rows="10" path="description"/>
            <form:errors path="description"/>
        </div>

        <div>
            <form:label path="numberOfPages"><fmt:message key="products.form.label.number-of-pages"/></form:label>
            <form:input path="numberOfPages"/>
            <form:errors path="numberOfPages"/>
        </div>

        <div>
            <form:label path="releaseDate"><fmt:message key="products.form.label.release-date"/></form:label>
            <form:input type="date" path="releaseDate"/>
            <form:errors path="releaseDate"/>
        </div>


        <c:forEach items="${bookTypes}" var="bookType" varStatus="status">
            <div>
                <form:label path="prices[${status.index}].value">${bookType}</form:label>
                <form:input path="prices[${status.index}].value"/>
                <form:hidden path="prices[${status.index}].bookType" value="${bookType}"/>
                <form:errors path="prices[${status.index}].value"/>
            </div>
        </c:forEach>

        <div>
            <form:label path="authors"><fmt:message key="products.form.label.authors"/></form:label>
            <form:select path="authors" items="${authors}" itemLabel="name" itemValue="id" multiple="true"/>
            <form:errors path="authors"/>
        </div>

        <div>
            <input type="file" name="summary" title="Summary">
        </div>

        <div>
            <button type="submit"><fmt:message key="products.form.submit.button"/> </button>
        </div>

    </form:form>
</template:page>