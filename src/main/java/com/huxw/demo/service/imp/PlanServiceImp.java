package com.huxw.demo.service.imp;

import com.huxw.demo.util.ToolUtil;
import com.huxw.demo.dao.PlanDao;
import com.huxw.demo.entity.Plan;
import com.huxw.demo.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: huxw
 * @Date: 2019-4-3 16:17
 * @Version 1.0
 */
@Service
public class PlanServiceImp implements IPlanService {
    @Autowired
    private PlanDao planDao;

    @Override
    public List<Plan> queryPlan() throws Exception {
        return planDao.queryPlan();
    }

    @Override
    public Plan queryPlanById(String areaId) throws Exception {
        return planDao.queryPlanById(areaId);
    }

    @Override
    @Transactional
    public void insertPlan(Plan plan) throws Exception {
        if (plan != null) {
            if ("".equals(plan.getFdId())) {
                String fdPlanId = ToolUtil.generateID();
                plan.setFdId(fdPlanId);
            }
            Date date = new Date();
            plan.setFdCreateDate(date);

            planDao.insertPlan(plan);
        }
    }

    @Override
    @Transactional
    public void updatePlan(Plan plan) throws Exception {
        if (plan != null && !"".equals(plan.getFdId())) {
            Date date = new Date();
            plan.setFdUpdateDate(date);

            planDao.updatePlan(plan);
        }
    }

    @Override
    public int deletePlan(String planId) throws Exception {
        return planDao.deletePlan(planId);
    }


}
