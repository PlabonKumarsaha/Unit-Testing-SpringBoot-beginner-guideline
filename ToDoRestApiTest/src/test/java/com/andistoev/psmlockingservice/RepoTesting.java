package com.andistoev.psmlockingservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.teksoi.restapi.model.ToDo;
import com.teksoi.restapi.repository.ToDoRepository;

@DataJpaTest
public class RepoTesting {

  @Autowired
  TestEntityManager entityManager;
  
  @Autowired
  private ToDoRepository toDoRepository;
  @Test
  public void testSaveNewProduct() throws ParseException {
	//  System.out.println(toDoRepository.finaltest);
	  
	  String sDate1="31-12-1998";  
      Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);  
     ToDo toDo = new ToDo();
     toDo.setId(1L);
     toDo.setTitle("I am a title");
     toDo.setDescription("svdjbdjabdjabdjabdajdbja");
    // toDo.setEventDate(date1);
     System.out.println(toDo);
     
      entityManager.persist(toDo);
               
//      ToDo toDo2 = toDoRepository.findByTitle("I am a title");
//      assertThat(toDo2.getTitle()).isEqualTo("I am a title");
       
    //  assertThat(product.getName()).isEqualTo("iPhone 10");
  }
	
	
	
}
