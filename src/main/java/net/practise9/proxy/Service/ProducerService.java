package net.practise9.proxy.Service;

/**
 * Created by admin on 2019/6/16.
 *
 * 生产厂家的的标准
 */
public interface ProducerService {

    /*
    销售
    * */
    public  void saleProduct(float money);

    /*
    * 售后
    * */
    public  void afterservice(float money);
}
