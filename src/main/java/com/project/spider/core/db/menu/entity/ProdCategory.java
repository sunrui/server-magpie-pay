package com.project.spider.core.db.menu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class ProdCategory {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String uuid;
	@Column(length = 12)
	private String parentNo;
	@Column(unique = true, length = 12)
	private String no;
	public static final String TOP = "0";
	@Column(length = 48)
	private String name;
	@Column(length = 24)
	private String nameZh;
	@Column(length = 64)
	private String parentUuid;
	@Column(length = 11)
	private Integer status;
	@Column(length = 11)
	private Integer idx;
	private String img;
	private Date createdAt;
	private Date updatedAt;
	private Integer isDeleted;
	private Date deletedAt;
	@Column(length = 11)
	private String productSeq;
}
