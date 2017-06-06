package com.ken.user.dao;

import com.ken.user.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/5/22 0022
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<UserDO> getList(){

        String sql="select * from t_user";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper(UserDO.class));
    }


}
