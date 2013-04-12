package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.CategoryGroup;

public class CategoryGroupDaoImpl implements CategoryGroupDao {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"application-context.xml");

	SessionFactory sessionFactory = (SessionFactory) context
			.getBean("categorySessionFactory");
	Session session = sessionFactory.openSession();

	@Override
	public CategoryGroup find(Integer id) {
		return this.find(id);
	}

	@Override
	public void saveOrUpdate(CategoryGroup group) {
		this.session.saveOrUpdate(group);
	}

	@Override
	public void delete(CategoryGroup group) {
		this.session.delete(group);
	}

}
