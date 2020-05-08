package com.xzsd.pc.classify.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.classify.dao.ClassifyDao;
import com.xzsd.pc.classify.entity.ClassifyDO;
import com.xzsd.pc.classify.entity.ClassifyVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类实现类
 * @author WangZeBin
 * @date 2020-04-05
 */
@Service
public class ClassifyService {
    @Resource
    ClassifyDao classifyDao;

    /**
     * 新增商品分类
     * @param classifyDO
     * @return
     * @author WangZebin
     * @date 2020-04-05
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addClassify(ClassifyDO classifyDO) {
        classifyDO.setClassId(StringUtil.getCommonCode(2));
        classifyDO.setIsDeleted(0);
        int count = classifyDao.addClassify(classifyDO);
        if(0 == count) {
            return AppResponse.bizError("新增商品分类失败，请重试！");
        }
        return AppResponse.success("新增商品分类成功！");
    }

    /**
     * 删除商品分类
     * @param classId 商品分类编号
     * @param userId 当前用户编号
     * @return
     * @author WangZebin
     * @date 2020-04-05
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteClassify(String classId, String userId) {
        AppResponse appResponse = AppResponse.success("删除商品分类成功！");
        //查询商品分类是否存在子类
        int countChild = classifyDao.countClassifyChild(classId);
        if(0 != countChild ) {
            appResponse = AppResponse.paramError("该商品分类存在子分类，无法删除");
            return appResponse;
        }
        //查询商品分类是否存在商品
        int countGoods = classifyDao.countGoodsNum(classId);
        if(0 != countGoods ) {
            appResponse = AppResponse.paramError("该商品分类下存在商品，无法删除");
            return appResponse;
        }
        //删除商品分类
        int count = classifyDao.deleteClassify(classId,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除商品分类失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 修改商品分类信息
     * @param classifyDO 商品分类信息集合
     * @return
     * @author WangZebin
     * @date 2020-04-05
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateClassifyById(ClassifyDO classifyDO) {
        AppResponse appResponse = AppResponse.success("修改商品分类成功");
        //修改商品分类信息
        int count = classifyDao.updateClassifyById(classifyDO);
        if(0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询商品分类列表
     * @return
     * @author WangZebin
     * @date 2020-04-05
     */
    public AppResponse listClassify() {
        List<ClassifyVO> classifyList = classifyDao.listClassify();
        return AppResponse.success("查询商品分类列表成功！", classifyList);
    }

    /**
     * 查询商品分类详情
     * @param classId 商品分类编号
     * @return
     * @author WangZebin
     * @date 2020-04-05
     */
    public AppResponse findClassifyById(String classId) {
        ClassifyVO classifyVO = null;
        classifyVO = classifyDao.findClassifyById(classId);
        if (classifyVO == null) {
            return AppResponse.notFound("无查询结果");
        }
        return AppResponse.success("查询商品分类详情成功", classifyVO);
    }
}
