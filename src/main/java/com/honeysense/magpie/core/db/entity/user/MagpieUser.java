package com.honeysense.magpie.core.db.entity.user;

import com.honeysense.magpie.core.db.entity.MagpieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class MagpieUser extends MagpieEntity {
    @NotBlank
    @Column(unique = true)
    private String userName;
    @NotBlank
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    private MagpieUserRole role;
}
