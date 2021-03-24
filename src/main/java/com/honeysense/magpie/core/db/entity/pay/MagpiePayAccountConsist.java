package com.honeysense.magpie.core.db.entity.pay;

import com.honeysense.magpie.core.db.entity.MagpieUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class MagpiePayAccountConsist extends MagpieUserEntity {
    @NotNull
    @Enumerated(EnumType.STRING)
    private MagpiePayGateway magpiePayGateway;
    @NotNull
    private BigDecimal balance;
}
