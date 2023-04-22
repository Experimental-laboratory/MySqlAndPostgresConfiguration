package db_service.db_service.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import db_service.db_service.dto.Person;

import java.util.List;

@Repository
public class PostgresRepository
{
    @Autowired
    @Qualifier("Postgresql")
    private JdbcTemplate jdbcTemplate;

    public List<Person> getActorsList()
    {
        return jdbcTemplate.query("select * from actor", new ActorRowMapper());
    }
}
