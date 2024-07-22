package org.voidmirror.own.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PortNote implements Persistable<Integer> {

    @Id
    private int id;
    private String owner;
    private Integer port;

    public PortNote(String owner, Integer port) {
        this.owner = owner;
        this.port = port;
    }

    @Override
    public String toString() {
        return "PortNote{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", port=" + port +
                '}';
    }

    @Override
    public boolean isNew() {
        return false;
    }
}
