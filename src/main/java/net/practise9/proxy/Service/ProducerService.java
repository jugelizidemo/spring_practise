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
      void saleProduct(float money);

    /*
    * 售后
    * */
      void afterservice(float money);
}
