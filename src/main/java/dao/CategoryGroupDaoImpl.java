package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.CategoryGroup;

public class CategoryGroupDaoImpl implements CategoryGroupDao {

	
	private SessionFactory sessionFactory;
	private Session session;

	public CategoryGroupDaoImpl(){
		this.session = sessionFactory.openSession();
	}
	
	@Override
	public CategoryGroup find(Integer id) {
		return this.find(id);
	}

	@Override
	public void saveOrUpdate(CategoryGroup group) {
		
		
		
		try {
			Integer grpID = group.getCategoryGroupId();

			
			if (grpID != null) {
				if (this.find(grpID) != null) {
					this.session.saveOrUpdate(group);
				} else {
					this.session.save(group);
					System.err
							.println("Unable to insert specific value to categoryGroupId! New one was generated!");
				}
			}

		} catch (NullPointerException e) {
			System.err.println("Null pointer in categoryGroupId! CategoryGroup inserted with generated Id!");
			this.session.save(group);
		}
		
//		try{
//			Integer catID = group.getCategoryGroupId();
//			
//			if (catID>0){
//				this.session.save(group);
//				System.err.println("Unable to insert specific key! New one was generated!");
//			} else
//			 
//			this.session.saveOrUpdate(group);
//			
//		}catch (NullPointerException e){			
//			this.session.save(group);
//		}
				
	}

	@Override
	public void delete(CategoryGroup group) {
		this.session.delete(group);
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
