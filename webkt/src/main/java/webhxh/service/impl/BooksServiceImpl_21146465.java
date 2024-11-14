package webhxh.service.impl;

import java.util.List;


import webhxh.dao.IBooksDao_21146465;

import webhxh.dao.impl.BooksDaoImpl_21146465;
import webhxh.model.BooksModel_21146465;
import webhxh.service.IBooksService_21146465;

public class BooksServiceImpl_21146465 implements IBooksService_21146465 {
	
	public IBooksDao_21146465 authorDao= new BooksDaoImpl_21146465();


	@Override
	public BooksModel_21146465 findByBookId(int id) {
		// TODO Auto-generated method stub
		return authorDao.findByBookId(id);
	}

	@Override
	public List<BooksModel_21146465> findAll() {
		// TODO Auto-generated method stub
		return authorDao.findAll();
	}

}
