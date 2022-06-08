package com.cursosdousa;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrimeiroTeste {

    Calculadora calculadora;
    int numero1 = 10, numero2 = 5;

    @Before
    public void setUp(){
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomar2Numeros(){
        //arrange

        //act
        int resultado = calculadora.somar(numero1, numero2);

        //asserT
        Assert.assertEquals(15, resultado); //Este teste é do Junit
        assertThat(resultado).isBetween(14, 16); //Daqui pra baixo é da biblioteca mais completa Assertions
        Assertions.assertThat(resultado).isGreaterThan(10);
        Assertions.assertThat(resultado).isEqualTo(15);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveSomarNumerosNegativos(){
        //arrange
        int num1 = 10, num2 = -5;

        //act
        calculadora.somar(num1, num2);
    }

    @Test
    public void deveSubtrair2Numeros(){
        //arrange

        //act
        int resultado = calculadora.subtrair(numero1, numero2);

        //assert
        Assert.assertEquals(5, resultado); //Este teste é do Junit
        Assertions.assertThat(resultado).isBetween(4, 10); //Daqui pra baixo é da biblioteca mais completa Assertions
        Assertions.assertThat(resultado).isGreaterThan(1);
        Assertions.assertThat(resultado).isEqualTo(5);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveSubtrairNumerosNegativos(){
        //arrange
        int num1 = 10, num2 = -5;

        //act
        calculadora.subtrair(num1, num2);
    }

    @Test
    public void deveMultiplicar2Numeros(){
        //arrange

        //act
        int resultado = calculadora.multiplicar(numero1, numero2);

        //assert
        Assert.assertEquals(50, resultado); //Este teste é do Junit
        Assertions.assertThat(resultado).isBetween(49, 51); //Daqui pra baixo é da biblioteca mais completa Assertions
        Assertions.assertThat(resultado).isGreaterThan(10);//acima de 10
        Assertions.assertThat(resultado).isEqualTo(50);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveMultiplicarNumerosNegativos(){
        //arrange
        int num1 = 10, num2 = -5;

        //act
        calculadora.multiplicar(num1, num2);
    }

    @Test
    public void deveDividir2Numeros(){
        //arrange

        //act
        float resultado = calculadora.dividir(numero1, numero2);

        //assert
        Assert.assertEquals(2F, resultado, 0); //Este teste é do Junit
        Assertions.assertThat(resultado).isBetween(1F, 3F); //Daqui pra baixo é da biblioteca mais completa Assertions
        Assertions.assertThat(resultado).isGreaterThan(0);//acima de 0
        Assertions.assertThat(resultado).isEqualTo(2);
    }

    @Test(expected = ArithmeticException.class)
    public void naoDeveDividirPorZero(){
        //arrange
        int num1 = 10, num2 = 0;

        //Act
        calculadora.dividir(num1, num2);
    }
}

class Calculadora {

    int somar(int num, int num2){
        if(num < 0 || num2 < 0){
            throw new RuntimeException("Não é permitido somar numeros negativos.");
        }
        return num + num2;
    }

    int subtrair(int num, int num2){
        if(num < 0 || num2 < 0){
            throw new RuntimeException("Não é permitido subtrair numeros negativos.");
        }
        return num - num2;
    }

    int multiplicar(int num, int num2){
        if(num < 0 || num2 < 0){
            throw new RuntimeException("Não é permitido multiplicar numeros negativos.");
        }
        return num * num2;
    }

    int dividir(int num, int num2){

        return num / num2;
    }
}