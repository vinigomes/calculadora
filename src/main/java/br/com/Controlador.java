package br.com;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@RestController
public class Controlador {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(name = "fatorial", method = RequestMethod.GET)
    public Integer fatorial(@RequestParam(name = "numero") @Valid @NotNull @NotBlank Integer numero)  {
        return Calculadora.fatorial(numero);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(name = "soma", method = RequestMethod.GET)
    public Integer soma(@RequestParam(name = "numero1") @Valid @NotNull @NotBlank Integer numero1, @RequestParam(name = "numero2") @Valid @NotNull @NotBlank Integer numero2)  {
        return Calculadora.soma(numero1, numero2);
    }

}