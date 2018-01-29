package com.todo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//@Configuration
public class DataBaseConfig {

	@Bean("toDoApiJdbcTemplate")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate()
    {
        return new NamedParameterJdbcTemplate( getDataSource() );
    }

	private DataSource getDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
}
