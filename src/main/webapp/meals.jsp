<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>

${textA}
${textB}
<c:set var="meals" value="${meals}" />


<table border="1">
    <h2>
        <tr><th>Заголовок 1</th><th>Заголовок 2</th></tr>
    </h2>

    <c:forEach items="${meals}" var="meal">
        <c:out value="${meal.getDescription()}"/>
        <tr><td>  </td><td>Ячейка 3</td></tr>

        <tr><td>  </td><td>Ячейка 4</td></tr>
    </c:forEach>

</table>


<%--<c:forEach items="${friends2}" var="friend">
    <h3>
        <c:out value="${friend}"/>
    </h3>
</c:forEach>--%>

<h2>
    END 2
</h2>
</body>
</html>