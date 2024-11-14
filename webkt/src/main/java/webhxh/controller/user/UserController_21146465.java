package webhxh.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webhxh.dao.IBooksDao_21146465;
import webhxh.dao.impl.BooksDaoImpl_21146465;
import webhxh.model.AuthorModel_21146465;
import webhxh.model.BookAuthorModel_21146465;
import webhxh.model.BooksModel_21146465;

import webhxh.service.IAuthorService_21146465;
import webhxh.service.IBookAuthorService_21146465;
import webhxh.service.impl.AuthorSeviceImpl_21146465;
import webhxh.service.impl.BookAuthorServiceImpl_21146465;

@WebServlet(name = "MultiPartServlet",urlPatterns = {"/list_author"})

public class UserController_21146465 extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IAuthorService_21146465 authorService= new AuthorSeviceImpl_21146465();
	public IBookAuthorService_21146465 bookauthor= new BookAuthorServiceImpl_21146465();
	public IBooksDao_21146465 bookDao=new BooksDaoImpl_21146465();

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			String url=req.getRequestURI();
			
			if (url.contains("/list_author")) {
				List<AuthorModel_21146465> list =authorService.findAllAuthor();
			
		        for (AuthorModel_21146465 author : list) {
		            int authorId = author.getAuthor_id();
		            BookAuthorModel_21146465 bookau=new BookAuthorModel_21146465();
		            bookau=bookauthor.findByAuthorId(authorId);
		            int bookid= bookau.getBookid();
		            BooksModel_21146465 book=new BooksModel_21146465();
		            book=bookDao.findByBookId(bookid);
		            req.setAttribute("book", book);
		        }		
				req.setAttribute("list", list);
				req.getRequestDispatcher("/views/author-list.jsp").forward(req, resp);
			}
		}

}
