package com.huxw.demo.dao;

import com.huxw.demo.entity.Plan;

import java.util.List;

/**
 * @Author: huxw
 * @Date: 2019-4-2 20:57
 * @Version 1.0
 */
public interface PlanDao {
    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<Plan> queryPlan() throws Exception;

    /**
     * 根据Id列出具体区域
     *
     * @return area
     */
    Plan queryPlanById(String areaId) throws Exception;

    /**
     * 插入计划
     *
     * @return
     */
    void insertPlan(Plan plan) throws Exception;

    /**
     * 修改计划
     *
     * @param plan
     * @throws Exception
     */
    void updatePlan(Plan plan) throws Exception;

    /**
     * @return
     * @Author huxw
     * @Description 删除计划
     * @Date 2019-4-6 22:18
     * @Param
     **/
    int deletePlan(String planId) throws Exception;
}
