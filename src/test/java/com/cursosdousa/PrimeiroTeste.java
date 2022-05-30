package com.cursosdousa;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroTeste {

    @Test
    public void deveSomar2Numeros(){
        //arrange
        Calculadora calculadora = new Calculadora();
        int numero1 = 10, numero2 = 5;

        //act
        int resultado = calculadora.somar(numero1, numero2);

        //asserT
        Assert.assertEquals(15, resultado); //Este teste é do Junit
        Assertions.assertThat(resultado).isBetween(14, 16); //Daqui pra baixo é da biblioteca mais completa Assertions
        Assertions.assertThat(resultado).isGreaterThan(10);
        Assertions.assertThat(resultado).isEqualTo(15);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveSomarNumerosNegativos(){
        //arrange
        Calculadora calculadora = new Calculadora();
        int num1 = -10, num2 = 5;

        //act
        calculadora.somar(num1, num2);
    }

    @Test
    public void deveSubtrair2Numeros(){
        //arrange
        Calculadora calculadora = new Calculadora();
        int numero1 = 10, numero2 = 5;

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
        Calculadora calculadora = new Calculadora();
        int num1 = -10, num2 = 5;

        //act
        calculadora.subtrair(num1, num2);
    }

    @Test
    public void deveMultiplicar2Numeros(){
        //arrange
        Calculadora calculadora = new Calculadora();
        int numero1 = 10, numero2 = 5;

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
        Calculadora calculadora = new Calculadora();
        int num1 = -10, num2 = 5;

        //act
        calculadora.multiplicar(num1, num2);
    }

    @Test
    public void deveDividir2Numeros(){
        //arrange
        Calculadora calculadora = new Calculadora();
        int numero1 = 10, numero2 = 5;

        //act
        int resultado = calculadora.dividir(numero1, numero2);

        //assert
        Assert.assertEquals(2, resultado); //Este teste é do Junit
        Assertions.assertThat(resultado).isBetween(1, 3); //Daqui pra baixo é da biblioteca mais completa Assertions
        Assertions.assertThat(resultado).isGreaterThan(0);//acima de 0
        Assertions.assertThat(resultado).isEqualTo(2);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveDividirNumerosNegativos(){
        //arrange
        Calculadora calculadora = new Calculadora();
        int num1 = -10, num2 = 5;

        //act
        calculadora.dividir(num1, num2);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveDividirPorZero(){
        //arrange
        Calculadora calculadora = new Calculadora();
        int num1 = 0, num2 = 5;

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
        if(num < 0 || num2 < 0){
            throw new RuntimeException("Não é permitido dividir numeros negativos.");
        }
        if(num == 0 || num2 == 0){
            throw new RuntimeException("Não é permitido realizar Divisão por Zero.");
        }
        return num / num2;
    }
}
