package testse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testse
 */
@WebServlet("/testse")
public class testse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("﻿<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title> 欢迎来到梦之都 </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>这是我的第一个网页,在这里");
		out.println("<a href=\"http://www.baidu.com\">");
		out.println("尽情学习HTML");
		out.println("</a>吧!");
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
//		response.setContentType("text/html;charset=utf-8");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		File file = new File("E:\\开发者\\src\\web\\ajax\\table_manage_colvis.html");
//		InputStreamReader read = new InputStreamReader (new FileInputStream(file),"UTF-8");
//		BufferedReader reader=new BufferedReader(read); 
//		String tempString = null;
//		int line = 1;
//		
//        while ((tempString = reader.readLine()) != null) {
//            // 显示行号
//        	out.println(tempString);
//            line++;
//        }
//		System.out.println("你好");
//		out.println("你好");
////		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
////		out.println("<HTML>");
////		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
////		out.println("  <BODY>");
////		out.print("    This is ");
////		out.print(this.getClass());
////		out.println(", using the GET method");
////		out.println("  </BODY>");
////		out.println("</HTML>");
//        reader.close();
//		out.flush();
//		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
