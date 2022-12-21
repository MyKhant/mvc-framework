package com.demo.application.view;

import com.demo.framework.model.Model;
import com.demo.framework.view.View;

public class IndexView implements View {
    @Override
    public String render(Model model) {
        return "<h1>This is index view</h1> <br>" +
                "<ul>" +
                "<li><a href='/add-numbers?num1=3&num2=7'>/add-numbers?num1=3&num2=7</a></li>" +
                "<li><a href='/square-numbers?num=4'>/square-numbers?num=4</a></li>" +
                "</ul>";
    }
}
