package db_service.db_service.repository;

import org.springframework.jdbc.core.RowMapper;
import db_service.db_service.dto.Person;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ActorRowMapper implements RowMapper
{
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Person actor = new Person();

        actor.setId(rs.getInt("actor_id"));
        actor.setName(rs.getString("first_name"));
        actor.setLastName(rs.getString("last_name"));

        return actor;
    }
}
