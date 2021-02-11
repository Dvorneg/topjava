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
<c:set var="meal" value="${meal}" />
<%--<script>
    $(function () {
        $('input[name=dob]').datepicker();
    });
</script>--%>


<form method="POST" action='meal' name="frmAddUser">
    meal ID : <input type="text" readonly="readonly" name="mealid"
                     value="<c:out value="${meal.getId()}" />"/> <br/>
    Date/Time : <input type="text" name="DateTime"
                     value="<%--@elvariable id="meal" type=""--%>
        <c:out value="${meal.getDateTime()}" />"/> <br/>
    Description : <input type="text" name="Description"
                     value="<c:out value="${meal.getDescription()}" />"/> <br/>
    <%--    DOB : <input type="text" name="dob"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />"/> <br/>
            Email : <input type="text" name="email"
            value="<c:out value="${user.email}" />"/> <br/>--%>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>