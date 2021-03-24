package com.honeysense.magpie.core.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MagpieRepository<T> extends JpaRepository<T, Integer> {
}
