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
		//1.����һ���ļ���������
		DiskFileItemFactory dfif=new DiskFileItemFactory();
		//2.����һ���ļ�������
		ServletFileUpload upload=new ServletFileUpload(dfif);
		upload.setFileSizeMax(1024*1024*5);//�����ϴ��ĵ����ļ����Ϊ5Mb
		upload.setSizeMax(1024*1025*10);//�����ϴ����ܹ��ļ���С���Ϊ10mb
		try {
			//��request�����������ݻ��ļ����з���
			//parseRequest��������һ��FileItem���͵ļ���
			List<FileItem> list=upload.parseRequest(request);
			
			//�������Ի�ȡ��FileItem���͵ļ��Ͻ��з���,�ж�ÿ��FileItem�Ƿ����ļ������ݲ�ͬ��������ͬ�Ĵ���
			for(FileItem item:list)
				
			{
				//���item����ͨ����򣨼������ļ������
				if(item.isFormField())
				{
					
				}
				else {
					//������ļ�����������������ļ����浽���ش���
					
					//1.��ȡ�ļ���
					System.out.println(item.getName());
					String fileName=item.getName().substring(item.getName().lastIndexOf("\\")+1);
					System.out.println(fileName);
					InputStream in=item.getInputStream();
					File file=new File("E:\\"+fileName);
					FileOutputStream out=new FileOutputStream(file);
					byte[] bytes=new byte[1024*10];//�����СΪ10k
					int i=-1;
					while((i=in.read(bytes))!=-1)
					{
						out.write(bytes, 0, i);
						
					}
					response.setCharacterEncoding("utf-8");
					System.out.print("�ϴ����");
					PrintWriter pw=response.getWriter();
					pw.println("<center>�ϴ��ɹ�����</center>");
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
