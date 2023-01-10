<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Various implicit EL objects</title>
    </head>
<body>
    <hl>Here are the values of various implicit EL objects:</hl1>
    <ul>
        <li>MiME types : ${header.accept}</li>
        <li>Compression types (header object is a map so we can use [] to obtain the value): ${header["accept-encoding"]}</li>
        <li>specialEmail from web.xml : ${initParam.specialEmail}</li>
        <li>HTTP request method : ${pageContext.request.method}</li>
        <li>HTTP response type : ${pageContext.response.contentType}</li>
        <li>HTTP session id : ${pageContext.session.id}</li>
        <li>HTTP context path : ${pageContext.servletContext.contextPath}</li>
    </ul>



</body>
</html