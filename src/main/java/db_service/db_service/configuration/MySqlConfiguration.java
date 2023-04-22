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
@PropertySource("mysql.properties")
public class MySqlConfiguration
{
    @Value("${mysql.datasource.url}")
    private String dataSourceUrl;

    @Value("${mysql.datasource.username}")
    private String username;

    @Value("${mysql.datasource.password}")
    private String password;

    @Value("${mysql.datasource.driver-class-name}")
    private String driver;

    @Bean(name = "MySqlDS")
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

    @Bean(name = "MySql")
    public JdbcTemplate dataBaseTemplate(@Qualifier("MySqlDS") DataSource datasource)
    {
        return new JdbcTemplate(datasource);
    }
}
