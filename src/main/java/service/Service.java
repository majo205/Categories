package service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dto.CategoryDto;

import assembler.CategoryAssembler;

import entity.Category;
import entity.CategoryGroup;

public class Service {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd");
		Timestamp date = new Timestamp(new Date().getTime());
		List<Category> categoriesList = new ArrayList<Category>();
		CategoryAssembler categoryAssembler = new CategoryAssembler();

		SessionFactory sessionFactory;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application-context.xml");

		sessionFactory = (SessionFactory) context
				.getBean("categorySessionFactory");
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		CategoryDto categoryDto = new CategoryDto();// (Category)context.getBean("category");
		Category cat2 = new Category("meno", "popis", 25);
		CategoryGroup group = new CategoryGroup();// (CategoryGroup)context.getBean("group");

		categoryDto.setName("categoryName");
		categoryDto.setDescription("category description");
		categoryDto.setDeleted(true);
		categoryDto.setOrganisationId(5);
		categoryDto.setParentCategory(7);
		categoryDto.setUpdateDate(new Date());
		categoryDto.setUuid("nejake uuid");
		categoryDto.setPosition(10);

		categoriesList.add(categoryDto);

		categoriesList.add(cat2);

		group.setName("groupName");
		group.setCategories(categoriesList);
		group.setDescription("group description");
		group.setDeleted(false);
		group.setOrganizatonId(5);
		group.setUpdatedDate(new Date());

		// session.save(categoryDto);
		// session.save(cat2);
		// session.save(group);

		session.save(categoryAssembler.assembleToEntity(categoryDto));
		
		

		session.getTransaction().commit();

		session.close();

	}

}
