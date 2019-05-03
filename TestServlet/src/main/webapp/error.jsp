<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<jsp:include page="head.jsp"/>
<body>
    <jsp:include page="header.jsp"/>
    <h2>ERROR!</h2>
    <h3>You entered wrong numbers. Error message:</h3>
    <p class="error">
    ${error_mess}
    </p>
    <p>
    <label>First number: </label><span class="number">${number1}</span>
    <label>Second number: </label><span class="number">${number2}</span>
    </p>
    <a href="/TestServlet">Return to main page</a>
</body>
</html>
