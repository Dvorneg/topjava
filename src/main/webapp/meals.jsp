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

<c:set var="meals" value="${meals}" />
<jsp:useBean id="meals" scope="request" type="java.util.ArrayList<ru.javawebinar.topjava.model.MealTo>"/>

<table border = "1px" >
    <h2>
        <tr><th>Дата</th><th>Описание</th><th>Калории</th><th>Upd</th><th>Del</th></tr>
    </h2>

    <c:forEach items="${meals}" var="meal">
        <tr style="color:${ meal.isExcess()? "#dc143c" : "#228b22"}">
<%--            <td>${meal.getDateTime()}</td>--%>
            <td>${meal.getFormattedDateTime()}</td>
            <td>${meal.getDescription()}</td>
            <td>${meal.getCalories()}</td>

            <td><a href="meals?action=edit&mealId=<c:out value="${meal.getId}"/>">Update</a></td>

     <%--        <td><c:out value="${сaloriesNorm> meal.getCalories()? 'yes' : 'no'}" /></td>--%>
        </tr>
    </c:forEach>

</table>

<td><a href="meals?action=edit&mealId=<c:out value="${meal.getId()}"/>">Add</a></td>

<%--<c:forEach items="${friends2}" var="friend">
    <h3>
        <c:out value="${friend}"/>
    </h3>
</c:forEach>--%>

<h2>
<%--    <p><a href="UserController?action=insert">Add User</a></p>--%>
    END
</h2>
</body>
</html>