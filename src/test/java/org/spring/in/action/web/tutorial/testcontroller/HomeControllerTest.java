package org.spring.in.action.web.tutorial.testcontroller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.spring.in.action.web.tutorial.controller.HomeController;
import static
org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static
org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static
org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.springframework.test.web.servlet.MockMvc;

public class HomeControllerTest {

	@Test
	public void testHome() {
		HomeController homeController  = new HomeController();
		assertEquals("home", homeController.home());
	}
	
	@Test
	public void testRequestFromHome() throws Exception{
		HomeController homeController  = new HomeController();
		MockMvc mockMvc = standaloneSetup(homeController).build();
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}
	
}
