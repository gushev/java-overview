package com.springexample.websockets.controller;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

@Controller
public class WebSocketController {

  private final DateTimeFormatter dateTimeFormatter;

  public WebSocketController(DateTimeFormatter dateTimeFormatter) {
    this.dateTimeFormatter = dateTimeFormatter;
  }

  @MessageMapping("/greeting/{user}")
  @SendTo("/topic/greeting")
    public String handle(@DestinationVariable String user, Message<String> message) {
    return String.format(
        "[%s] %s: %s", dateTimeFormatter.format(Instant.now()), user, message.getPayload());
    }
}
