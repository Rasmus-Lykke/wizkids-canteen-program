package kea.examgroup.wizkidscanteenprogram.repository;

import kea.examgroup.wizkidscanteenprogram.model.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Repository for the instances of the Authority class which extends the Crud repository for easy database CRUD
@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {

}
