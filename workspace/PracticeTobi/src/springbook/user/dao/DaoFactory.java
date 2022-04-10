package springbook.user.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DaoFactory {
	
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource=new SimpleDriverDataSource();
		
		dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost/springbook?serverTimezone=UTC");
		dataSource.setUsername("ssafy");
		dataSource.setPassword("ssafy");
		
		return dataSource;
	}
	
	@Bean
	public UserDao userDao() {
		UserDao userDao=new UserDao();
		userDao.setDataSource(dataSource());
		return userDao;
	}
	
}
