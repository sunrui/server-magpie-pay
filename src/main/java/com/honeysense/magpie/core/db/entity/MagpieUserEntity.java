package com.honeysense.magpie.core.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@MappedSuperclass
public class MagpieUserEntity extends MagpieEntity {
    @NotBlank
    private Integer userId;
}
