package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 	[ 서블릿 ]
 * 
 * 	- HttpServlet 클래스를 상속받아서 만든다.
 * 	- service() 메소드를 오버라이드 한다.
 * 	- 어떤 경로 요청이 왔을때 동작할지 @WebServlet() 어노테이션에 경로를 설정해준다.
 *
 *	클라이언트가 /fortune 요청을 해오면 Tomcat서버가 FortuneServle클래스로 객체를 생성해서
 *	service() 메소드를 호출해준다.
 *	요청에 관련된 객체의 참조값(HttpServletRequest), 응답에 관련한 객체의 참조값(HttpServletResponse)
 *	을 Tomcat서버가 매개변수에 전달한다.
 */

@WebServlet("/fortune") // 3. 요청 경로 맵핑
public class FortuneServlet extends HttpServlet{// 1. HttpServlet 클래스 상속받기
	@Override // 2. service() 메소드를 오버라이드
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 응답 인코딩 설정
		resp.setCharacterEncoding("utf-8");
		//응답 컨텐트 type 설정
		resp.setContentType("text/html; charset=utf-8");
		// 요청을 한 클라이언트에게 문자열을 출력할 수 있는 객체의 참조값 얻어내기
		PrintWriter pw = resp.getWriter();
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>오늘의 운세 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		// 오늘의 운세 5개를 미리 준비해 둔다.
		String[] fortuneToday = {"동쪽으로 가면 귀인을 만나요!",
		                         "오늘은 집에만 계세요",
		                         "너무 멀리 가지 마세요",
		                         "오늘은 뭘 해도 되는 날이에요",
		                         "로또가 당첨돼요"};
		// 오늘의 운세가 5개 중에서 랜덤하게 나오도록 프로그래밍
		Random ran = new Random();
		int ranNum = ran.nextInt(5);

		
		pw.println("<p> 오늘의 운세 : <strong>" + fortuneToday[ranNum] + "</strong></p>");
		
		pw.println("</body>");
		pw.println("</html>");
		pw.flush();
		pw.close();
	}
	
}
