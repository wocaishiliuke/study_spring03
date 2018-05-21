package com.test.jdbctemplate.crud;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BookDao extends JdbcDaoSupport {
	
	public void save(Book book) {
		String sql = "insert into book values(null,?,?)";
		//jdbcTemplate成员变量是父类private的，子类只能通过getter方法访问
		this.getJdbcTemplate().update(sql,book.getName(),book.getPrice());
	}
	
	public void update(Book book) {
		String sql = "update book set name=?,price=? where id=?";
		this.getJdbcTemplate().update(sql,book.getName(),book.getPrice(),book.getId());
	}
	
	public Book getById(Integer id) {
		String sql = "select * from book where id=?";
		return this.getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
	}
	
	public Integer getCount(Map<String, Object> map) {
		String sql = "select count(*) from book where name like ?";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class, "%" + map.get("keyWord") + "%");
	}
	
	public void deleteById(Integer id) {
		String sql = "delete from book where id=?";
		this.getJdbcTemplate().update(sql, id);
	}
	
	public List<Book> getAll() {
		String sql = "select * from book";
		return this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Book.class));
	}
	
	public List<Book> getByParam(Map<String, Object> map) {
		String sql = "select * from book where name like ?";
		return this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Book.class), "%" + map.get("name") + "%");
	}
}
