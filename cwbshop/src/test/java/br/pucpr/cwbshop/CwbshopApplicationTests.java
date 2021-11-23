package br.pucpr.cwbshop;

import br.pucpr.cwbshop.domain.entity.*;
import br.pucpr.cwbshop.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CwbshopApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AttributeRepository attributeRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StateRepository stateRepository;

    private static Address address;
    private static Attribute attribute;
    private static City city;
    private static Country country;
    private static Date mydate;
    private static List<Attribute> attributes;
    private static Product product;
    private static UserLogin userLogin;
    private static User user;
    private static State state;
    private static String bearerToken;

    @BeforeAll
    static void initAll() {
        bearerToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwcm9nd2ViIiwiZXhwIjoxNjM4NDAyNzQ2fQ.jYb_phUzze_V4ILzEdjt4Eusz9Ovaz9PlO9gqppxeOkZzX32mkpjZIUvUZXEeq7UvCC0kkpAV9Z3rVbnue8fDA";

        userLogin = new UserLogin();
        userLogin.setUsername("progweb");
        userLogin.setPassword("progweb");

        mydate = new Date();
        user = new User();
        user.setFirstName("Gnomo");
        user.setLastName("Teste");
        user.setDtCreation(mydate);
        user.setDtUpdate(mydate);
        user.setLogin("progweb");
        user.setPassword("progweb");

        attribute = new Attribute();
        attribute.setId("teste");
        attribute.setValue_name("Teste");

        attributes = new ArrayList<Attribute>();
        attributes.add(attribute);

        city = new City();
        city.setId("CWB");
        city.setName("Curitiba");

        country = new Country();
        country.setId("BR");
        country.setName("Brasil");

        state = new State();
        state.setId("PR");
        state.setName("Parná");

        address = new Address();
        address.setCity(city);
        address.setCountry(country);
        address.setState(state);

        product = new Product();
        product.setId("ideteste1234");
        product.setSite_id("TST");
        product.setTitle("Teste");
        product.setId_integracao(123456);
        product.setSubtitle("testinho");
        product.setSeller_id("123654789");
        product.setPrice(599.00);
        product.setBase_price(599.00);
        product.setOriginal_price(899.00);
        product.setCurrency_id("USD");
        product.setInitial_quantity(10);
        product.setAvailable_quantity(10);
        product.setStart_time("2021-11-11T11:11:11.000Z");
        product.setStop_time("2021-11-11T11:11:11.000Z");
        product.setCondition("used");
        product.setPermalink("URL/DE/TESTE");
        product.setSeller_address(address);
        product.setSeller_contact("41999888777");
        product.setAttributes(attributes);

    }

    private String getBearerToken() throws Exception {
        ResultActions result =  mockMvc.perform(post("/login")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(userLogin)))
            .andExpect(status().isOk());

        String resultString = result.andReturn().getResponse().getContentAsString();
        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }

    @Test
    void user_login_test() throws Exception {
        mockMvc.perform(post("/login")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userLogin)))
                .andExpect(status().isOk());
    }

    @Test
    void post_user_denied_test() throws Exception {
        mockMvc.perform(post("/api/user")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void post_user_test() throws Exception {
        mockMvc.perform(post("/api/user")
                .header("Authorization", "Bearer " + bearerToken)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    void get_user_test() throws Exception {
       mockMvc.perform(get("/api/user")
                .header("Authorization", "Bearer " + bearerToken)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void delete_user_test() throws Exception {

        User lastUser = userRepository.findFirstByOrderById();

        mockMvc.perform(delete("/api/user/{id}", lastUser.getId())
                .header("Authorization", "Bearer " + bearerToken)
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk());
    }

    @Test
    void get_attribute_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/attribute")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void get_attribute_by_id_test() throws Exception {
        Attribute lastAttribute = attributeRepository.findFirstByOrderByAttributeId();

        mockMvc.perform(MockMvcRequestBuilders
                .get("/attribute/{id}", lastAttribute.getAttributeId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void post_attribute_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/attribute")
                .content(objectMapper.writeValueAsString(attribute))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void delete_attribute_by_id_test() throws Exception {
        Attribute lastAttribute = attributeRepository.findFirstByOrderByAttributeId();

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/attribute/{id}", lastAttribute.getAttributeId()))
                .andExpect(status().isOk());
    }

    @Test
    void post_city_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/city")
                .content(objectMapper.writeValueAsString(city))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
    }

    @Test
    void get_city_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/city")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void get_city_by_id_test() throws Exception {
        City lastCity = cityRepository.findFirstByOrderByCityId();

        mockMvc.perform(MockMvcRequestBuilders
                .get("/city/{id}", lastCity.getCityId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void delete_city_by_id_test() throws Exception {
        City lastCity = cityRepository.findFirstByOrderByCityId();

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/city/{id}", lastCity.getCityId()))
                .andExpect(status().isOk());
    }

    @Test
    void post_country_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/country")
                .content(objectMapper.writeValueAsString(country))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void get_country_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/country")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void get_country_by_id_test() throws Exception {
        Country lastCountry = countryRepository.findFirstByOrderByCountryId();

        mockMvc.perform(MockMvcRequestBuilders
                .get("/country/{id}", lastCountry.getCountryId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void delete_country_by_id_test() throws Exception {
        Country lastCountry = countryRepository.findFirstByOrderByCountryId();

        mockMvc.perform(delete("/country/{id}", lastCountry.getCountryId())
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void post_state_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/state")
                .content(objectMapper.writeValueAsString(state))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void get_state_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/state")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void get_state_by_id_test() throws Exception {
        State lastState = stateRepository.findFirstByOrderByStateId();

        mockMvc.perform(MockMvcRequestBuilders
                .get("/state/{id}", lastState.getStateId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void delete_state_by_id_test() throws Exception {
        State lastState = stateRepository.findFirstByOrderByStateId();

        mockMvc.perform(delete("/state/{id}", lastState.getStateId())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(state)))
                .andExpect(status().isOk());
    }

    @Test
    void post_address_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/address")
                .content(objectMapper.writeValueAsString(address))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void get_address_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/address")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void get_address_by_id_test() throws Exception {
        Address lastAddress = addressRepository.findFirstByOrderByAddressId();

        mockMvc.perform(MockMvcRequestBuilders
                .get("/address/{id}", lastAddress.getAddressId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void delete_address_by_id_test() throws Exception {
        Address lastAddress = addressRepository.findFirstByOrderByAddressId();

        mockMvc.perform(delete("/address/{id}", lastAddress.getAddressId())
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void post_product_denied_test() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/product")
                .content(objectMapper.writeValueAsString(product))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void post_product_test() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/product")
                .header("Authorization", "Bearer " + bearerToken)
                .content(objectMapper.writeValueAsString(product))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void get_product_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/product")
                .header("Authorization", "Bearer " + bearerToken)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void get_product_by_id_test() throws Exception {
        Product lastProduct = productRepository.findFirstByOrderByProductId();

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/product/{id}", lastProduct.getProductId())
                .header("Authorization", "Bearer " + bearerToken)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void delete_product_by_id_test() throws Exception {
        Product lastProduct = productRepository.findFirstByOrderByProductId();

        mockMvc.perform(delete("/api/product/{id}", lastProduct.getProductId())
                .header("Authorization", "Bearer " + bearerToken))
                .andExpect(status().isOk());
    }


}
