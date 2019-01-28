package com.yknet.fnlp.controller;

import com.yknet.fnlp.service.FnlpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IndexController implements ErrorController {

    @Autowired
    protected FnlpService fnlpService;

    @RequestMapping("/")
    public String index(){
        return "Welcome!";
    }
    @RequestMapping("/error")
    public String error(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        return String.format("<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>"
                        + "<div>Exception Message: <b>%s</b></div><body></html>",
                statusCode, exception == null ? "N/A" : exception.getMessage());
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @ResponseBody
    @RequestMapping(value = "/segment", method = {RequestMethod.POST, RequestMethod.GET})
    public Object segment(String sentence) {
        return this.fnlpService.segment(sentence);
    }
}
