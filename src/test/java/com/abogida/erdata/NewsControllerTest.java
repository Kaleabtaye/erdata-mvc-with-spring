package com.abogida.erdata;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.verify;
import static 
    org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static 
    org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;




import com.abogiida.erdata.controllers.NewsController;

@RunWith(SpringRunner.class)
@WebMvcTest(NewsController.class)
public class NewsControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void testNewsPage() throws Exception {
	    mockMvc.perform(get("/"))    // <3>
	    
	      .andExpect(status().isOk())  // <4>
	      
	      .andExpect(view().name("news"));  // <5>  
	  }
	@Test
	public void testNewsViewPage() throws Exception {
	    mockMvc.perform(get("/"))    // <3>
	    
	      .andExpect(status().isOk())  // <4>
	      
	      .andExpect(view().name("newsView"));  // <5>  
	 }
	
	@Test
	public void sumbitNews() throws Exception {
	    mockMvc.perform(post("/news/submitNews")
	        .content("name=Test+News")
	        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
	        .andExpect(status().is3xxRedirection())
	        .andExpect(header().stringValues("Location", "/news"));
	  }
}
