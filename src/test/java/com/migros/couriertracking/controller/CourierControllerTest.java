package com.migros.couriertracking.controller;

import com.migros.couriertracking.service.CourierService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class CourierControllerTest {

    @InjectMocks
    private CourierController courierController;

    @Mock
    private CourierService courierService;

    private MockMvc mockMvc;


    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(courierController).build();
    }

    @Test
    public void shouldCreate() {
       /* //GIVEN
        CourierDTO courierDTO = new CourierDTO();
        courierDTO.setName("Deniz");
        courierDTO.setSurname("Celenk");*/

        // when(courierService.create(courierDTO)).thenReturn(courierDTO);
        //WHEN
        /*mockMvc.perform(mockMvc.perform(post("courier")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("MapperYazılacak")
                ).andExpect(status().isOk()).andDo()
        );


        //THAN
*/

    }
}
