package springmybatis.mapper;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmybatis.pojo.GoodsDao;


import java.util.List;


@Service
public class GoodsDaoImpl  implements GoodsDao {
  static final Logger  log=LoggerFactory.getLogger(GoodsDaoImpl.class);
  @Autowired
  private   GoodsDao  goodsDao;

    @Override
    public List<Goods> findGoods() {
        long l = System.currentTimeMillis();
        List<Goods> list = goodsDao.findGoods();
        long l1 = System.currentTimeMillis();
        log.info("findgoods()-->l1-l={}",l1-l);
        return list;
    }
}
