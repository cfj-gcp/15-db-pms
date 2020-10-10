package springmybatis.pj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import springmybatis.mapper.Goods;
import springmybatis.pojo.GoodsDao;
import java.util.List;
@SpringBootTest
public class GoodsDaoTest {
    @Autowired
    @Qualifier("goodsDaoImpl")
    private GoodsDao  goodDao;
    @Test
    void testFindGoods(){
        List<Goods> list = goodDao.findGoods();
        for (Goods goods : list) {
            System.out.println(goods);
        }
    }

}
