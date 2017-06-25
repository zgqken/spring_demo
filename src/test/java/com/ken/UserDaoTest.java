package com.ken;

import com.alibaba.fastjson.JSONObject;
import com.ken.user.dao.UserDao;
import com.ken.user.dao.UserRepository;
import com.ken.user.domain.UserDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 类名称：
 * 类描述：
 * 创建人：zgquan
 * 创建日期：2017/5/23 0023
 */

public class UserDaoTest extends BaseSpringTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRepository userRepository;


    @Test
    public void getList(){
        List<UserDO> list =  userDao.getList();
        System.out.println(list.size());
    }

    @Test
    public void getListMap(){
        List<Map<String,Object>> list = userDao.getListMap();
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void getByResultSetExtractor(){
        List list = userDao.getByResultSetExtractor();
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void getRowCallbackHandler(){
        List list = userDao.getRowCallbackHandler();
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void getById(){
        UserDO userDO = userDao.getById(1l);
        System.out.println(JSONObject.toJSONString(userDO));
    }

    @Test
    public void getOne(){
        UserDO userDO =userDao.getOne(2l);
        System.out.println(JSONObject.toJSONString(userDO));
    }

    @Test
    public void findById(){
        UserDO userDO = userRepository.findOne("1");
        userDO = userRepository.findById("1");
        System.out.println(JSONObject.toJSONString(userDO));
    }

}
