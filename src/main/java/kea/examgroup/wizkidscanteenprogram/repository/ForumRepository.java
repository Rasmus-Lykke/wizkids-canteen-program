package kea.examgroup.wizkidscanteenprogram.repository;

import kea.examgroup.wizkidscanteenprogram.model.Forum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Repository for the instances of the Forum class which extends the Crud repository for easy database CRUD
@Repository
public interface ForumRepository extends CrudRepository<Forum, Long> {


}
