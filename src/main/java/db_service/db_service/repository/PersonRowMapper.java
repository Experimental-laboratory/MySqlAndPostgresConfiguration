package db_service.db_service.repository;

import org.springframework.jdbc.core.RowMapper;
import db_service.db_service.dto.Person;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PersonRowMapper implements RowMapper
{
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Person person = new Person();

        person.setId(rs.getInt("emp_no"));
        person.setName(rs.getString("first_name"));
        person.setLastName(rs.getString("last_name"));

        return person;
    }
}
