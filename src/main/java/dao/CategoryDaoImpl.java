package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Category;

public class CategoryDaoImpl implements CategoryDao {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"application-context.xml");

	SessionFactory sessionFactory = (SessionFactory) context
			.getBean("categorySessionFactory");
	private Session session = sessionFactory.openSession();

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

}
