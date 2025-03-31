package News;

import java.io.ByteArrayOutputStream;
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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class NewsController
 */
@MultipartConfig
@WebServlet("/NewsController")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NewsDAO dao;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new NewsDAO();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			/* action에 따른 동작 수행 */
		String action = request.getParameter("action");
		String view = "";
		
		if (action == null) {
			byte[] imageBytes = dao.getImageById(Integer.parseInt(request.getParameter("uid")));
			response.setContentType("image/jpeg");
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(imageBytes);
			outputStream.close();
		} else {
			switch (action) {
			case "addNews":
				view = addNews(request, response);
				break;
			case "getAll":
				view = getAll(request, response);
				break;
			case "getNews":
				view = getNews(request, response);
				break;
			case "delNews":
				view = delNews(request, response);
				break;
			}
			getServletContext().getRequestDispatcher("/" + view).forward(request, response);
		}
	}

	public String addNews(HttpServletRequest request, HttpServletResponse response) {
		/* 뉴스 기사 등록 */
		News n = new News();

		try {
			BeanUtils.populate(n, request.getParameterMap());
			Part filePart = request.getPart("imageFile");

			if (filePart != null) {
				InputStream inputStream = filePart.getInputStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				byte[] imageData = outputStream.toByteArray();

				Blob img = new SerialBlob(imageData);
				n.setImg(img);

				outputStream.close();
				inputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.addNews(n);
		return "NewsController?action=getAll";
	}

	public String getAll(HttpServletRequest request, HttpServletResponse response) {
		/* 전체 뉴스 리스트 획득 */
		List<News> list;

		try {
			list = dao.getAll();
			request.setAttribute("newslist", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "뉴스 목록이 정상적으로 처리되지 않았습니다.");
		}
		return "newsList.jsp";
	}

	public String getNews(HttpServletRequest request, HttpServletResponse response) {
		/* 뉴스 기사 선택 */
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			News n = dao.getNews(id);
			request.setAttribute("news", n);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다");
			return getAll(request, response);
		}
		return "newsView.jsp";
	}

	public String delNews(HttpServletRequest request, HttpServletResponse response) {
		/* 뉴스 기사 삭제 */
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			dao.delNews(id);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "뉴스를 정상적으로 삭제하지 못했습니다");
			return getAll(request, response);
		}
		return "NewsController?action=getAll";
	}
}