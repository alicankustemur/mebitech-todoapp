package com.mebitech.todoapp.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mebitech.todoapp.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MeetingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void index() throws Exception {
		
		this.mockMvc.perform(get("/meeting"))
			.andExpect(status().isOk())
			.andExpect(view().name("meeting"));
	}
	
	@Test
	public void testEmployeeList() throws Exception{
		this.mockMvc.perform(get("/meeting/meetings")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}