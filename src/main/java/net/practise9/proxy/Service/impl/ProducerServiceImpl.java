package net.practise9.proxy.Service.impl;

import net.practise9.proxy.Service.ProducerService;

/**
 * Created by admin on 2019/6/16.
 */
public class ProducerServiceImpl implements ProducerService {

    /*
    销售
    * */
    public  void saleProduct(float money){
        System.out.println("销售产品,拿到钱:" + money);
    }

    /*
    * 售后
    * */
    public  void afterservice(float money){
        System.out.println("提供售后服务,拿到钱:" + money);
    }
}
