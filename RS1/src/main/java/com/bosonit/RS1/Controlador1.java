package com.bosonit.RS1;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controlador1 {

//    private static final String template = "Hello, %s";
//    private final AtomicLong contador = new AtomicLong();
//
//    @GetMapping("/greeting")
//    public Greeting getInfoGreeting(@RequestParam(value = "name", defaultValue = "World") String name){
//
//        return new Greeting(contador.incrementAndGet(), String.format(template, name));
//    }

    @PostMapping("/greeting")
    public Greeting getInfoGreeting(@RequestBody Greeting g, @RequestParam(value = "name") String name){
        g.setContent(name);
        return g;
    }

    @GetMapping("/user/{id}")
    public Greeting getInfoGreetingID(@RequestBody Greeting g, @PathVariable(value = "id") int id){
        g.setId(id);
        return g;
    }

    @PutMapping("/post")
    public String postVar(@RequestParam(value = "var1") int var1,
            @RequestParam(value = "var2") int var2
    )
    {
        return "Value1:" + var1 + " Var2:" + var2;
    }

}
