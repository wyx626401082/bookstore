package com.xzsd.pc.classify.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.classify.entity.ClassifyDO;
import com.xzsd.pc.classify.service.ClassifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品分类管理 增删改查
 * @author WangZeBin
 * @date 2020-04-05
 */
@RestController
@RequestMapping("/classify")
public class ClassifyController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ClassifyController.class);

    @Resource
    ClassifyService classifyService;

    /**
     * 新增商品分类
     * @param classifyDO 商品分类信息集合
     * @return
     * @author WangZeBin
     * @date 2020-04-05
     */
    @PostMapping("addClassify")
    public AppResponse addClassify(ClassifyDO classifyDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            classifyDO.setCreateBy(userId);
            AppResponse appResponse = classifyService.addClassify(classifyDO);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品分类新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品分类
     * @param classId 商品分类Id
     * @return
     * @author WangZeBin
     * @date 2020-04-05
     */
    @PostMapping("deleteClassify")
    public AppResponse deleteClassify(String classId) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return classifyService.deleteClassify(classId, userId);
        } catch (Exception e) {
            logger.error("商品分类删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改用户信息
     * @param classifyDO 商品分类信息
     * @return
     * @author WangZeBin
     * @date 2020-04-05
     */
    @PostMapping("updateClassifyById")
    public AppResponse updateClassifyById(ClassifyDO classifyDO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            classifyDO.setModifyBy(userId);
            return classifyService.updateClassifyById(classifyDO);
        } catch (Exception e) {
            logger.error("修改商品分类信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 商品分类列表
     * @return
     * @author WangZeBin
     * @date 2020-04-05
     */
    @RequestMapping(value="listClassify")
    public AppResponse listClassify() {
        try {
            return classifyService.listClassify();
        } catch(Exception e) {
            logger.error("查询商品分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品分类详情
     * @param classId 商品分类编号
     * @return
     * @author WangZeBin
     * @date 2020-04-05
     */
    @RequestMapping(value="findClassifyById")
    public AppResponse findClassifyById(String classId) {
        try {
            return classifyService.findClassifyById(classId);
        } catch (Exception e) {
            logger.error("查询商品分类详情异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
