package com.ken;

import com.ken.user.dao.UserDao;
import com.ken.user.domain.UserDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/5/23 0023
 */

public class UserDaoTest extends BaseSpringTest {

    @Autowired
    private UserDao userDao;


    @Test
    public void test(){

        List<UserDO> list =  userDao.getList();
        System.out.println(list.size());
    }



}
