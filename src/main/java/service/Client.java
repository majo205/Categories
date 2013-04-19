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

import dao.CategoryDaoImpl;
import dto.CategoryDto;
import dto.CategoryGroupDto;
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
		List<CategoryDto> categoriesList = new ArrayList<CategoryDto>();
		List<CategoryGroupDto> groupList = new ArrayList<CategoryGroupDto>();
		
		SessionFactory sessionFactory; 
		//sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		
		//Session session = sessionFactory.openSession();
		//Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		sessionFactory = (SessionFactory) context.getBean("sessionFactory");		
		Session session = (Session) context.getBean("session");//getCurrentSession();
		//session.
		
		Service service = (Service) context.getBean("service");
		
		
		CategoryDto category = new CategoryDto();//(Category)context.getBean("category");
		CategoryDto cat2= new CategoryDto();
		CategoryGroup group = new CategoryGroup();//(CategoryGroup)context.getBean("group");
		
		new Category("meno", "popis", 25);
		
		//category.setCategoryId(50);
		category.setName("NEWcategoryNameCHANGED");
		category.setDescription("NEWcategory descriptionCHANGED");
		category.setDeleted(true);
		category.setOrganisationId(5);
		category.setParentCategory(7);
		category.setUpdateDate(new Date());
		category.setUuid("nejake uuid");		
		category.setPosition(10);
		
		
		
		
		group.setName("groupName");	
		//group.setCategories(categoriesList);
		group.setDescription("group description");
		group.setDeleted(false);		
		group.setOrganizatonId(5);
		group.setUpdatedDate(new Date());
		
		
		//new Service().saveOrUpdate(category);
		
		CategoryDto catDto = new CategoryDto(); 
		catDto.setCategoryDto("taky name CHANGED", "test descr CHANGED", 007, 2, new Date(), false, 1007, "uuid lol");
		//catDto.setCategoryId(80);
	//	groupList.add(group);
		catDto.setGroups(groupList);
		
		//service.saveOrUpdate(category);
		
		System.out.println(service.findCategory(10));
		
		
		
		
	}

}
