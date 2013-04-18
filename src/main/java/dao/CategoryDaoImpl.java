package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import entity.Category;

public class CategoryDaoImpl implements CategoryDao {

	
	private SessionFactory sessionFactory ;
	private Session session;
	
	public CategoryDaoImpl(){
		this.session = sessionFactory.openSession();//getCurrentSession();
	}

	@Override
	public Category find(Integer id) {
		return (Category) this.session.get(Category.class, id);
	}

	@Override
	public void saveOrUpdate(Category category) {

		try {
			Integer catID = category.getCategoryId();

			
			if (catID != null) {
				if (this.find(catID) != null) {
					this.session.saveOrUpdate(category);
				} else {
					this.session.save(category);
					System.err
							.println("Unable to insert specific value to categoryId! New one was generated!");
				}
			}

		} catch (NullPointerException e) {
			System.err.println("Null pointer in categoryId! Category inserted with generated Id!");
			this.session.save(category);
		}

	}

	@Override
	public void delete(Category category) {
		this.session.delete(category);
	}

	public Session getSession() {
		return session;
	}

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
