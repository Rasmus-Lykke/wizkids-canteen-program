package kea.examgroup.wizkidscanteenprogram.repository;

import kea.examgroup.wizkidscanteenprogram.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Repository for the instances of the Order class which extends the Crud repository for easy database CRUD
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    // Uses the crud repository to find all orders which has a specific wizkidsUserId
    Iterable<Order> findAllByWizkidsUserId(Long wizkidsUserId);
}