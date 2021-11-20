package br.pucpr.cwbshop;

import br.pucpr.cwbshop.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class CwbshopApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductService productService;

    private String url_pattern = "http://localhost:8060";

//    @Test
//    void case1() throws Exception {
//
//        mockMvc.perform(post("/product")
//            .contentType("application/json")
//            .content(objectMapper.writeValueAsString()))
//            .andExpect(status().isOk());
//
//    }

    @Test
    void get_product_test() throws Exception {
        ResultActions get_product = mockMvc.perform(get(url_pattern + "/product")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON));
        System.out.println(get_product);
    }

}
