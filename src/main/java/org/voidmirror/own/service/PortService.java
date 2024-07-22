package org.voidmirror.own.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.voidmirror.own.dao.PortRepository;
import org.voidmirror.own.model.PortNote;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PortService {

    private enum portDiscover {
        MY (1, "my"),
        HOST (2, "host");

        private int id;
        private String owner;
        portDiscover(int id, String owner) {
            this.owner = owner;
        }
    }

    @Autowired
    private PortRepository portRepository;

    public Mono<PortNote> setMyPort(int port) {
        PortNote portNote = new PortNote(portDiscover.MY.id, portDiscover.MY.owner, port);
        portRepository.
        return portRepository.save(portNote);
    }

    public void setHostPort(int port) {
        PortNote portNote = new PortNote(portDiscover.HOST.id, portDiscover.HOST.owner, port);
        portRepository.save(portNote);
    }

    public Integer getMyPort(int port) {
        return portRepository.findByOwner(portDiscover.MY.owner)
                .blockOptional().orElse(new PortNote("my", -1))
                .getPort();
    }

    public Integer getHostPort(int port) {
        return portRepository.findByOwner(portDiscover.HOST.owner).blockOptional()
                .orElse(new PortNote("host", -1))
                .getPort();
    }

    public Flux<PortNote> getAllPorts() {
        return portRepository.findAll();
    }

    public void deleteAllPorts() {
        portRepository.deleteAll();
    }

}
