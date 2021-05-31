package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EditLogic;
import model.GetDetailsLogic;
import model.Library;



/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String forwardPath = "";
        String from = request.getParameter("from");
        String isbn = request.getParameter("isbn");
        switch(from) {

        case "library":

        	GetDetailsLogic gdLogic = new GetDetailsLogic();
	        List<Library> libraryList = gdLogic.detailsLibrary(isbn);

	        request.setAttribute("libraryList",libraryList);
	        
        	forwardPath = "/WEB-INF/jsp/libraryEdit.jsp";
        	break;

        case "wantBook":

        	break;

        	default:
        		break;
        }
     // フォワードの実行
        RequestDispatcher dispatcher =
        		request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");

        String forwardPath = "";

        // リクエストパラメータの取得
        String from = request.getParameter("from");

        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String overview = request.getParameter("overview");



        switch (from) {

        	case "library":
        		EditLogic editLogic = new EditLogic();
        		List<Library> libraryList = editLogic.updateLibrary(isbn, title, author, publisher, overview);

        		//スコープに保存
        		HttpSession session = request.getSession();
        		session.setAttribute("libraryList", libraryList);
        		forwardPath = "/WEB-INF/jsp/libraryEdit.jsp";
        		break;

        	case "wantBook":
        		forwardPath = "/WEB-INF/jsp/wantBookEdit.jsp";
        		break;

        	default:
        		forwardPath = "/WEB-INF/jsp/loginOK.jsp";
        		break;

        }
        // フォワードの実行
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
    }

}