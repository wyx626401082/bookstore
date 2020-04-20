package com.xzsd.pc.goods.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.ClassifyVO;
import com.xzsd.pc.goods.entity.GoodsDO;
import com.xzsd.pc.goods.entity.GoodsVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.neusoft.core.page.PageUtils.getPageInfo;


/**
 * 商品增删改查
 * @author WangZeBin
 * @date 2020-03-30
 */
@Service
public class GoodsService {
    @Resource
    GoodsDao goodsDao;

    /**
     * 新增商品
     * @param goodsDO
     * @return
     * @author WangZeBine
     * @date 2020-03-30
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoods(GoodsDO goodsDO) {
        goodsDO.setGoodsId(StringUtil.getCommonCode(2));
        goodsDO.setIsDeleted(0);
        int count = goodsDao.addGoods(goodsDO);
        if(0 == count) {
            return AppResponse.bizError("新增商品失败，请重试！");
        }

        return AppResponse.success("新增商品成功！");
    }

    /**
     * 删除商品
     * @param goodsId 商品id
     * @param userId
     * @return
     * @author WangZeBine
     * @date 2020-03-30
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsId, String userId) {
        List<String> listGoodsId = Arrays.asList(goodsId.split(","));
        AppResponse appResponse = AppResponse.success("删除商品成功");
        //删除商品
        int count = goodsDao.deleteGoods(listGoodsId,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除商品失败");
        }
        return appResponse;
    }

    /**
     * 修改商品信息
     * @param goodsDO
     * @return
     * @author WangZeBine
     * @date 2020-03-30
     */
    public AppResponse updateGoodsById(GoodsDO goodsDO) {
        int count = goodsDao.updateGoodsById(goodsDO);
        if(0 == count) {
            return AppResponse.versionError("数据有变化，请刷新！");
        }
        return AppResponse.success("修改商品信息成功");
    }

    /**
     * 修改商品状态
     * @param goodsId 商品编号，多个用“，”隔开
     * @param goodsState 商品状态
     * @param version 版本号，多个用“，”隔开
     * @param userId 用户编号
     * @return
     * @author WangZeBine
     * @date 2020-03-30
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse updateStateById(String goodsId, int goodsState, String version, String userId) {
        //将商品id，以及与其对应版本号转化为List
        List<String> listId = Arrays.asList(goodsId.split(","));
        List<String> listVersion = Arrays.asList(version.split(","));
        int num = listId.size();
        //以商品id为key，版本号为value存入Map
        Map versionMap = new HashMap<String,Integer>(num);
        for(int i = 0; i < num; i++) {
            int intVersion = Integer.valueOf(listVersion.get(i));
            versionMap.put(listId.get(i),intVersion);
        }
        //修改商品状态
        int count = goodsDao.updateStateById(goodsState,versionMap,userId);
        if(num > count) {
            return AppResponse.versionError("数据有变化，请刷新！");
        }
        return AppResponse.success("修改商品状态成功");
    }

    /**
     * 查询商品详情
     * @param goodsId
     * @return
     * @author WangZeBin
     * @date 2020-03-30
     */
    public AppResponse findGoodsById(String goodsId) {
        GoodsVO goodsVO = goodsDao.findGoodsById(goodsId);
        if (goodsVO == null) {
            return AppResponse.notFound("无查询结果");
        }
        return AppResponse.success("查询商品详情成功", goodsVO);
    }

    /**
     * 查询商品列表（分页）
     * @param goodsDO
     * @return
     * @author WangZeBin
     * @Date 2020-03-30
     */
    public AppResponse listGoods(GoodsDO goodsDO) {
        List<GoodsVO> goodsVOList = goodsDao.listGoodsByPage(goodsDO);
        return AppResponse.success("查询商品列表成功！", getPageInfo(goodsVOList));
    }

    /**
     * 查询商品分类列表
     * @return
     * @author WangZeBin
     * @Date 2020-03-30
     */
    public AppResponse listClassify(String classifyId) {
        List<ClassifyVO> classifyVOList = goodsDao.listClassify(classifyId);
        return AppResponse.success("查询商品分类成功！", classifyVOList);
    }
}
