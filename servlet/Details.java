package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetDetailsLogic;
import model.Library;
import model.WantBook;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");

	    String from = request.getParameter("from");
	    String isbn = request.getParameter("isbn");

	    String forwardPath = "/WEB-INF/jsp/bookDetails.jsp";

	    switch(from) {
	    case "library":

	        GetDetailsLogic gdLogic = new GetDetailsLogic();
	        List<Library> libraryList = gdLogic.detailsLibrary(isbn);

	        request.setAttribute("libraryList",libraryList);

	        break;

	    case "wantBook":
	        gdLogic = new GetDetailsLogic();
            List<WantBook> wantBookList = gdLogic.detailsWantBook(isbn);

            request.setAttribute("wantBookList", wantBookList);

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    request.setCharacterEncoding("UTF-8");
	    String from = request.getParameter("from");

		String forwardPath ="";

		switch(from) {
		case "library":   //もってるリストに戻るクリック時
		    forwardPath = "/WEB-INF/jsp/library.jsp";
		    break;

		case "wantBook":  //よみたいリストに戻るクリック時
		    forwardPath = "/WEB-INF/jsp/wantBook.jsp";
		    break;

		default:  //それ以外はTOPに戻る
		    forwardPath = "/loginOK.jsp";
		    break;
		}

		// フォワードの実行
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
	}

}