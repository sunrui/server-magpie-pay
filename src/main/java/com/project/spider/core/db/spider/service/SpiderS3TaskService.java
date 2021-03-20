package com.project.spider.core.db.spider.service;

import com.project.spider.core.db.spider.entity.SpiderS3Task;
import org.springframework.data.domain.Page;

public interface SpiderS3TaskService {
    void insertByProProductId(Integer prodProductId);
    Page<SpiderS3Task> findAll(int page, int size);
    void deleteById(Integer id);
}
