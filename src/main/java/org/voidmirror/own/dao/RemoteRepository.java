package org.voidmirror.own.dao;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import org.voidmirror.own.model.Remote;

import java.util.UUID;

@Repository
public interface RemoteRepository extends R2dbcRepository<Remote, UUID> {

}
