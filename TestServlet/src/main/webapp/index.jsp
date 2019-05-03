<%@ page language="java" %>
<html lang="en">
    <head>
          <title>
          <%= request.getAttribute("page_name") %>
          </title>
    </head>
<body>
    <h1>Welcome to ${page_name}</h1>
    <form method="post" action="result">
        <h2>Hello, please enter two numbers</h2>
        <input title="first number" type="number" name="number1" />
        <input title="second number" type="number" name="number2" />
        <input type="submit" value="Submit">
    </form>
</body>
</html>
