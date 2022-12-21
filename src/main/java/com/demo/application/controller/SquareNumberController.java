package com.demo.application.controller;

import com.demo.application.view.SquareNumberView;
import com.demo.framework.controller.ControllerMapping;
import com.demo.framework.controller.IController;
import com.demo.framework.ds.ModelAndView;
import com.demo.framework.model.Model;
import com.demo.framework.model.SimpleModel;
import jakarta.servlet.http.HttpServletRequest;

@ControllerMapping("/square-nubersm")
public class SquareNumberController implements IController {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        int num = Integer.parseInt(request.getParameter("num"));
        int result = num * num ;
        Model model = new SimpleModel();
        model.set("num", String.valueOf(num));
        model.set("result", String.valueOf(result));
        return new ModelAndView(
                model,
                new SquareNumberView()
        );
    }
}
