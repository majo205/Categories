package service;




import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Category;
import entity.CategoryGroup;

public class Client {
	
	public static void main(String[] args) throws ParseException {
		
//		odporucanz postup
//		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//		SessionFactory sFactory = context.getBean("categorySessionFactory");
//		Session session = sFactory.getCurrentSession();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd");
		Timestamp date = new Timestamp(new Date().getTime());
		List<Category> categoriesList = new ArrayList<Category>();
		
		SessionFactory sessionFactory; 
		//sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		
		//Session session = sessionFactory.openSession();
		//Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		
	
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		sessionFactory = (SessionFactory) context.getBean("categorySessionFactory");		
		Session session = sessionFactory.openSession();//getCurrentSession();
		
		Category category = new Category();//(Category)context.getBean("category");
		Category cat2= new Category("meno", "popis", 25);
		CategoryGroup group = new CategoryGroup();//(CategoryGroup)context.getBean("group");
		
		category.setName("categoryName");
		category.setDescription("category description");
		category.setDeleted(true);
		category.setOrganisationId(5);
		category.setParentCategory(7);
		category.setUpdateDate(new Date());
		category.setUuid("nejake uuid");		
		category.setPosition(10);
		
		categoriesList.add(category);
		
//		category.setName("secondcategoryName");
//		category.setDescription("secondcategory description");		
//		category.setUpdateDate(new Date());		
//		category.setPosition(10);
		//new Category(name, description, parentCategory, position, updateDate, deleted, organisationId, uuid)
		//categoriesList.add(new Category("secondcategoryName", "secondcategory description", null, 11, new Date(), null, null, "nejake ine uid"));
		
		
		categoriesList.add(cat2);
		
		group.setName("groupName");	
		group.setCategories(categoriesList);
		group.setDescription("group description");
		group.setDeleted(false);		
		group.setOrganizatonId(5);
		group.setUpdatedDate(new Date());
		
		session.beginTransaction();
		session.save(category);
		session.save(cat2);
		session.save(group);
		session.getTransaction().commit();
		
		session.close();
		
	}

}
