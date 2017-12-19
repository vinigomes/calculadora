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

}