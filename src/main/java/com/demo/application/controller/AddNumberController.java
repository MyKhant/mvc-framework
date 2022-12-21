package com.demo.application.controller;

import com.demo.application.view.AddNumberView;
import com.demo.framework.controller.ControllerMapping;
import com.demo.framework.controller.IController;
import com.demo.framework.ds.ModelAndView;
import com.demo.framework.model.Model;
import com.demo.framework.model.SimpleModel;
import com.demo.framework.view.View;
import jakarta.servlet.http.HttpServletRequest;

@ControllerMapping(value = "/add-numbers")
public class AddNumberController implements IController {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int result = num1 + num2;
        Model model = new SimpleModel();
        model.set("num1",String.valueOf(num1));
        model.set("num2",String.valueOf(num2));
        model.set("result",String.valueOf(result));

        return new ModelAndView(
                model,
                new AddNumberView()
        );
    }
}
