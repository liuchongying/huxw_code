package com.huxw.demo.web;

import com.huxw.demo.entity.Plan;
import com.huxw.demo.service.IPlanService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: huxw
 * @Date: 2019-4-3 16:23
 * @Version 1.0
 */
@RestController
@RequestMapping("/plan")
@Api(value = "计划", description = "计划操作 API", position = 100, protocols = "http")
public class PlanController {

    @Autowired
    private IPlanService iPlanService;

    /*@RequestMapping(value = "/getPlans", method = RequestMethod.GET)*/
    @GetMapping(value = "/getPlans")
    public Map<String, Object> getPlans() throws Exception {
        List<Plan> list = iPlanService.queryPlan();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("plans", list);
        return map;
    }

    /*@RequestMapping(value = "/getPlanById", method = RequestMethod.GET)*/
    @GetMapping(value = "/getPlanById")
    public Map<String, Object> getPlanById(String planId) throws Exception {
        Plan plan = iPlanService.queryPlanById(planId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("plan", plan);
        return map;
    }

    @RequestMapping(value = "/insertPlan", method = {RequestMethod.POST})
    public Map<String, Object> insertPlan(@RequestBody Plan plan) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            iPlanService.insertPlan(plan);
            map.put("message", "success");
            return map;
        } catch (Exception e) {
            map.put("message", "fail");
            e.printStackTrace();
            return map;
        }
    }

    @RequestMapping(value = "/modifyPlan", method = RequestMethod.POST)
    public Map<String, Object> modifyPlan(@RequestBody Plan plan) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            iPlanService.updatePlan(plan);
            map.put("message", "success");
            return map;
        } catch (Exception e) {
            map.put("message", "fail");
            e.printStackTrace();
            return map;
        }
    }

    @RequestMapping(value = "/deletePlan", method = RequestMethod.GET)
    public Map<String, Object> deletePlan(String planId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int id = iPlanService.deletePlan(planId);
            map.put("message", "success");
            return map;
        } catch (Exception e) {
            map.put("message", "fail");
            e.printStackTrace();
            return map;
        }
    }
}
