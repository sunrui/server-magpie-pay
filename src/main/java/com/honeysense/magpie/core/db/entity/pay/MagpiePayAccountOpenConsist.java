package com.honeysense.magpie.core.db.entity.pay;

import com.honeysense.magpie.core.db.entity.MagpieEntity;
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
public class MagpiePayAccountOpenConsist extends MagpieEntity {
    @NotNull
    @Enumerated(EnumType.STRING)
    private MagpiePayAccountChancel magpiePayAccountChancel;
    @NotNull
    private BigDecimal balance;
}
