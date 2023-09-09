package ua.ithillel.hw25_9.springlombokmigration.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJdbcRepositories("ua.ithillel.hw25_9.springlombokmigration.persistence.repository")
public class DataSourceConfig {
	
	@Bean
	public TransactionManager transactionManager(DataSource dataSource) {
		return new JdbcTransactionManager(dataSource);
	}
	
	@Bean
	public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}

}
