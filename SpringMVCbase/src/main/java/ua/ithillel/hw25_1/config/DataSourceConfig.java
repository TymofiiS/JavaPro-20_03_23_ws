package ua.ithillel.hw25_1.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource dataSource() {
		
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost/hibernate");
        config.setUsername("root");
        config.setPassword("hjIt64-JkeUY");  
        config.setDriverClassName("com.mysql.jdbc.Driver");

        //config.setDataSourceClassName("org.springframework.jdbc.datasource.DriverManagerDataSource");

        return new HikariDataSource(config);
	}
	
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public SimpleJdbcInsert simpleJdbcInsert(DataSource dataSource) {
        return new SimpleJdbcInsert(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        return new JdbcTransactionManager(dataSource);
    }
	
}
