package com.ken.user.dao;

import com.ken.user.domain.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/6/24
 */
public interface UserRepository extends JpaRepository<UserDO,String> {


    UserDO findById(String id);
}
