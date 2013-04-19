package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import entity.Category;

public class CategoryDaoImpl implements CategoryDao {

	
	private SessionFactory sessionFactory ;
	private Session session;
	
	public CategoryDaoImpl(){
		
	}

	@Override
	@Transactional
	public Category find(Integer id) {
		return (Category) this.session.get(Category.class, id);
	}

	@Override
	@Transactional
	public void saveOrUpdate(Category category) {

		this.session.saveOrUpdate(category);
		
	}

	@Override
	@Transactional
	public void delete(Category category) {
		this.session.delete(category);
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Autowired
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
