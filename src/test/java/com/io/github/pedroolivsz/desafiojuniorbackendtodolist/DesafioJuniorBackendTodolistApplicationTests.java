package com.io.github.pedroolivsz.desafiojuniorbackendtodolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class DesafioJuniorBackendTodolistApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testCreateTodoSucess() throws Exception {
		String json = """
				{
					"name": "Estudar",
					"description": "Estudar Spring",
					"realizado": false,
					"prioridade": 1
				}
				""";

		mockMvc.perform(post("/todos/create")
						.contentType("application/json")
						.content(json))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(1))
				.andExpect(jsonPath("$[0].name").value("Estudar"))
				.andExpect(jsonPath("$[0].description").value("Estudar Spring"))
				.andExpect(jsonPath("$[0].realizado").value(false))
				.andExpect(jsonPath("$[0].prioridade").value(1));
	}

	@Test
	void testCreateTodoFailure() throws Exception {
		String json = """
				{
					"name": "",
					"description": "",
					"realizado": false,
					"prioridade": 0
				}
				""";

		mockMvc.perform(post("/todos/create")
				.contentType("application/json")
				.content(json))
				.andExpect(status().isBadRequest());
	}
}
