package springmybatis.pojo;

import org.apache.ibatis.annotations.Mapper;
import springmybatis.mapper.Goods;

import java.util.List;

@Mapper
public interface GoodsDao {
    List<Goods>  findGoods();
}
