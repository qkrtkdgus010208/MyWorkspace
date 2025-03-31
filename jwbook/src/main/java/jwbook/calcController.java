package jwbook;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class calcController
 */
@WebServlet("/calcController")
public class calcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calcController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		c.setN1(Integer.parseInt(request.getParameter("n1")));
		c.setN2(Integer.parseInt(request.getParameter("n2")));
		c.setOp(request.getParameter("op"));
		long result = c.calc();
		
		request.setAttribute("result", result);
		//response.sendRedirect("/calcResult.jsp"); 이건 데이터를 포함하지 않는 이동
		getServletContext().getRequestDispatcher("/calcResult.jsp").forward(request, response); // 이건 데이터를 포함하는 이동
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
