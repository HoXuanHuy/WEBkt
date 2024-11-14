package webhxh.service.impl;

import java.util.List;


import webhxh.dao.IBookAuthorDao_21146465;

import webhxh.dao.impl.BookAuthorDaoImpl_2114645;
import webhxh.model.BookAuthorModel_21146465;
import webhxh.service.IBookAuthorService_21146465;

public class BookAuthorServiceImpl_21146465 implements IBookAuthorService_21146465 {
	
	public IBookAuthorDao_21146465 authorDao= new BookAuthorDaoImpl_2114645();

	@Override
	public BookAuthorModel_21146465 findByAuthorId(int id) {
		// TODO Auto-generated method stub
		return authorDao.findByAuthorId(id);
	}

	@Override
	public List<BookAuthorModel_21146465> findAll() {
		// TODO Auto-generated method stub
		return authorDao.findAll();
	}

}
