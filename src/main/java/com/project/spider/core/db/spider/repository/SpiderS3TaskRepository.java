package com.project.spider.core.db.spider.repository;

import com.project.spider.core.db.spider.entity.SpiderS3Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpiderS3TaskRepository extends JpaRepository<SpiderS3Task, Integer> {
    SpiderS3Task findByProductProductId(Integer prodProductId);
}
