package com.xzsd.pc.customer.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.entity.CustomerVO;
import com.xzsd.pc.utils.GlobalClass;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * 客户管理实现类
 * @author WangZeBin
 * @date 2020-04-06
 */
@Service
public class CustomerService {
    @Resource
    CustomerDao customerDao;

    /**
     * 查询客户信息列表
     * @param customerInfo 客户信息集合
     * @return
     * @author WangZeBin
     * @date 2020-04-06
     */
    public AppResponse listCustomer(CustomerInfo customerInfo) {
        //权限验证
        int role = customerInfo.getRole();
        if(GlobalClass.storeManager == role) {
            //通过店长编号获取门店邀请码
            String inviteCode = customerDao.findInviteCode(customerInfo.getUserId());
            customerInfo.setInviteCode(inviteCode);
        }
        //查询客户列表（分页）
        List<CustomerVO> customerVOList = customerDao.listCustomerByPage(customerInfo);
        return AppResponse.success("查询成功！", getPageInfo(customerVOList));
    }
}
