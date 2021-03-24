package com.honeysense.magpie.core.db.entity.open;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.honeysense.magpie.core.db.entity.MagpieUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class MagpieOpenStackPay extends MagpieUserEntity {
    @JsonIgnore
    @NotNull
    @JoinColumn
    @OneToOne
    private MagpieOpen magpieOpen;
    @NotBlank
    private String publicKey;
    @NotBlank
    private String secretKey;
    @NotNull
    private Boolean enable;
}
