package anylazeWeb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topsec.dataanalyze.Log4ADataAnalyze;
import com.topsec.dataanalyze.entity.BypassEntity;

/**
 * Servlet implementation class Abylaze
 */
@WebServlet("/ajax/table_manage_colvis.html")
public class Abylaze extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Abylaze() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filepath = this.getServletConfig().getServletContext().getRealPath("/"); 
		Log4ADataAnalyze log4dataAnylaze = new Log4ADataAnalyze();
		log4dataAnylaze.Log4ADataAnalyze();
		List<BypassEntity> log4a = log4dataAnylaze.getData();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		File file = new File(filepath + "/WEB-INF/resource/table_manage_colvis_first.html");
		InputStreamReader read = new InputStreamReader (new FileInputStream(file),"UTF-8");
		BufferedReader reader=new BufferedReader(read); 
		String tempString = null;
		int line = 1;
		
        while ((tempString = reader.readLine()) != null) {
        	out.println(tempString);
            line++;
        }
        reader.close();
        
        for (int i = 0; i < log4a.size(); i++){
        	out.println("<tr class=\"odd gradeX\">");
        	out.println("<td>" + log4a.get(i).getAbnormalBehaviorWarning() + "</td>");
        	out.println("<td>" + log4a.get(i).getAbnormalBehaviorSub() + "</td>");
        	out.println("<td>" + log4a.get(i).getPrimaryAccount() + "</td>");
        	out.println("<td>" + log4a.get(i).getBehaviorSourceIp() + "</td>");
        	out.println("<td>" + log4a.get(i).getTargetIp() + "</td>");
        	out.println("<td>" + log4a.get(i).getActionType() + "</td>");
        	out.println("<td>" + log4a.get(i).getActionTime() + "</td>");
        	out.println("<td>" + log4a.get(i).getSeverity() + "</td>");
        	out.println("</tr>");
        }
        
		File file1 = new File(filepath + "/WEB-INF/resource/table_manage_colvis_second.html");
		InputStreamReader read1 = new InputStreamReader (new FileInputStream(file1),"UTF-8");
		BufferedReader reader1=new BufferedReader(read1); 
		String tempString1 = null;
		int line1 = 1;
		
        while ((tempString1 = reader1.readLine()) != null) {
        	out.println(tempString1);
            line1++;
        }
        reader1.close();        
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
