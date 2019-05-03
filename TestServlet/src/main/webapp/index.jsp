<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<jsp:include page="head.jsp"/>
<body>
    <jsp:include page="header.jsp"/>
    <form method="post" action="result">
        <h2>Hello, please enter two numbers</h2>
        <label>First number:</label>
        <input class="form-control" name="number1" title="first number" type="text">
        <label>Second number:</label>
        <input class="form-control" name="number2" title="second number" type="text">
        <input class="btn" type="submit" value="Submit">
    </form>
</body>
</html>
