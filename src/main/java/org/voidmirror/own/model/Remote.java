package org.voidmirror.own.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class Remote {

    @Id
    @Getter
    @Setter
    private UUID uid;
    @Getter
    @Setter
    private String ip;
    @Getter
    @Setter
    private String controlSum;
    @Getter
    @Setter
    private boolean active;

    @Override
    public String toString() {
        return "Remote{" +
                "uid=" + uid +
                ", ip='" + ip + '\'' +
                ", controlSum='" + controlSum + '\'' +
                ", active=" + active +
                '}';
    }
}
