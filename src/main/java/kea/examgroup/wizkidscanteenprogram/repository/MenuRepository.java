package kea.examgroup.wizkidscanteenprogram.repository;

import kea.examgroup.wizkidscanteenprogram.model.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Repository for the instances of the Menu class which extends the Crud repository for easy database CRUD
@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {


}
