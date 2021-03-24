package com.honeysense.magpie.core.db.entity.user;

import com.honeysense.magpie.core.db.entity.MagpieUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
public class MaggieUserLimiter extends MagpieUserEntity {
    @NotNull
    @Min(20210101)
    private Integer lastLoginVerifyDay;
    @NotNull
    @Min(0)
    private Integer loginVerifyFailedTime;
}
