import java.sql.*;

/**
 * Created by Administrator on 2018/5/8.
 */
public class Test001
{
    public static void main(String[] args)
    {
        //1.加载驱动
        try
        {
            Class.forName("com.mysql.jdbc.Driver");



        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        //2.获取数据库连接
        Connection conn = null;
        PreparedStatement ps = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/neuedu","root","root");
            ps = conn.prepareStatement("insert into sorder values(null,?,?,?,?,?,?,?,?)");
            ps.setInt(1,1);
            ps.setString(2,"openid");
            ps.setDouble(3,1000.01);
            ps.setString(4,null);
            ps.setDouble(5,1000.01);
            ps.setString(6,"A");

            Timestamp now = new Timestamp(System.currentTimeMillis());
            //时间原点：1970/1/1 00:00:00
            ps.setTimestamp(7,now);
            ps.setInt(8,1);

            ps.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                ps.close();
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

        }
    }
}
