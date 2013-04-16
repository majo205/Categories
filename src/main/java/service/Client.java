package service;




import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dto.CategoryDto;
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
		List<CategoryGroup> groupList = new ArrayList<CategoryGroup>();
		
		SessionFactory sessionFactory; 
		//sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		
		//Session session = sessionFactory.openSession();
		//Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		
	
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		sessionFactory = (SessionFactory) context.getBean("categorySessionFactory");		
		Session session = sessionFactory.openSession();//getCurrentSession();
		
		CategoryDto category = new CategoryDto();//(Category)context.getBean("category");
		CategoryDto cat2= new CategoryDto();
		CategoryGroup group = new CategoryGroup();//(CategoryGroup)context.getBean("group");
		
		new Category("meno", "popis", 25);
		
		category.setCategoryId(50);
		category.setName("NEWcategoryNameCHANGED");
		category.setDescription("NEWcategory descriptionCHANGED");
		category.setDeleted(true);
		category.setOrganisationId(5);
		category.setParentCategory(7);
		category.setUpdateDate(new Date());
		category.setUuid("nejake uuid");		
		category.setPosition(10);
		
		
		
		//categoriesList.add(category);
		
//		category.setName("secondcategoryName");
//		category.setDescription("secondcategory description");		
//		category.setUpdateDate(new Date());		
//		category.setPosition(10);
		//new Category(name, description, parentCategory, position, updateDate, deleted, organisationId, uuid)
		//categoriesList.add(new Category("secondcategoryName", "secondcategory description", null, 11, new Date(), null, null, "nejake ine uid"));
		
		
		//categoriesList.add(cat2);
		
		group.setName("groupName");	
		group.setCategories(categoriesList);
		group.setDescription("group description");
		group.setDeleted(false);		
		group.setOrganizatonId(5);
		group.setUpdatedDate(new Date());
		
		
		//new Service().saveOrUpdate(category);
		
		CategoryDto catDto = new CategoryDto(); 
		catDto.setCategoryDto("taky name CHANGED", "test descr CHANGED", 007, 2, new Date(), false, 1007, "uuid lol");
		//catDto.setCategoryId(80);
		groupList.add(group);
		catDto.setGroups(groupList);
		
		new Service().saveOrUpdate(catDto);
		//System.out.println("vysledok query"+new Service().findCategory(23).toString());
		
		//new Service().delete(new Service().findCategory(23));
		
		//System.out.println("vzsledok query"+new Service().findCategory(23).toString());
//		session.beginTransaction();
//		
//		session.save(new CategoryAssembler().assembleToEntity(category));
//		//session.save(category);
//		session.save(cat2);
//		session.save(group);
//		
//				
//		session.getTransaction().commit();
//		
//		session.close();
		
		
		
	}

}
