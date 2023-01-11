package com.testehan.openliberty.servlet.chpt14;

import com.sendgrid.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SendEmailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Email from = new Email("tdan89@yahoo.com");
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email("tdan89@yahoo.com");
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);

        // this is where the env variable that I've set on my mac is obtained and used to authentificate to their API
        // i did not manage to quickly set an env variable that could be seen by java for some reason...
        // also the whole verification process on sendgrid is complex and my account is not authorized yet to send
        // emails...
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        System.out.println("Env is " + System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }



        resp.getWriter().println("Dummy email sent via sendGrid");
    }
}
