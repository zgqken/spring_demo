package com.ken.user.dao;

import com.ken.user.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    private CustomerMappingQuery customerMappingQuery;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.customerMappingQuery = new CustomerMappingQuery(dataSource);
    }

    public static final String QUERY_SQL="select * from t_user";

    public List<UserDO> getList(){
        return jdbcTemplate.query(QUERY_SQL,new BeanPropertyRowMapper(UserDO.class));
    }

    public UserDO getOne(Long id){
        String sql="select * from t_user where id=?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(UserDO.class),
                id);
    }

    /**
     * 返回Map形式的结果
     * @return
     */
    public List<Map<String, Object>> getListMap(){
        return jdbcTemplate.query(QUERY_SQL, new ColumnMapRowMapper());
    }

    /**
     * ResultSetExtractor 方式查询
     * @return
     */
    public List<UserDO> getByResultSetExtractor(){
        List<UserDO> list=jdbcTemplate.query(QUERY_SQL, new ResultSetExtractor<List<UserDO>>() {
            @Override
            public List<UserDO> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<UserDO> userList = new ArrayList<>();
                while (rs.next()) {
                    UserDO user = new UserDO();
                    user.setId(rs.getString("id"));
                    user.setUserName(rs.getString("user_name"));
                    user.setPassword(rs.getString("password"));
                    userList.add(user);
                }
                return userList;
            }
        });
        return list;
    }

    /**
     * RowCallbackHandler 方式封装
     * @return
     */
    public List<UserDO> getRowCallbackHandler(){
        final List<UserDO> userList = new ArrayList<>();
        jdbcTemplate.query("select * from T_USER",
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet rs) throws SQLException {
                        UserDO user = new UserDO();
                        user.setId(rs.getString("id"));
                        user.setUserName(rs.getString("user_name"));
                        user.setPassword(rs.getString("password"));
                        userList.add(user);
                    }
                });
        return userList;
    }

    public UserDO getById(Long id){
       return customerMappingQuery.findObject(id);
    }

}



class CustomerMappingQuery extends MappingSqlQuery<UserDO>{

    public CustomerMappingQuery(DataSource ds) {
        super(ds, "SELECT * from t_user WHERE  id=?");
        super.declareParameter(new SqlParameter("id", Types.LONGNVARCHAR));
        compile();
    }

    @Override
    protected UserDO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDO user = new UserDO();
        user.setId(rs.getString("id"));
        user.setUserName(rs.getString("user_name"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}