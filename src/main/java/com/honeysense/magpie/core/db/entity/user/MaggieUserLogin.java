package com.honeysense.magpie.core.db.entity.user;

import com.honeysense.magpie.core.db.entity.MagpieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
public class MaggieUserLogin extends MagpieEntity {
    @NotBlank
    private Integer userId;
    @NotNull
    @Enumerated(EnumType.STRING)
    private MaggieUserLoginType type;
    @NotBlank
    private String ip;
    @NotBlank
    private String userAgent;
}
