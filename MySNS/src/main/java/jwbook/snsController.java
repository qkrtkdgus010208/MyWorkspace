package jwbook;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.websocket.Session;

import java.io.IOException;

@MultipartConfig
@WebServlet("/snsController")
public class snsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsersDAO udao;
	private FeedsDAO fdao;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		udao = new UsersDAO();
		fdao = new FeedsDAO();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String view = "";

		if (action == null) {
			List<Feeds> list;
			list = fdao.getAll();
			request.setAttribute("feedlist", list);
			getServletContext().getRequestDispatcher("/feedlist.jsp").forward(request, response);
		} else {
			switch (action) {
			case "signup":
				view = signup(request, response);
				break;
			case "login":
				view = login(request, response);
				break;
			case "logout":
				view = logout(request, response);
				break;
			case "write":
				view = write(request, response);
				break;
			case "myinfo":
				view = myinfo(request, response);
				break;
			case "back":
				view = back(request, response);
				break;
			case "delete":
			    view = delete(request, response);
			    break;
			case "withdraw":
			    view = withdraw(request, response);
			    break;
			}
			getServletContext().getRequestDispatcher("/" + view).forward(request, response);
		}

	}
	
	public String login(HttpServletRequest request, HttpServletResponse response) {
		Users u = new Users();
		String id = request.getParameter("id");
		String pw = request.getParameter("password");

		try {
			u = udao.login(id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (u != null) {
			updateVisitedCount(request, response); // 방문 횟수 업데이트
			List<Feeds> list;
			list = fdao.getAll();
			request.setAttribute("feedlist", list);
			request.getSession().setAttribute("userimg", u.getImg());
			return "feedlist.jsp";
		} else {
			request.setAttribute("error", "로그인에 실패하였습니다.");
			return "login.jsp";
		}
	}

	public String signup(HttpServletRequest request, HttpServletResponse response) {
		Users u = new Users();
		
		try {
			Part part = request.getPart("img");
			String fileName = getFilename(part);
			if (fileName != null && !fileName.isEmpty()) {
				String uploadPath = getServletContext().getRealPath("/") + "img" + File.separator + fileName;
				File uploadDir = new File(getServletContext().getRealPath("/") + "img");
				if (!uploadDir.exists()) {
					uploadDir.mkdir();
				}
				part.write(uploadPath);
			}
			BeanUtils.populate(u, request.getParameterMap());
			u.setImg("img/" + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (udao.signup(u) != 0) {
			updateVisitedCount(request, response); // 방문 횟수 업데이트
			List<Feeds> list;
			list = fdao.getAll();
			request.setAttribute("feedlist", list);
			request.getSession().setAttribute("userimg", u.getImg());
			return "feedlist.jsp";
		} else {
			request.setAttribute("error", "회원가입에 실패하였습니다.");
			return "login.jsp";
		}
	}

	public String write(HttpServletRequest request, HttpServletResponse response) {
		Feeds f = new Feeds();
		String id = (String) request.getSession().getAttribute("login_id");
		String from = (String) request.getSession().getAttribute("from_page");
		
		try {
			Part part = request.getPart("img");
			String fileName = getFilename(part);
			if (fileName != null && !fileName.isEmpty()) {
				String uploadPath = getServletContext().getRealPath("/") + "img" + File.separator + fileName;
				File uploadDir = new File(getServletContext().getRealPath("/") + "img");
				if (!uploadDir.exists()) {
					uploadDir.mkdir();
				}
				part.write(uploadPath);
			}
			BeanUtils.populate(f, request.getParameterMap());
			f.setImg("img/" + fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (fdao.write(f, id) != 0) {
			notUpdateVisitedCount(request, response); // 방문 횟수 업데이트 유지
			List<Feeds> list;
			list = fdao.getAll();
			request.setAttribute("feedlist", list);
			if (from.equals("feedlist"))
				return "feedlist.jsp";
			else
				return "mypage.jsp";
		} else {
			request.setAttribute("error", "글쓰기에 실패하였습니다.");
			return "feedlist.jsp";
		}
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		return "logout.jsp";
	}
	
	public String myinfo(HttpServletRequest request, HttpServletResponse response) {
		notUpdateVisitedCount(request, response); // 방문 횟수 업데이트 유지
		List<Feeds> list;
		list = fdao.getAll();
		request.setAttribute("feedlist", list);
		return "mypage.jsp";
	}
	
	public String back(HttpServletRequest request, HttpServletResponse response) {
		notUpdateVisitedCount(request, response); // 방문 횟수 업데이트 유지
		List<Feeds> list;
		list = fdao.getAll();
		request.setAttribute("feedlist", list);
		return "feedlist.jsp";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response) {
	    String id = (String) request.getSession().getAttribute("login_id");
	    String ts = request.getParameter("ts");
	    String from = (String) request.getSession().getAttribute("from_page");
	    
	    if (fdao.delete(id, ts) != 0) {
	    	notUpdateVisitedCount(request, response); // 방문 횟수 업데이트 유지
	        List<Feeds> list = fdao.getAll();
	        request.setAttribute("feedlist", list);
	        if (from.equals("feedlist"))
				return "feedlist.jsp";
			else
				return "mypage.jsp";
	    } else {
	        request.setAttribute("error", "게시글 삭제에 실패하였습니다.");
	        return "feedlist.jsp";
	    }
	}
	
	public String withdraw(HttpServletRequest request, HttpServletResponse response) {
	    String id = (String) request.getSession().getAttribute("login_id");
	    
	    if (id != null && udao.withdraw(id) != 0) {
	        request.getSession().invalidate(); // 세션 무효화 (로그아웃 효과)
	        return "signout.jsp"; // 탈퇴 후 회원 탈퇴 페이지로 이동
	    } else {
	        request.setAttribute("error", "회원탈퇴에 실패하였습니다.");
	        return "feedlist.jsp";
	    }
	}
	
	private String getFilename(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		String[] tokens = contentDisposition.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf('=') + 2, token.length() - 1);
			}
		}
		return null;
	}
	
	// 방문 횟수(추가) 업데이트 로직
	private void updateVisitedCount(HttpServletRequest request, HttpServletResponse response) {
	    Cookie[] cookies = request.getCookies();
	    Cookie visitedCookie = null;

	    // 기존 방문 횟수 쿠키 찾기
	    for (Cookie cookie : cookies) {
	        if ("visited".equals(cookie.getName())) {
	            visitedCookie = cookie;
	            break;
	        }
	    }

	    if (visitedCookie != null) {
	        // 방문 횟수 증가
	        int count = Integer.parseInt(visitedCookie.getValue()) + 1;
	        visitedCookie.setValue(String.valueOf(count));
	        response.addCookie(visitedCookie);
	        request.getSession().setAttribute("count", count);
	    } else {
	        // 방문 횟수 쿠키가 없으면 새로 생성
	        Cookie newVisitedCookie = new Cookie("visited", "1");
	        response.addCookie(newVisitedCookie);
	        request.getSession().setAttribute("count", "첫");
	    }
	}
	
	// 방문 횟수(유지) 업데이트 로직
		private void notUpdateVisitedCount(HttpServletRequest request, HttpServletResponse response) {
		    Cookie[] cookies = request.getCookies();
		    Cookie visitedCookie = null;

		    // 기존 방문 횟수 쿠키 찾기
		    for (Cookie cookie : cookies) {
		        if ("visited".equals(cookie.getName())) {
		            visitedCookie = cookie;
		            break;
		        }
		    }

		    if (visitedCookie != null) {
		        // 방문 횟수 유지
		        int count = Integer.parseInt(visitedCookie.getValue());
		        visitedCookie.setValue(String.valueOf(count));
		        response.addCookie(visitedCookie);
		        request.getSession().setAttribute("count", count);
		    }
		}
}
