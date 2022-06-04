package us.drullk.memer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Memer {
    @Id
    @GeneratedValue
    @Getter
    private long id;

    @Getter
    @Setter
    private String displayName;

    public Memer() {}

    public Memer(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "Memer{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
