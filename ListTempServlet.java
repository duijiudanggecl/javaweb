package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import java.sql.Statement;

@SuppressWarnings("serial")
public class ListTempServlet extends HttpServlet {

	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.service(arg0, arg1);

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	//	out.print("<input type='button' value='添加新数据' onclick='location.herf=\"tmp/addTemp.html\"'/");
		out.print("<table border='1px' cellpadding='10' cellspacing='0'>");
		out.print("<tr>");
		out.print("<th> 序号</th>");
		out.print("<th> 姓名</th>");
		out.print("<th> 电话</th>");
		out.print("<th> 是否去过高风险地区</th>");
		out.print("<th> 日期</th>");
		out.print("<th> 体温</th>");
		out.print("<tr>");
		
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/temp?characterEncoding=utf8", "root",
					"123456");
			st = con.createStatement();
			//String sql = "select *from temperature";
			//rs = st.executeQuery(sql);
			
			String sql = "select *from temperature;";
			rs = st.executeQuery(sql);
			//String sql1 = "update temperature set name='王五'  where id='1' ;" ;
			//rs = st.executeQuery(sql1);
			
			while(rs.next()) {
				out.print("<tr>");
				out.print("<td>"+rs.getInt("id")+"</td>");
				out.print("<td>"+rs.getString("name")+"</td>");
				out.print("<td>"+rs.getString("telephone")+"</td>");
				if(rs.getInt("isContacted")==0) {
					out.print("<td style='text-align:center'>否</td>");
				}else {
					out.print("<td style='text-align:center'>是</td>");			
				}
				out.print("<td>"+rs.getDate("date")+"</td>");
				out.print("<td>"+rs.getFloat("temp")+"</td>");
				out.print("</tr>");		
				
				//out.print()
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
		//out.print("<a href='C:\Users\Administrator\Desktop\webapp\registe.html'><button>百度</button></a>");
	
		//out.print("<input type='button'  value='添加新数据'  onclick='location.href= 'C:\\Users\\Administrator\\Desktop\\webapp\\registe.html'"/>");
		out.print("</table><br/>");	
		//out.print("<input type='button'    value='添加新数据'   onclick='ocation.href=\" C:\\Users\\Administrator\\Desktop\\webapp\\registe.html \"'/>");
		//out.print("<input type='button' value='  添加新数据  ' "
			//	+ "onclick='location.href=\" C:\\Users\\Administrator\\Desktop\\webapp\\addTemp.html\"' />");	
		
	//	out.print("<input type='button' value='  添加新数据  '  onclick=\' location.href="D:/Users/Administrator/eclipse-workspace/ProjectForMysql/addTemp.html" \'/>");
		
		out.print("<input type='button' value='  添加新数据  ' "
		+ "onclick='location.href=\"temp/Temperature.html \"' />");
	}




}
