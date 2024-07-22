package org.voidmirror.own.dao;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import org.voidmirror.own.model.PortNote;
import reactor.core.publisher.Mono;

@Repository
public interface PortRepository extends R2dbcRepository<PortNote, Integer> {

    Mono<PortNote> findByOwner(String owner);

}
