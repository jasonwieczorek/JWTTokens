package j.m.w.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * An exposed endpoint
 */
@RestController
public class Controller {

    @RequestMapping({"/hello"})
    public String firstPage() {
        return "Hello World";
    }
}