package com.seedapp.springrest.webmvc.rest;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.seedapp.springrest.service.MessageService;

public class WelcomeMessageRestControllerTest extends AbstractIntegrationTest {

	@Inject
	MessageService messageService;
	
	
	@PostConstruct
	public void setup() {
		MockitoAnnotations.initMocks(this);
		WelcomeMessageRestController controller = new WelcomeMessageRestController();
		ReflectionTestUtils.setField(controller, "messageService", messageService);
		super.mock = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void getMessage() throws Exception {
		mock.perform(get("/rest-api/welcome").param("name", "John Doe"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(content().string(containsString("John Doe")));
	}

}
