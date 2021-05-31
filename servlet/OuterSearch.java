package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OuterSearchLogic;

/**
 * Servlet implementation class OuterSearch
 */
@WebServlet("/OuterSearch")
public class OuterSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OuterSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");

	    //外部毛bb作結果画面までのパス
	    String forwardPath = "/WEB-INF/jsp/searchResult.jsp";

	    //リクエストパラメータの取得
	    String keyword = request.getParameter("keyword");

	    OuterSearchLogic osLogic = new OuterSearchLogic();
	    osLogic.execute(keyword);

	    //セッションスコープに保存
	    HttpSession session = request.getSession();
	    session.setAttribute("keyword", keyword);


	  //フォワードの実行
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);

	}

}