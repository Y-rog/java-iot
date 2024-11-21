package com.studi.iot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studi.iot.pojo.Temperature;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class TemperatureTests {

    // SmoketTest : vérification que les controllers (ws) fonctionner
    // Test unitaire (= mock pour une API) : test d'une fonctionnalité
    // Mock : simuler une requete HTTP pour créer des éléments, les suprrimer etc.

    private MockMvc mockMvc;

    private Temperature temperature = new Temperature(LocalDateTime.now(),888.8f);

    private ObjectMapper objectMapper;

    @Test
    public void createTemperature() throws Exception {


        //Conversion de l'objet Temperature en JSON
        String requestJson = objectMapper.writeValueAsString(this.temperature);

        //Envoi du JSOn à l'API pour une création
        this.mockMvc.perform(
                post("/temperature")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllTemperature() throws Exception {
        MvcResult mvcResult = (MvcResult) mockMvc.perform(
                get("/temperature")
        );
        Temperature newTemperature = objectMapper
                .readValue(mvcResult.getResponse().getContentAsString(),Temperature.class);
        this.temperature.setId(newTemperature.getId());
    }

    @Test
    public void getTemperature() throws Exception {
        MvcResult mvcResult = (MvcResult) mockMvc.perform(
                get("/temperature/" + this.temperature.getId())
        );

        objectMapper.readValue(mvcResult.getResponse().getContentAsString(),Temperature.class);
    }

    @Test
    public void updateTemperature() {

    }

    @Test
    public void deleteTemperature() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/temperature/" + this.temperature.getId())
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

}
