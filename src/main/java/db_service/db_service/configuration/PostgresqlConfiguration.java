package db_service.db_service.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

@Configuration
@PropertySource("postgresql.properties")
public class PostgresqlConfiguration
{
    @Value("${postgresql.datasource.url}")
    private String dataSourceUrl;

    @Value("${postgresql.datasource.username}")
    private String username;

    @Value("${postgresql.datasource.password}")
    private String password;

    @Value("${postgresql.datasource.driver-class-name}")
    private String driver;

    @Bean(name = "PostgresDS")
    public DataSource dataSource()
    {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dataSourceUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);
        dataSource.setConnectionTimeout(1000);
        return dataSource;
    }

    @Bean(name = "Postgresql")
    public JdbcTemplate dataBaseTemplate(@Qualifier("PostgresDS") DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }
}
