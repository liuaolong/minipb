package com.zrent.mapper;

import com.zrent.model.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Zrent
 */
@Mapper
public interface CustomerMapper {

    @Insert("insert into customer(openid,session_key,nickname,avatar_url) value(#{customer.openid},#{customer.sessionKey},#{customer.nickname},#{customer.avatarUrl})")
    void add(@Param("customer") Customer customer);

    @Select("select * from customer")
    List<Customer> list();
}
