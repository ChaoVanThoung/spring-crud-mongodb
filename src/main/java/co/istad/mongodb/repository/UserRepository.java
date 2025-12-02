package co.istad.mongodb.repository;

import co.istad.mongodb.domain.User;
import co.istad.mongodb.filter.FilterableRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> , FilterableRepository<User> {

    @Query("{username: {$regex: ?0 }}")
    List<User> filterByName(String name);

    @Query("{age: {$lt:  ?0}}")
    List<User> filterByAge(Integer age);
}
