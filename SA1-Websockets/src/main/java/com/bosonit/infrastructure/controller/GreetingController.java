package com.bosonit.infrastructure.controller;

import com.bosonit.domain.Greeting;
import com.bosonit.domain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws InterruptedException {
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName() + "!"));
    }
}
