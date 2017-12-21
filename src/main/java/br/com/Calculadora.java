package br.com;

public class Calculadora {

    public static Integer fatorial (Integer numero) {
        if (numero <= 1 ) {
            return 1;
        }
        return numero * fatorial(numero - 1);
    }

    public static Integer soma (Integer numero1, Integer numero2) {
        return numero1 + numero2;
    }

}
