package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.BreadDAO;
import dto.BreadDTO;


@WebServlet("/todayBread.do")
public class TodayBreadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		//String code = request.getParameter("code");
		//System.out.println("코드파라미터 : " + code);
		
		BreadDAO bdao = new BreadDAO();
		BreadDTO b = bdao.getTodayBread();
		
		JSONObject jobj = new JSONObject();
		jobj.put("code", b.getCode());
		jobj.put("name", b.getName());
		jobj.put("price", b.getPrice());
		jobj.put("intro", b.getIntro());
		jobj.put("img", b.getImg());
		
		String jstr = jobj.toJSONString(); // json 문자열로 만들기
		
		PrintWriter out = response.getWriter();
		out.print(jstr);
	}
}
