package org.voidmirror.own.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.voidmirror.own.model.PortNote;
import org.voidmirror.own.model.Remote;
import org.voidmirror.own.service.PortService;
import org.voidmirror.own.service.RemoteService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class DatabaseTestController {

    @Autowired
    private RemoteService remoteService;
    @Autowired
    private PortService portService;

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

    @GetMapping("addports")
    public Mono<PortNote> addPorts() {
        return portService.setMyPort(7456);
    }

    @GetMapping("/ports")
    public Flux<PortNote> getAllPorts() {
        return portService.getAllPorts();
    }

    @GetMapping("/delports")
    public String deleteAllPorts() {
        portService.deleteAllPorts();
        return "ports deleted";
    }

}
