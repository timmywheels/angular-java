package com.timwheeler.server;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor

public class Car {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String name;

    public void setName(String name) {
        this.name = name;
    }

    public Object getName() {
        return this.name;
    }
}

