package org.voidmirror.own.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SelfReceiverController {

    @PostMapping("/reccon")
    public void receiveConnection() {

    }

}
