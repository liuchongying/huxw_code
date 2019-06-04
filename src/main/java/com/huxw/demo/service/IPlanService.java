package com.huxw.demo.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.huxw.demo.entity.Plan;

import java.util.List;

/**
 * @Author: huxw
 * @Date: 2019-4-3 16:11
 * @Version 1.0
 */
public interface IPlanService {
    /**
     * @return
     * @Author huxw
     * @Description 查询所有计划
     * @Date 2019-4-3 16:14
     * @Param
     **/
    List<Plan> queryPlan() throws Exception;

    /**
     * @return
     * @Author huxw
     * @Description 根据ID查询计划
     * @Date 2019-4-3 16:15
     * @Param
     **/
    Plan queryPlanById(String areaId) throws Exception;

    /**
     * @return
     * @Author huxw
     * @Description 插入计划
     * @Date 2019-4-4 22:14
     * @Param
     **/
    void insertPlan(Plan plan) throws Exception;

    /**
     * @return
     * @Author huxw
     * @Description 修改计划
     * @Date 2019-4-6 17:24
     * @Param
     **/
    void updatePlan(Plan plan) throws Exception;

    /**
     * 删除计划
     *
     * @param planId
     * @return
     * @throws Exception
     */
    int deletePlan(String planId) throws Exception;
}
