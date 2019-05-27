package com.kaleab.TacoCloud;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.Abogida.Erdata.controllers.LoginController;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class) 
public class LoginControllerTest {
	  @Autowired
	  private MockMvc mockMvc;
	  @Test
	  public void testLoginPage() throws Exception {
	    mockMvc.perform(get("/"))    // <3>
	    
	      .andExpect(status().isOk())  // <4>
	      
	      .andExpect(view().name("login"));  // <5>  
	  }
}
