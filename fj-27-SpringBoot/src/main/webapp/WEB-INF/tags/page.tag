<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="title" required="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>

    <header>
        <sec:authorize access="isAuthenticated()">
            <sec:authentication property="principal" var="user"/>
            <div>
                <spring:message code="template.header.user.welcome" arguments="${user.username}"/>
            </div>
        </sec:authorize>
        <nav>
            <ul>
                <li>
                    <a href="?lang=pt_BR"><fmt:message key="template.header.nav.language.pt-br.link"/></a>
                </li>
                <li>
                    <a href="?lang=en_US"><fmt:message key="template.header.nav.language.en-us.link"/></a>
                </li>
                <li>
                    <a href="/authors"><fmt:message key="template.header.nav.authors.link"/></a>
                </li>
                <li>
                    <a href="/products"><fmt:message key="template.header.nav.products.link"/></a>
                </li>
                <sec:authorize access="isAuthenticated()">
                    <li>
                        <a href="/logout"><fmt:message key="template.header.nav.logout.link"/></a>
                    </li>
                </sec:authorize>
            </ul>
        </nav>
    </header>

    <jsp:doBody/>
</body>
</html>