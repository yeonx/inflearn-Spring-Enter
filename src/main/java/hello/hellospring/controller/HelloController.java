package hello.hellospring.controller;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // ResponseBody는 http에서 body부의 이 데이터를 직접 넣어 주겠다 (html 아님)
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //만약 name이 spring이면 hello spring으로 바뀜
    }

    @GetMapping("hello-api")
    @ResponseBody //http응답에 그대로 return 데이터를 넘김 여기선 Hello라는 객체를 넘겼음.
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;

        public String getName() { //private이라서 바로 못 꺼내서 public으로 꺼냄
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

}
