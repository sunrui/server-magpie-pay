package com.project.spider.core.db.spider.service.impl;

import com.project.spider.core.db.spider.entity.SpiderS3Task;
import com.project.spider.core.db.spider.repository.SpiderS3TaskRepository;
import com.project.spider.core.db.spider.service.SpiderS3TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SpiderS3TaskServiceImpl implements SpiderS3TaskService {
    @Autowired
    private SpiderS3TaskRepository spiderS3TaskRepository;

    @Transactional
    @Override
    public void insertByProProductId(Integer prodProductId) {
        SpiderS3Task spiderS3Task;
        spiderS3Task = spiderS3TaskRepository.findByProductProductId(prodProductId);
        if (spiderS3Task != null) {
            return;
        }

        spiderS3Task = new SpiderS3Task();
        spiderS3Task.setProductProductId(prodProductId);
        spiderS3TaskRepository.save(spiderS3Task);
    }

    @Override
    public Page<SpiderS3Task> findAll(int page, int size) {
        return spiderS3TaskRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public void deleteById(Integer prodProductId) {
        spiderS3TaskRepository.deleteById(prodProductId);
    }
}
