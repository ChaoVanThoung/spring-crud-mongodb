package co.istad.mongodb;

import co.istad.mongodb.dto.UserResponse;
import co.istad.mongodb.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MongodbApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        System.out.println(userRepository.filterByName("Bret"));
    }

    @Test
    void filter(){
        System.out.println(userRepository.filterByAge(40));
    }
}
