package com.honeysense.magpie.core.db.entity.user;

import com.honeysense.magpie.core.db.entity.MagpieUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class MagpieUserInfo extends MagpieUserEntity {
    @NotBlank
    @Column(unique = true)
    private String customerName;
    @NotBlank
    private String customerPhone;
}
