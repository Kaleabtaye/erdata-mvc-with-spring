package com.abogida.erdata;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.abogiida.erdata.controllers.FreeAidController;

@RunWith(SpringRunner.class)
@WebMvcTest(FreeAidController.class)
public class JobControllerTest {
	private MockMvc mockMvc;
	@Test
	public void testJobPage() throws Exception {
	    mockMvc.perform(get("/"))    
	    
	      .andExpect(status().isOk())  
	      
	      .andExpect(view().name("job"));   
	  }
	@Test
	public void testJobViewPage() throws Exception {
	    mockMvc.perform(get("/"))    
	    
	      .andExpect(status().isOk())  
	      
	      .andExpect(view().name("jobView"));   
	  }
	
	
	@Test
	public void postJob() throws Exception {
	    mockMvc.perform(post("job")
	        .content("name=Test+job")
	        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
	        .andExpect(status().is3xxRedirection())
	        .andExpect(header().stringValues("Location", "/job"));
	  }
}
