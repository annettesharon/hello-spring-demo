package org.launchcode.hellospring.controllers;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloControllers {

    //Handles request at path /hello
    //@GetMapping("hello")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String hello(@RequestParam String name, Model model) {
//        return "Hello, "+name+"!";
        String thegreeting = "Hello, "+name+"!";
        model.addAttribute("greeting",thegreeting);
        return "hello";
    }

    @GetMapping("bye")
    @ResponseBody
    public String bye() {
        return "Hello, Bye!";
    }

    //Handles request of the form /hello?name=LaunchCode
    @GetMapping("hellop")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, "+name+"!";
    }

    //Handles request of the form /hello/LaunchCode
    @GetMapping("helloq/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name, Model model){
        model.addAttribute("greeting","Hello, "+name+"!");
        return "hello";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names",names);
        return "hello-list";
    }
//    @GetMapping("formpost")
//    @ResponseBody
//    public String helloFormPost() {
//        String html =
//                "<html>" +
//                        "<body>" +
//                        "<form method = 'post' action = 'hello'>" +
//                        "<input type = 'text' name = 'coder' />" +
//                        "<input type = 'submit' value = 'Greet Me!' />" +
//                        "</form>" +
//                        "</body>" +
//                        "</html>";
//        return html;
//    }
}
