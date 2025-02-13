package com.honeysense.magpie.core.db.entity.pay;

import com.honeysense.magpie.core.db.entity.MagpieUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class MaggiePayOrder extends MagpieUserEntity {
    @NotNull
    private MagpiePayGateway magpiePayGateway;
    @NotNull
    private String customerId;
    @NotBlank
    private String payload;
    @NotNull
    @Min(0)
    private BigDecimal amount;
}
