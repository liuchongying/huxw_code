package com.huxw.demo.dao;

import com.huxw.demo.entity.Plan;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @Author: huxw
 * @Date: 2019-4-2 21:02
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanDaoTest {

    @Autowired
    private PlanDao planDao;

    @Test
    public void testQuerryPlan() throws Exception {
        List<Plan> list = planDao.queryPlan();
        System.out.println(list);
    }

}