package org.voidmirror.own.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.voidmirror.own.model.Remote;
import org.voidmirror.own.dao.RemoteRepository;
import reactor.core.publisher.Flux;

import java.util.Random;

@Service
public class RemoteService {

    @Autowired
    private RemoteRepository remoteRepository;

    public Flux<Remote> getAllRemotes() {
        return remoteRepository.findAll();
    }

    public void addRandomRemote() {
        Remote remote = new Remote();
        remote.setIp(generateRandomIp());
        remote.setActive(true);
        remote.setControlSum("randomControlSum");
        remoteRepository.save(remote).subscribe();
    }

    public void deleteAllRemotes() {
        remoteRepository.deleteAll().subscribe();
    }

    public String generateRandomIp() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(random.nextInt(256));
        sb.append('.');
        sb.append(random.nextInt(256));
        sb.append('.');
        sb.append(random.nextInt(256));
        sb.append('.');
        sb.append(random.nextInt(256));
        return sb.toString();
    }

}
