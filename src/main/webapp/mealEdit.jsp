<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ru">
<head>
    <title>Meal ONE</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meal</h2>
<%--<c:set var="meal" value="${meal}" />--%>
<%--<script>
    $(function () {
        $('input[name=DateTime]').datepicker();
    });
</script>--%>
<c:set var="meal" value="${meal}" />
<jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal"/>
<form method="POST" action='meals' name="frmAddUser">
    meal ID :
    <input type="text" readonly="readonly" name="mealId"
    value="<c:out value="${meal.id}" />"/> <br/>
    <%--type="datetime-local Этот тип всплывающего календаря--%>
    <input type="datetime-local" value="${meal.dateTime}" name="dateTime" required/><br/>
    Description :
    <input type="text" name="description"
    value="<c:out value="${meal.description}" />"/> <br/>
    <input type="text" name="calories"
           value="<c:out value="${meal.calories}" />"/> <br/>
 <%--  // <input type="submit" value="Submit"/>--%>
    <button type="submit">Save</button>
    <button onclick="window.history.back()" type="button">Cancel</button>
</form>
</body>
</html>