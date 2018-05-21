package com.test.jdbctemplate;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateTest {
	@Test
	public void test() {
		//1.创建数据源(spring提供的数据源)
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test_spring");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//2.创建jdbcTemplate模板类
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);	//jdbcTemplate.setDataSource(dataSource)
		//3.执行语句
		jdbcTemplate.execute("create table test1(id int,name varchar(20),price decimal(10,2))");
	}
}
