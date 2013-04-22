package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import entity.CategoryGroup;

public class CategoryGroupDaoImpl implements CategoryGroupDao {

	private SessionFactory sessionFactory;
	private Session session;

	@Override
	@Transactional
	public CategoryGroup find(Integer id) {
		return this.find(id);
	}

	@Override
	@Transactional
	public void saveOrUpdate(CategoryGroup group) {
		this.session.saveOrUpdate(group);
	}

	@Override
	@Transactional
	public void delete(CategoryGroup group) {
		this.session.delete(group);
	}

	public Session getSession() {
		return session;
	}

	@Autowired
	public void setSession(Session session) {
		this.session = session;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
