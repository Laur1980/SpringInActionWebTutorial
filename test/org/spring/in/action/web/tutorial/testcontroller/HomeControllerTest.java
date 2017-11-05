package org.spring.in.action.web.tutorial.testcontroller;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.spring.in.action.web.tutorial.controller.HomeController;
import org.spring.in.action.web.tutorial.controller.SpittleController;
import org.spring.in.action.web.tutorial.dao.SpittleRepository;
import org.spring.in.action.web.tutorial.entity.Spittle;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

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
		mockMvc.perform(get("/"))
			   .andExpect(view().name("home"));
	}
	
	@Test
	public void testShowRecentSpittles() throws Exception{
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository mockRepository =
		mock(SpittleRepository.class);
		when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
		.thenReturn(expectedSpittles);
		SpittleController controller =new SpittleController(mockRepository);	
		MockMvc mockMvc = standaloneSetup(controller)
		.setSingleView(
		new InternalResourceView("/WEB-INF/views/spittles.jsp"))
		.build();
		mockMvc.perform(get("/spittles"))
		.andExpect(view().name("spittles"))
		.andExpect(model().attributeExists("spittleList"))
		.andExpect(model().attribute("spittleList",
		hasItems(expectedSpittles.toArray())));
	}
	

	private List<Spittle> createSpittleList(int count) {
			List<Spittle> spittles = new ArrayList<Spittle>();
			for (int i=0; i < count; i++) {
				spittles.add(new Spittle("Spittle " + i, new Date()));
			}
			return spittles;
		}
	
}
