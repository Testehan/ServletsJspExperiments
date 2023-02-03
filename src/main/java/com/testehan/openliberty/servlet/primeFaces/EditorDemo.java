package com.testehan.openliberty.servlet.primeFaces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("editor")
@RequestScoped
public class EditorDemo {
    private String content;

    public EditorDemo(){}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        System.out.println(content);
    }
}
