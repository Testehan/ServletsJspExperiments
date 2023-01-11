<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/chpt2/main.css" type="text/css"/>
</head>
<body>

    <h1>The SQL Gateway</h1>
    <p>Enter an SQL statement and click the Execute button.</p>

    <p><b>SQL statement :</b></p>

    <form action="sqlGateway" method="post">
        <textarea name="sqlStatement" cols="60" rows="8">${sqlstatement}</textarea>
        <input type="submit" value="Execute">
    </form>

<p><b>SQL result:</b></p>
${sqlResult}

</body>
</html>