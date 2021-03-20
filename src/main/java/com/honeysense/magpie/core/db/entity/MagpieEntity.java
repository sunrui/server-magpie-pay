package com.honeysense.magpie.core.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class MagpieEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;
    @NotNull
    private Date createdAt;
    @NotNull
    private Date updatedAt;
}
