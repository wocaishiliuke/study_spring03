package com.test.jdbctemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SpringTest {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void testSave() {
		this.jdbcTemplate.execute("create table test8(id int,name varchar(20),price decimal(10,2))");
	}
	
}
