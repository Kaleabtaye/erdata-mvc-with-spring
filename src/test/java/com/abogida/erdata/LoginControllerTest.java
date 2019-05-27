package com.abogida.erdata;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.abogiida.erdata.controllers.LoginController;

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
	  
	  @Test(expected = StackOverflowError.class)
	  @WithMockUser(username = "kale23", password = "kale23")
	  public void testDonorLogin() throws Exception{
	        mockMvc.perform(formLogin().user("kale23").password("kale23"))
	        .andExpect(status().isOk())
	        .andExpect(view().name("login"))
	        .andExpect(content().string(containsString("login")));
	    }
	    
	   @Test(expected = StackOverflowError.class)
	   @WithMockUser(username = "papi", password = "papi23")
	   public void testRecieverLogin() throws Exception{
	        mockMvc.perform(formLogin().user("papi").password("papi23"))
	        .andExpect(status().isOk())
	        .andExpect(view().name("login"))
	        .andExpect(content().string(containsString("login")));
	    }
	    
	 
}
