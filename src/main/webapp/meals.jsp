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


<table border = "1px" >
    <h2>
        <tr><th>Дата</th><th>Описание</th><th>Калории</th><th>Upd</th><th>Del</th></tr>
    </h2>


    <c:forEach items="${meals}" var="meal">
        <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
        <tr style="color:${ meal.excess? "#dc143c" : "#228b22"}">
            <td>${meal.formattedDateTime}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="meals?action=edit&mealId=<c:out value="${meal.getId()}"/>">Update</a></td>
            <td><a href="meals?action=del&mealId=<c:out value="${meal.getId()}"/>">Del</a></td>
     <%--        <td><c:out value="${сaloriesNorm> meal.getCalories()? 'yes' : 'no'}" /></td>--%>
        </tr>
    </c:forEach>

</table>

<%--<td><a href="meals?action=edit&mealId=<c:out value="${meal.getId()}"/>">Add</a></td>--%>

<%--<c:forEach items="${friends2}" var="friend">
    <h3>
        <c:out value="${friend}"/>
    </h3>
</c:forEach>--%>

<h2>
    <p><a href="meals?action=insert">Add User</a></p>
    END
</h2>
</body>
</html>