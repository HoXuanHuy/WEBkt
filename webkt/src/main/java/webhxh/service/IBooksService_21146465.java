package webhxh.service;

import java.util.List;

import webhxh.model.BooksModel_21146465;

public interface IBooksService_21146465 {
	
	BooksModel_21146465 findByBookId(int id);

	List<BooksModel_21146465> findAll();

}
