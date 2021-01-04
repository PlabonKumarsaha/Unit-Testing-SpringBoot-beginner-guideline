package com.javamaster.spring_crud.repository;

import com.javamaster.spring_crud.entity.Users;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.javamaster.spring_crud.prototype.UsersPrototype.aUser;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void findByLogin() {

        
        Users users = new Users();
        users.setName("test_name");
        users.setLogin("test_login");
        usersRepository.save(users); // save in demo database
        //check the findByLogin method
        Users findUser = usersRepository.findByLogin(users.getLogin());
        assertThat(findUser).isNotNull(); //look if there is any null alue
        assertThat(findUser.getName()).isEqualTo(users.getName()); //compare the values of isnance and data query
    }
}
