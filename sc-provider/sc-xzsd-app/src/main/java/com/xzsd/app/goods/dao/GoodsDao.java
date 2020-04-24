package com.xzsd.app.goods.dao;

import com.xzsd.app.goods.entity.ClassifyVO;
import com.xzsd.app.goods.entity.EvaluateVO;
import com.xzsd.app.goods.entity.GoodsDO;
import com.xzsd.app.goods.entity.GoodsVO;

import java.util.List;

/**
 * 商品信息管理接口
 * @author WangZebin
 * @date 2020-04-21
 */
public interface GoodsDao {
    /**
     * 查询商品详情
     * @param goodsId 商品编号
     * @return
     */
    GoodsVO findGoodsById(String goodsId);

    /**
     * 查询商品评价表（分页）
     * @param goodsDO 查询信息
     * @return
     */
    List<EvaluateVO> listGoodsEvaluateByPage(GoodsDO goodsDO);

    /**
     * 查询商品一级分类列表
     * @return
     */
    List<ClassifyVO> listClassifyOne();

    /**
     * 查询商品二级分类列表
     * @param classOneId 一级分类编号
     * @return
     */
    List<ClassifyVO> listClassifyTwo(String classOneId);
}
