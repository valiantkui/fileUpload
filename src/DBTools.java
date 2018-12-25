

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author KUIKUI
 *�����������������ݿ�ķ�װ��
 */
public class DBTools {
	/**
	 * ��ȡ���ݿ������
	 * @return ���ݿ�����ӣ�Connection���ͣ�
	 */
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//return DriverManager.getConnection("jdbc:mysql://39.106.124.138:3306/bookshop?characterEncoding=utf8","root","0107");
			return DriverManager.getConnection("jdbc:mysql://39.107.115.155:3306/zajk?characterEncoding=utf8","zajk","zajk");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}catch(Exception e )
		{
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * �ر�connection����
	 * @param con
	 */
	public static void close(Connection con)
	{
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * �ر�statement
	 */
	public static void close(Statement stat)
	{
		if(stat!=null)
		{
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * �ر�ResultSet����
	 * @param rs
	 */
	public static void close(ResultSet rs)
	{
		if(rs!=null)
		{
			
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
