package webhxh.service;

import java.util.List;

import webhxh.model.AuthorModel_21146465;

public interface IAuthorService_21146465 {
	AuthorModel_21146465 findByAuthorId(int id);

	List<AuthorModel_21146465> findAllAuthor();
	
	void delete(int id);

	void update(AuthorModel_21146465 author);

	void insert(AuthorModel_21146465 author);

}
