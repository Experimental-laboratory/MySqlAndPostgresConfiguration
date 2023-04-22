package db_service.db_service.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import db_service.db_service.repository.PostgresRepository;
import org.springframework.web.bind.annotation.GetMapping;
import db_service.db_service.repository.MySqlRepository;
import db_service.db_service.dto.Person;
import db_service.db_service.dto.Salary;

import java.util.List;

@RestController
public class CommunicationController
{
    final MySqlRepository mySqlRepository;
    final PostgresRepository pgRepo;

    public CommunicationController(MySqlRepository mySqlRepository, PostgresRepository pgRepo)
    {
        this.mySqlRepository = mySqlRepository;
        this.pgRepo = pgRepo;
    }

    @GetMapping("/queryForSalary")
    public List<Person> filteredBySalary(@RequestBody Salary salary)
    {
        return mySqlRepository.getPersonsFilteredBySalary(salary.getSalary());
    }

    @GetMapping("/actors")
    public List<Person> requestActors()
    {
        return pgRepo.getActorsList();
    }
}
