package cn.tedu.baking.service.impl;

import cn.tedu.baking.mapper.LogMapper;
import cn.tedu.baking.pojo.entity.Log;
import cn.tedu.baking.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public void insert(Log log) {
        logMapper.insert(log);
    }
}
