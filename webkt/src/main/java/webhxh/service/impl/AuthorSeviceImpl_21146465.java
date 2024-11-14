package webhxh.service.impl;

import java.util.List;

import webhxh.dao.IAuthorDao_21146465;
import webhxh.dao.impl.AuthorDaoImpl_21146465;
import webhxh.model.AuthorModel_21146465;
import webhxh.service.IAuthorService_21146465;

public class AuthorSeviceImpl_21146465 implements IAuthorService_21146465 {
	
	public IAuthorDao_21146465 authorDao= new AuthorDaoImpl_21146465();

	@Override
	public AuthorModel_21146465 findByAuthorId(int id) {
		// TODO Auto-generated method stub
		return authorDao.findByAuthorId(id);
	}

	@Override
	public List<AuthorModel_21146465> findAllAuthor() {
		// TODO Auto-generated method stub
		return authorDao.findAllAuthor();
	}

	@Override
	public void delete(int id) {
		authorDao.delete(id);
		
	}

	@Override
	public void update(AuthorModel_21146465 author) {
		authorDao.update(author);
		
	}

	@Override
	public void insert(AuthorModel_21146465 author) {
		authorDao.insert(author);
	}

}
