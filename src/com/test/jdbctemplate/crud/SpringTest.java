package com.test.jdbctemplate.crud;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SpringTest {
	
	@Autowired
	private BookDao bookDao;
	
	@Test
	public void testSave() {
		Book book = new Book();
		book.setName("MySQL优化");
		book.setPrice(new BigDecimal(15.6));
		bookDao.save(book);
	}
	
	@Test
	public void testUpdate() {
		Book book = new Book();
		book.setId(1);
		book.setName("MySQL优化1");
		book.setPrice(new BigDecimal(15.61));
		bookDao.update(book);
	}
	
	@Test
	public void testGetById() {
		System.out.println(bookDao.getById(1));
	}
	
	@Test
	public void testGetCount() {
		Map<String, Object> map = new HashMap<>(4);
		map.put("keyWord", "1");
		System.out.println(bookDao.getCount(map));
	}
	
	@Test
	public void testDeleteById() {
		bookDao.deleteById(1);
	}
	
	@Test
	public void testGetAll() {
		System.out.println(bookDao.getAll());
	}
	
	@Test
	public void testGetByParam() {
		Map<String, Object> map = new HashMap<>(4);
		map.put("name", "MySQL");
		System.out.println(bookDao.getByParam(map));
	}
}