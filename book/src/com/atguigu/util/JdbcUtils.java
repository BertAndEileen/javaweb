package com.atguigu.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 操作数据库连接(从连接池中获取)
 */
public class JdbcUtils {

    static DruidDataSource dataSource;
    static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
    static {
        try {
            //创建属性配置文件类
            Properties properties = new Properties();
            // 通过类加载器,读取jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            properties.load(inputStream);
            // 根据属性连接信息创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

//            System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     *从数据库连接池中获取连接 <br/>
     * @return
     */
    public static Connection getConnection(){
        // 先从threadLocal中获取连接
        Connection conn = conns.get();
        // 如果连接等于null,说明之前没获取连接
        if (conn == null) {
            try {
                // 从数据库连接池中获取连接
                conn = dataSource.getConnection();
                // 保存到 ThreadLocal中
                conns.set(conn);
                // 设置手动提交事务
                conn.setAutoCommit(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交事务.并关闭连接
     */
    public static void commitAndClose(){
        // 从ThreadLocal中获取之前使用的连接
        Connection connection = conns.get();
        // 如果为null,说明之前没有使用过连接,不需要处理事务
        if (connection != null) {
            try {
                // 提交事务
                connection.commit();
                // 关闭连接===放回数据库连接池
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 解除线程和连接的关联,否则会出错===一定要有
        conns.remove();
    }
    /**
     * 回滚事务.并关闭连接
     */
    public static void rollbackAndClose(){
        // 从ThreadLocal中获取之前使用的连接
        Connection connection = conns.get();
        // 如果为null,说明之前没有使用过连接,不需要处理事务
        if (connection != null) {
            try {
                // 提交事务
                connection.rollback();
                // 关闭连接===放回数据库连接池
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 解除线程和连接的关联,否则会出错===一定要有
        conns.remove();
    }

//    /**
//     * 关闭连接,放回连接池中
//     * @param conn
//     */
//    public static void close(Connection conn){
//        if (conn != null) {
//            try {
//                // 把连接放回数据库连接池中
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
