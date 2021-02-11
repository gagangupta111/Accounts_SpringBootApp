import com.omnirio.AccountsApplication;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = AccountsApplication.class)
@AutoConfigureMockMvc
public class AccountTestMockMVC {

	@Autowired
	private MockMvc mvc;

	// Create User
	@Test
	public void createAccount1() throws Exception {

		mvc.perform(
			MockMvcRequestBuilders.post("/omnirio/account")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{}")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.Account.accountType").value("DEFAULT"))
			.andExpect(jsonPath("$.Account.branch").value("DEFAULT"))
			.andExpect(jsonPath("$.Account.flagAge").value("DEFAULT"));

	}

	// get all users
	@Test
	public void getAccounts() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/omnirio/account").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.Account").isArray());
	}

	// get all users
	@Test
	public void updateAccountError() throws Exception {

		mvc.perform(
				MockMvcRequestBuilders.put("/omnirio/account")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\n" +
								"    \"accountID\": \"random1234\",\n" +
								"    \"accountType\":\"D\",\n" +
								"    \"branch\":\"D\"\n" +
								"}")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().string("{\"code\":405,\"details\":\"\",\"message\":\"INVALID_ACCOUNT_ID\"}"));




	}

	// get all users
	@Test
	public void updateAccountSuccess() throws Exception {

		MvcResult result = mvc.perform(
				MockMvcRequestBuilders.post("/omnirio/account")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{}")
						.accept(MediaType.APPLICATION_JSON)).andReturn();
		JSONObject object = new JSONObject(result.getResponse().getContentAsString());
		String accountID = object.getJSONObject("Account").getString("accountID");

		mvc.perform(
				MockMvcRequestBuilders.put("/omnirio/account")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\n" +
								"    \"accountID\": \"" + accountID + "\",\n" +
								"    \"accountType\":\"D\",\n" +
								"    \"branch\":\"D\"\n" +
								"}")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());




	}

}
