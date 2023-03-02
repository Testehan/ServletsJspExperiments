package com.testehan.openliberty.servlet.primeFaces;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class CounterBean implements Serializable {
    private int count;

    public void increment() {
        count++;
    }

    public int getCount() {
        return this.count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
