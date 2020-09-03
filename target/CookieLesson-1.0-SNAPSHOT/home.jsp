<%@ page import="servlets.FormData" %><%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 03.09.2020
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <%
            String title = (String)request.getAttribute("title");
            out.print(title);
        %>
    </title>
</head>
<body>

<form action="/home" method="post">
    Title: <input type="text" name="name">
    <button>Save cookie</button>
</form>

<%
    FormData formData = (FormData)request.getAttribute("formData");


%>

<form action="/save" method="post">
    Insert name: <input type="text" name="name" value="<%=formData.getName()%>">
    Insert surname: <input type="text" name="surname" value="<%=formData.getSurname()%>">
    Your age: <input type="text" name="age" value="<%=formData.getAge()%>">
    Your country: <input type="text" name="country" value="<%=formData.getCountry()%>">

    Gender:
    <div>
        <input type="radio" id="male"
               name="gender" value="male" checked="<%=formData.isMale()%>">
        <label for="male">Male</label>

        <input type="radio" id="female"
               name="gender" value="female" checked="<%=!formData.isMale()%>">
        <label for="female">Female</label>
    </div>
    <button>Save</button>
</form>
</body>
</html>
