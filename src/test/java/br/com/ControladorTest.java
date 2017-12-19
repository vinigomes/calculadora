package br.com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Controlador controlador;

    @Test
    public void carregaContexto() {
        assertThat(controlador).isNotNull();
    }

    @Test
    public void deveRetornarOFatorialDe0() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fatorial?numero=0"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void deveRetornarOFatorialDe4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fatorial?numero=4"))
                .andExpect(status().isOk())
                .andExpect(content().string("24"));
    }

    @Test
    public void deveRetornarBadRequestQuandoNaoInformadoValor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fatorial?numero=x"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deveRetornarBadRequestQuandoInformadoUmValorInvalido() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fatorial?numero=x"))
                .andExpect(status().isBadRequest());
    }

}