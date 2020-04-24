package com.xzsd.app.goods.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goods.dao.GoodsDao;
import com.xzsd.app.goods.entity.ClassifyVO;
import com.xzsd.app.goods.entity.EvaluateVO;
import com.xzsd.app.goods.entity.GoodsDO;
import com.xzsd.app.goods.entity.GoodsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 商品信息管理实现类
 * @author WangZebin
 * @date 2020-04-21
 */
@Service
public class GoodsService {
    @Resource
    GoodsDao goodsDao;

    /**
     * 查询商品详情
     * @param goodsId 商品编号
     * @return
     * @author WangZebin
     * @date 2020-04-21
     */
    public AppResponse findGoodsById(String goodsId) {
        GoodsVO goodsVO = null;
        goodsVO = goodsDao.findGoodsById(goodsId);
        if (goodsVO == null) {
            return AppResponse.success("无商品详情查询结果");
        }
        return AppResponse.success("查询商品详情成功", goodsVO);
    }

    /**
     * 查询商品评价表（分页）
     * @param goodsDO
     * @return
     * @author WangZebin
     * @date 2020-04-21
     */
    public AppResponse listGoodsEvaluate(GoodsDO goodsDO) {
        List<EvaluateVO> evaluateVOList = goodsDao.listGoodsEvaluateByPage(goodsDO);
        return AppResponse.success("查询商品评价表成功！", getPageInfo(evaluateVOList));
    }

    /**
     * 查询商品一级分类列表
     * @return
     * @author WangZebin
     * @date 2020-04-21
     */
    public AppResponse listClassifyOne() {
        List<ClassifyVO> classOneList = goodsDao.listClassifyOne();
        return AppResponse.success("查询商品一级分类列表成功！", classOneList);
    }

    /**
     * 查询商品二级分类列表
     * @param classOneId 一级分类编号
     * @return
     * @author WangZebin
     * @date 2020-04-21
     */
    public AppResponse listClassifyTwo(String classOneId) {
        List<ClassifyVO> classTwoList = goodsDao.listClassifyTwo(classOneId);
        return AppResponse.success("查询商品二级级分类列表成功！", classTwoList);
    }
}
