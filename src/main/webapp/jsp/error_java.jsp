<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Error in Java</title>
    </head>
<body>
         <h1>Java Error</h1>
         <p>Java threw an exception.</p>
         <p>To continue, click the Back button.</p>
         <br>
         <br>
         <h2>Details:</h2>
         <p>Type : ${pageContext.exception["class"]}</p>
         <p>Message : ${pageContext.exception.message}</p>
         <p>Page Created by Dan :)</p>
</body>
</html