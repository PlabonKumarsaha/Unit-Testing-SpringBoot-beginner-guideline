package com.javamaster.spring_crud.repository;

import com.javamaster.spring_crud.entity.Users;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    
    @Test
    void findByLogin() {
        
        Users users = new Users();
        users.setId(1);
        users.setName("test_name");
        users.setLogin("test_login");
        
        usersRepository.save(users); // save in demo database
        //check the findByLogin method
        Users findUser = usersRepository.findByLogin(users.getLogin());
        assertThat(findUser).isNotNull(); //look if there is any null alue
        assertThat(findUser.getName()).isEqualTo(users.getName()); //compare the values of isnance and data query
    }
    @Disabled
    @Test
    void testSave() {

        
        Users users = new Users();
        users.setId(1);
        users.setName("test_name");
        users.setLogin("test_login");
        
        Users users2 = new Users();
        users.setId(2);
        users.setName("test_name2");
        users.setLogin("test_login2");
        
        
        Users users3 = new Users();
        users.setId(3);
        users.setName("test_name3");
        users.setLogin("test_login3");
        
        usersRepository.save(users); // save in demo database
        usersRepository.save(users2); 
        usersRepository.save(users3); 
        //check the findByLogin method
        List<Users> findUser = new ArrayList<Users>();
        findUser = usersRepository.findAll();
        System.out.println("i am log "+findUser.get(1).getName());
        assertThat(findUser.get(1).getName()).isNotNull(); //look if there is any null alue
       // assertThat(findUser.get(1).getName()).isEqualTo(users.getName()); //compare the values of isnance and data query
    }
}
