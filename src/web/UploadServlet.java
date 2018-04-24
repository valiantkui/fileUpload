package web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
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
		//1.创建一个文件解析工厂
		DiskFileItemFactory dfif=new DiskFileItemFactory();
		//2.创建一个文件解析器
		ServletFileUpload upload=new ServletFileUpload(dfif);
		upload.setFileSizeMax(1024*1024*5);//允许上传的单个文件最大为5Mb
		upload.setSizeMax(1024*1025*10);//允许上传的总共文件大小最大为10mb
		try {
			//对request请求来的数据或文件进行分析
			//parseRequest方法返回一个FileItem类型的集合
			List<FileItem> list=upload.parseRequest(request);
			
			//接下来对获取的FileItem类型的集合进行分析,判断每个FileItem是否是文件，根据不同类型做不同的处理
			for(FileItem item:list)
				
			{
				//如果item是普通输入框（即不是文件输入框）
				if(item.isFormField())
				{
					
				}
				else {
					//如果是文件输入框，则将请求来的文件保存到本地磁盘
					
					//1.获取文件名
					System.out.println(item.getName());
					String fileName=item.getName().substring(item.getName().lastIndexOf("\\")+1);
					System.out.println(fileName);
					InputStream in=item.getInputStream();
					File file=new File("E:\\"+fileName);
					FileOutputStream out=new FileOutputStream(file);
					byte[] bytes=new byte[1024*10];//缓冲大小为10k
					int i=-1;
					while((i=in.read(bytes))!=-1)
					{
						out.write(bytes, 0, i);
						
					}
					response.setCharacterEncoding("utf-8");
					System.out.print("上传完毕");
					PrintWriter pw=response.getWriter();
					pw.println("<center>上传成功！！</center>");
					in.close();
					out.close();
					
					
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
