package com.honeysense.magpie.core.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MagpieRepository<T> extends JpaRepository<T, Integer> {
}
