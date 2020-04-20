package com.xzsd.pc.hostgoods.dao;

import com.xzsd.pc.hostgoods.entity.HostGoodsDO;
import com.xzsd.pc.hostgoods.entity.HostGoodsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 热门商品管理接口
 * @author WangZeBin
 * @date 2020-04-14
 */
public interface HostGoodsDao {
    /**
     * 统计相同排序数量
     * @param hostGoodsNO 热门商品排序
     * @return
     */
    int countHostGoodsNO(int hostGoodsNO);

    /**
     * 统计相同商品数量
     * @param goodsId 商品编号
     * @return
     */
    int countGoodsId(String goodsId);

    /**
     * 新增热门商品
     * @param hostGoodsDO 热门商品信息
     * @return
     */
    int addHostGoods(HostGoodsDO hostGoodsDO);

    /**
     * 删除热门商品
     * @param listId 热门商品编号集合
     * @param userId 当前用户编号
     * @return
     */
    int deleteHostGoods(@Param("listId") List<String> listId, @Param("userId") String userId);

    /**
     * 修改热门商品排序
     * @param hostGoodsDO 热门商品信息
     * @return
     */
    int updateHostGoodsById(HostGoodsDO hostGoodsDO);

    /**
     * 查询热门商品列表（分页）
     * @param hostGoodsDO 热门商品信息
     * @return
     */
    List<HostGoodsVO> listHostGoodsByPage(HostGoodsDO hostGoodsDO);

    /**
     * 查询热门商品展示数量
     * @return
     */
    List<HostGoodsVO> findShowNumber();

    /**
     * 修改热门商品展示数量
     * @return
     */
    int updateShowNumber(@Param("showNumber") int showNumber, @Param("version") int version, @Param("userId") String userId);
}
