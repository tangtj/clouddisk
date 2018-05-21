package cn.tangtj.clouddisk.dao;

import cn.tangtj.clouddisk.entity.User;
import cn.tangtj.clouddisk.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @author tang
 */
@Repository
public class UserDao {

    public User findByName(String name) {
        String sql = "select * from user where userName = ?";
        QueryRunner runner = JdbcUtil.getQueryRunner();
        try {
            return runner.query(sql, new BeanHandler<>(User.class), name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User findById(int id) {
        String sql = "select * from user where userId = ?";
        QueryRunner runner = JdbcUtil.getQueryRunner();
        try {
            return runner.query(sql, new BeanHandler<>(User.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}