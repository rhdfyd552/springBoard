package kr.or.ddit.login.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.annotation.Resource;

import kr.or.ddit.spring.test.TestInit;
import kr.or.ddit.spring.test.WebTestInit;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@WebAppConfiguration 
public class LoginControllerTest extends WebTestInit{
	@Resource
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	@Test
	public void test() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(get("")).andReturn();
		
		/***When***/

		/***Then***/

	}

}
