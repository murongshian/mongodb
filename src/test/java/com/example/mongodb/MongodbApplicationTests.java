package com.example.mongodb;

import com.alibaba.fastjson.JSONObject;
import com.example.mongodb.dao.DemoDao;
import com.example.mongodb.domain.DemoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MongodbApplicationTests {
    @Autowired
    private DemoDao demoDao;

    @Test
    public void saveDemoTest() {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setId(1L);
        demoEntity.setTitle("mongodb");
        demoEntity.setDescription("中间件技术");
        demoEntity.setBy("慕容十安");
        demoEntity.setUrl("https://www.github.com/murongshian");

        demoDao.saveDemo(demoEntity);

        demoEntity = new DemoEntity();
        demoEntity.setId(2L);
        demoEntity.setTitle("mongodb");
        demoEntity.setDescription("中间件技术");
        demoEntity.setBy("慕容十安");
        demoEntity.setUrl("https://www.github.com/murongshian");

        demoDao.saveDemo(demoEntity);
    }

    @Test
    public void removeDemoTest() {
        demoDao.removeDemo(2L);
    }

    @Test
    public void updateDemoTest() {

        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setId(1L);
        demoEntity.setTitle("mongodb+springboot");
        demoEntity.setDescription("中间件技术");
        demoEntity.setBy("慕容十安");
        demoEntity.setUrl("https://www.github.com/murongshian");
        demoDao.updateDemo(demoEntity);
    }

    @Test
    public void findDemoByIdTest() {

        DemoEntity demoEntity = demoDao.findDemoById(1L);

        System.out.println(JSONObject.toJSONString(demoEntity));
    }
}