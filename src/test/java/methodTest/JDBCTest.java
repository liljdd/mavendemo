package methodTest;

import com.mysql.jdbc.Connection;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author lilj
 * @date 18/07/20
 */
public class JDBCTest {
    @Test
    public void demo01() throws Exception {
        // 1注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2获取连接
        Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test01", "root", "root");
        System.out.println(conn);
        // 3获得预处理对象
        String sql = "insert into studentclass(ClassName) values(?)";
        PreparedStatement stat = conn.prepareStatement(sql);
        // 4 SQL语句占位符设置实际参数
        stat.setString(1, "奢侈品");
        // 5执行SQL语句
        int line = stat.executeUpdate();
        System.out.println("新添加记录数：" + line);
        // 6释放资源
        stat.close();
        conn.close();

    }

}
