package org.voidmirror.own.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.voidmirror.own.model.Remote;
import org.voidmirror.own.service.RemoteService;
import reactor.core.publisher.Flux;

@RestController
public class DatabaseTestController {

    @Autowired
    private RemoteService remoteService;

    @GetMapping("/all")
    public Flux<Remote> getAllRemotes() {
        return remoteService.getAllRemotes();
    }

    @GetMapping("/addrand")
    public String addRandomRemote() {
        remoteService.addRandomRemote();
        return "added random";
    }

    @GetMapping("/delete")
    public String deleteAllRemotes() {
        remoteService.deleteAllRemotes();
        return "deleted all";
    }

}
