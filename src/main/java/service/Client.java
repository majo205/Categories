package service;




import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Category;
import entity.CategoryGroup;

public class Client {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd");
		Timestamp date = new Timestamp(new Date().getTime());
		
		SessionFactory sessionFactory; 
		//sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		
		//Session session = sessionFactory.openSession();
		Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		Category category = (Category)context.getBean("category");
		CategoryGroup group =(CategoryGroup)context.getBean("group");
		
		category.setName("categoryName");
		category.setDescription("category description");
		category.setDeleted(true);
		category.setOrganisationId(5);
		category.setParentCategory(7);
		category.setUpdateDate(new Date());
		category.setUuid("nejake uuid");		
		category.setPosition(10);
		
		
		group.setName("groupName");		
		group.setDescription("group description");
		group.setDeleted(false);		
		group.setOrganizatonId(5);
		group.setUpdatedDate(new Date());
		
		session.beginTransaction();
		session.save(category);
		session.save(group);
		session.getTransaction().commit();
		
		session.close();
		
	}

}
