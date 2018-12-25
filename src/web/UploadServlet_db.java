package web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet_db
 */
@WebServlet("/UploadServlet_db")
public class UploadServlet_db extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet_db() {
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
		
		System.out.println("doPost()");
		request.setCharacterEncoding("utf-8");
		//获取指定的文件
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		upload.setSizeMax(1024*1024*10);
		upload.setFileSizeMax(1024*1024*5);
		try {
			List<FileItem> list=upload.parseRequest(request);
			//然后遍历集合
			for(FileItem item:list)
			{
				//判断每个元素是否是一个文件类型的输入框
				if(!item.isFormField())//如果是文件输入框的话执行
				{
					String fileName=item.getName();
					//然后截取文件路径的文件名
					fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
					//获取该item的输入流
					InputStream in=item.getInputStream();
					//写入到数据库中
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatebase","root","yuankui1209");
					PreparedStatement ps=con.prepareStatement("insert into image(name,picture) values(?,?)");
					ps.setString(1, fileName);
					ps.setBinaryStream(2, in, in.available());
					ps.executeUpdate();
					
					ps.close();
					con.close();
					in.close();
					
				}
			}
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		response.getWriter().println("haha");
	}

}
