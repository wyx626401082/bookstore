package com.xzsd.pc.goods.dao;


import com.xzsd.pc.goods.entity.ClassifyVO;
import com.xzsd.pc.goods.entity.GoodsDO;
import com.xzsd.pc.goods.entity.GoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author WangZeBin
 * @date 2020-03-30
 */
@Mapper
public interface GoodsDao {

    /**
     * 新增商品信息
     * @param goodsDO
     * @return
     */
    int addGoods(GoodsDO goodsDO);

    /**
     * 修改商品信息
     * @param goodsDO
     * @return
     */
    int updateGoodsById(GoodsDO goodsDO);

    /**
     * 修改商品状态（上架下架）
     * @param goodsState 商品状态
     * @param versionMap 商品编号->版本号map
     * @param userId 当前用户编号
     * @return
     */
    int updateStateById(@Param("goodsState") int goodsState, @Param("versionMap") Map<String,Integer> versionMap, @Param("userId") String userId);

    /**
     * 删除商品信息
     * @param listGoodsId 商品编号集合
     * @param userId 用户编号
     * @return
     */
    int deleteGoods(@Param("listGoodsId") List<String> listGoodsId, @Param("userId") String userId);

    /**
     * 查询商品详情
     * @param goodsId
     * @return
     */
    GoodsVO findGoodsById(String goodsId);

    /**
     * 查询商品列表
     * @param goodsDO
     * @return
     */
    List<GoodsVO> listGoodsByPage(GoodsDO goodsDO);

    /**
     * 查询商品分类列表
     * @param classId 分类编码
     * @return
     */
    List<ClassifyVO> listClassify(@Param("classId") String classId);

}
