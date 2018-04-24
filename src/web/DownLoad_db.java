package web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownLoad_db
 */
@WebServlet("/DownLoad_db")
public class DownLoad_db extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownLoad_db() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//��ȡҪ���ص��ļ���
		String fileName=request.getParameter("filename");
		//Ȼ������ݿ��в��Ҹ��ļ���������
		//��������ku
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatebase","root","yuankui1209");
			PreparedStatement ps=con.prepareStatement("select * from image where name=?");
			
			ps.setString(1, fileName);
			ResultSet rs=ps.executeQuery();
			rs.next();
			//�õ�ָ���ļ���������
			InputStream in=rs.getBinaryStream("picture");
			response.setContentType("multipart/form-data");
			response.setHeader("Content-Disposition", "attachement;filename="
					+URLEncoder.encode(fileName,"utf-8"));//filename��Ĳ���ָ��Ĭ�ϱ�����ļ�����
			OutputStream out=response.getOutputStream();
			byte[] b=new byte[1024];
			int i=-1;
			while((i=in.read(b))!=-1)
			{
				out.write(b,0,i);
			}
			rs.close();
			ps.close();
			con.close();
			in.close();
			out.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
