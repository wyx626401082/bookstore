package com.xzsd.pc.classify.dao;

import com.xzsd.pc.classify.entity.ClassifyDO;
import com.xzsd.pc.classify.entity.ClassifyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品分类接口
 * @author WangZeBin
 * @date 2020-04-05
 */
public interface ClassifyDao {
    /**
     * 统计商品分类的子分类数目
     * @param classifyId 商品分类比那好
     * @return
     */
    int countClassifyChild(String classifyId);

    /**
     * 新增商品分类
     * @param classifyDO 商品分类信息集合
     * @return
     */
    int addClassify(ClassifyDO classifyDO);

    /**
     * 删除菜单分类
     * @param classId 商品分类编号
     * @param userId 当前用户编号
     * @return
     */
    int deleteClassify(@Param("classId") String classId, @Param("userId") String userId);

    /**
     * 修改商品分类信息
     * @param classifyDO 商品分类信息集合
     * @return
     */
    int updateClassifyById(ClassifyDO classifyDO);

    /**
     * 查询商品分类列表
     * @return
     */
    List<ClassifyVO> listClassify();

    /**
     * 查询商品分类详情
     * @param classId 商品分类编号
     * @return
     */
    ClassifyVO findClassifyById(String classId);
}
