package ru.isshepelev.restsecurity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.isshepelev.restsecurity.entity.Users;

@Repository
public interface UserRepository extends MongoRepository<Users,String> {
    Users findByUsername(String username);
}
