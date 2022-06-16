package com.cursosdousa;

// BDD (Bahavior Driven Development) é muito parecido com TDD por que escrevemos os testes antes, porém escrevemos
// todas as funcionalidades, formulando cenários de teste e dependências externa, modelando os comportamentos.
// - Maior Legibilidade dos testes, o que leva a melhor manutenibilidade.
// - Testes que qualquer humano consegue ler
// - Os testes são a própria documentação.
// Fluxo: Given -> When -> Then | Dado(Cenário) -> Quando -> Então | (2 números) -> (Soma) - > (Resultado)

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTests {

    @Mock
    List<String> lista1; //Instancia de Mock criada...
    @Mock
    List<String> lista2;
    @Mock
    List<String> lista3;
    @Mock
    List<String> lista4;
    @Mock
    List<String> lista5;

    @Test
    public void primeiroTesteMockito() {
        //List<String> lista = Mockito.mock(ArrayList.class);
        // Cria uma instância de ArrayList mockado sem @Mock e @RunWith(MockitoJUnitRunner.class).

        //============================================================================================TESTE 1
        Mockito.when(lista1.size()).thenReturn(1); //Mockei o .size() retornando valor 1 para lista1.
        Assertions.assertThat(lista1.size()).isEqualTo(1); //Verificquei se dentro do .size() tinha 1.

        lista1.add("Teste1");
        lista1.add("Teste2"); // Pode adicionar quantos elementos quiser fora do mock...
        lista1.add("Teste3"); // Como lista está mockado, o assertThat verifica somento o retorno 1...
        Assertions.assertThat(lista1.size()).isEqualTo(1); //Verificquei se dentro do .size() tinha 1.
        //============================================================================================

        //============================================================================================TESTE 2
        Mockito.when(lista2.size()).thenReturn(2); //Mockei o .size() retornando valor 2 para Lista 2.
        int size = 0;
        if (1 == 1) { // Se chamou ou não o .size. Neste Caso, sempre vai chamar...
            size = lista2.size();
        }
        Mockito.verify(lista2).size(); // Verifica se foi invocado o .size ao menos 1 vez, duas da erro... :/
        //============================================================================================

        //============================================================================================TESTE 3
        Mockito.when(lista3.size()).thenReturn(3); //Mockei o .size() retornando valor 3 para Lista 3.
        size = 0;
        if (1 == 1) { // Se chamou ou não o .size. Neste Caso, sempre vai chamar...
            size = lista3.size();
            size = lista3.size();
            size = lista3.size(); // Chamando 5 vezes o .size()
            size = lista3.size();
            size = lista3.size();
        }
        Mockito.verify(lista3, Mockito.times(5)).size();//Verifica se chamou o .size() 5 vezes.
        //============================================================================================

        //============================================================================================TESTE 4
        Mockito.when(lista4.size()).thenReturn(4); //Mockei o .size() retornando valor 4 para Lista 4.
        Mockito.verify(lista4, Mockito.never()).size();//Verifica se nunca foi chamado...
        //============================================================================================

        //============================================================================================TESTE 5
        lista5.size();
        lista5.add("");

        InOrder inOrder = Mockito.inOrder(lista5);
        inOrder.verify(lista5).size(); // Verifica se os comandos foram executados neste exata ordem...
        inOrder.verify(lista5).add(""); // size() / add()
        //============================================================================================
    }
}
