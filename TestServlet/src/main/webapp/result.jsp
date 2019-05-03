<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<jsp:include page="head.jsp"/>
<body>
    <jsp:include page="header.jsp"/>
    <h2>Our result:</h2>
    <p>
    <span class="number">${number1}</span> + <span class="number">${number2}</span> = <span class="number">${result}</span>
    </p>
    <a href="/TestServlet">Return to main page</a>

</body>
</html>
