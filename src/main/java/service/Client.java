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
		List<CategoryDto> categoryDtosList = new ArrayList<CategoryDto>();
		List<CategoryGroupDto> groupDtosList = new ArrayList<CategoryGroupDto>();
		
		SessionFactory sessionFactory; 
		//sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		
		//Session session = sessionFactory.openSession();
		//Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		sessionFactory = (SessionFactory) context.getBean("sessionFactory");		
		Session session = (Session) context.getBean("session");//getCurrentSession();
		//session.
		
		Service service = (Service) context.getBean("service");
		
		
		CategoryDto categoryDto	= new CategoryDto();
		CategoryDto cat2Dto= new CategoryDto();
		CategoryGroupDto groupDto = new CategoryGroupDto();		
		
		
		
		groupDto.setName("groupName");		
		groupDto.setDescription("group description");
		groupDto.setDeleted(false);		
		groupDto.setOrganizatonId(5);
		groupDto.setUpdatedDate(new Date());
		
		
		categoryDto.setName("categoryName");
		categoryDto.setDescription("category description");
		categoryDto.setDeleted(true);
		categoryDto.setOrganisationId(5);
		categoryDto.setParentCategory(7);
		categoryDto.setUpdateDate(new Date());
		categoryDto.setUuid("nejake uuid");		
		categoryDto.setPosition(10);
		
		groupDtosList.add(groupDto);
		categoryDtosList.add(categoryDto);
		
		categoryDto.setGroups(groupDtosList);		
		groupDto.setCategories(categoryDtosList);
		
		
		
					
		CategoryDto catDto = new CategoryDto(); 
		catDto.setCategoryDto("taky name CHANGED", "test descr CHANGED", 007, 2, new Date(), false, 1007, "uuid lol");
		catDto.setGroups(groupDtosList);
		
		service.saveOrUpdate(groupDto);
		service.saveOrUpdate(categoryDto);
		service.saveOrUpdate(catDto);
		
		//service.saveOrUpdate(category);
		
//		service.saveOrUpdate(categoryDto);
//		
//		System.out.println("dto "+service.findCategory(9).toString());
//		
		
		
		
	}

}
