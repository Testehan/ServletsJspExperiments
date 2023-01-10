<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Thanks for registering</title>
    </head>
<body>
    <hl>Thanks for joining our email list</hl1>

    <p>Here is the information that you entered:</p>

    <label>Email:</label>
    <span>${user.email}</span><br>

    <label>First Name:</label>
    <span>${user.firstName}</span><br>

    <label>Last Name:</label>
    <span>${user.lastName} </span> <br>

    <p>To enter another email address, click on the Back button in your browser or the Return button shown below.</p>

    <form action="html/registerEmail.html" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>


    <%@ include file="includes/footer.jsp" %>

</body>
</html