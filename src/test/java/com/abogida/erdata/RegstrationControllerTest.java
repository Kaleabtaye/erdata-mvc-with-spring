package com.abogida.erdata;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.abogiida.erdata.controllers.RegistrationController;

@RunWith(SpringRunner.class)
@WebMvcTest(RegistrationController.class) 
public class RegstrationControllerTest {
	  @Autowired
	  private MockMvc mockMvc;
	  @Test
	  public void testRegisterPage() throws Exception {
	    mockMvc.perform(get("/"))    // <3>
	    
	      .andExpect(status().isOk())  // <4>
	      
	      .andExpect(view().name("register"));  // <5>  
	  }
	  
	  @Test 
	  public void createNewUser() throws Exception{
		  mockMvc.perform(post("/register")
			        .content("name=Test+register")
			        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
			        .andExpect(status().is3xxRedirection())
			        .andExpect(header().stringValues("Location", "/index"));  
	  }
	  
	  @Test 
	  public void createNewReciever() throws Exception{
		  mockMvc.perform(post("/register/recieverRegistration")
			        .content("name=Test+register")
			        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
			        .andExpect(status().is3xxRedirection())
			        .andExpect(header().stringValues("Location", "/index"));  
	  }
	  
	  @Test
	  @WithMockUser(username = "kale23", password = "kale23")
	  public void testGetForUnauthorizedUser() throws Exception{
	        mockMvc.perform(formLogin().user("kale23").password("kale23"))
	        .andDo(
	               result -> mockMvc.perform(get("/register"))
	               .andExpect(forwardedUrl("/accessDenied")));
	    }
	    
	   @Test(expected = StackOverflowError.class)
	   @WithMockUser(username = "kale23", password = "kale23")
	   public void testGetForValidUser() throws Exception{
	        mockMvc.perform(formLogin().user("kale23").password("kale23"))
	        .andExpect(status().isFound())
	        .andDo(
	               result -> mockMvc.perform(get("/register"))
	               .andExpect(status().isOk()));
	    }
	  
}




