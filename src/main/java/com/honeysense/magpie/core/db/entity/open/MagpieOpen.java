package com.honeysense.magpie.core.db.entity.open;

import com.honeysense.magpie.core.db.entity.MagpieUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class MagpieOpen extends MagpieUserEntity {
    @OneToOne
    private MagpieOpenStackPay magpieOpenStackPay;
}
