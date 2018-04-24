package web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownLoad
 */
@WebServlet("/DownLoad")
public class DownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownLoad() {
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
		//��ȡ��������Ҫ���ص��ļ�����
		String fileName=request.getParameter("filename");
		//��ָ����·���»�ȡ���ļ�
		File file=new File("E://upload//"+fileName);
		FileInputStream fis=new FileInputStream(file);
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachement;filename="
				+URLEncoder.encode(fileName,"utf-8"));
		
		//�õ���������ָ��file�ļ�
		FileInputStream in=new FileInputStream(file);
		OutputStream out=response.getOutputStream();
		//���������ֽ�����
		byte[] b=new byte[1024*10];
		int i=-1;
		while((i=in.read(b))!=-1)
		{
			out.write(b,0,i);
		}
		in.close();
		out.close();
		
		
	}

}
