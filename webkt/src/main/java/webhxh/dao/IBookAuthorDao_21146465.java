package webhxh.dao;

import java.util.List;

import webhxh.model.BookAuthorModel_21146465;

public interface IBookAuthorDao_21146465 {

	BookAuthorModel_21146465 findByAuthorId(int id);

	List<BookAuthorModel_21146465> findAll();

	List<BookAuthorModel_21146465> findlistauthorid(int keyword);

}
