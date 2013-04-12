package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Category;

public class CategoryDaoImpl implements CategoryDao{
	
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"application-context.xml");

	SessionFactory sessionFactory = (SessionFactory) context
			.getBean("categorySessionFactory");
	Session session = sessionFactory.openSession();

	@Override
	public Category find(Integer id) {		
		return (Category) this.session.get(Category.class, id);
	}

	@Override
	public void saveOrUpdate(Category category) {		
		this.session.saveOrUpdate(category);
	}

	@Override
	public void delete(Category category) {
		this.session.delete(category);
	}

}
