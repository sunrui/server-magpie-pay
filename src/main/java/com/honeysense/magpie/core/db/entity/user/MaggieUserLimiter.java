package com.honeysense.magpie.core.db.entity.user;

import com.honeysense.magpie.core.db.entity.MagpieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
public class MaggieUserLimiter extends MagpieEntity {
    @NotBlank
    private Integer userId;
    @NotNull
    private Integer lastLoginVerifyDay;
    @NotNull
    private Integer loginVerifyFailedTime;
}
