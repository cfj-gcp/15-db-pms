package com.tedu.JT.mapper;

import com.tedu.JT.pojo.Item;
import com.tedu.JT.pojo.ItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Sat Sep 26 20:04:34 CST 2020
     */
    long countByExample(ItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Sat Sep 26 20:04:34 CST 2020
     */
    int deleteByExample(ItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Sat Sep 26 20:04:34 CST 2020
     */
    int deleteByPrimaryKey(Integer itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Sat Sep 26 20:04:34 CST 2020
     */
    int insert(Item record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Sat Sep 26 20:04:34 CST 2020
     */
    int insertSelective(Item record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Sat Sep 26 20:04:34 CST 2020
     */
    List<Item> selectByExample(ItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Sat Sep 26 20:04:34 CST 2020
     */
    Item selectByPrimaryKey(Integer itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Sat Sep 26 20:04:34 CST 2020
     */
    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Sat Sep 26 20:04:34 CST 2020
     */
    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Sat Sep 26 20:04:34 CST 2020
     */
    int updateByPrimaryKeySelective(Item record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Sat Sep 26 20:04:34 CST 2020
     */
    int updateByPrimaryKey(Item record);
}