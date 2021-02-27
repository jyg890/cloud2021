package com.maxi.springcloud.alibaba.service.impl;

import com.maxi.springcloud.alibaba.dao.AccountDao;
import com.maxi.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author JYG
 * @description
 * @create 2021−02-26 3:02 下午
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------->account-service中扣减账户余额开始");
//        模拟超时异常，全局事务回滚
//        暂停几秒钟线程
        //当库存和账户余额扣减后，订单状态并没有设置为已经完成，没有从零改为1
        //而且由于feign的重试机制，账户余额还有可能被多次扣减
        //try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        accountDao.decrease(userId,money);
        LOGGER.info("------->account-service中扣减账户余额结束");
    }
}
