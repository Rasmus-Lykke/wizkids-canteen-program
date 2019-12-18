package kea.examgroup.wizkidscanteenprogram.repository;

import kea.examgroup.wizkidscanteenprogram.model.WizkidsUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Repository for the instances of the WizkidsUser class which extends the Crud repository for easy database CRUD
@Repository
public interface WizkidsUserRepository extends CrudRepository<WizkidsUser, Long> {

    // Finds a WizkidsUser from a username
    WizkidsUser findUserByUsername(String username);
}

