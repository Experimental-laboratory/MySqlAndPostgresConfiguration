package db_service.db_service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import db_service.db_service.dto.Person;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class MySqlRepository
{
    @Autowired
    @Qualifier("MySql")
    private JdbcTemplate jdbcTemplate;

    public List<Person> getPersonsFilteredBySalary(final BigDecimal salary)
    {
        return jdbcTemplate.query("select emp_no, first_name, last_name from employees where emp_no = any (select emp_no from salaries where salary > ?)",
                new PersonRowMapper(), salary);
    }
}
