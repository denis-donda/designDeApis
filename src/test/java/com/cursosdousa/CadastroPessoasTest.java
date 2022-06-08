package com.cursosdousa;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoasTest {

    @Test
    public void deveCriarOCadastroDePessoas(){
        //Arrange e Act
        CadastroPessoas cadastro = new CadastroPessoas();

        //assert
        Assertions.assertThat( cadastro.getPessoas() ).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoa(){
        //arrange
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Wilson");

        //act
        cadastroPessoas.adicionar(pessoa);

        //assert
        Assertions.assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test(expected = PessoaSemNotException.class)
    public void naoDeveAdicionarPessoaComNomeVazio(){
        //arrange
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //act
        cadastroPessoas.adicionar(pessoa);
    }
    @Test
    public void deveRemoverUmaPessoa(){
        //arrange
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Wilson");
        cadastroPessoas.adicionar(pessoa);

        //act
        cadastroPessoas.remover(pessoa);

        //assert
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }

    @Test(expected = CadastroVazioException.class)
    public void deveLancarErroAoTentarRemoverPessoaInexistente(){
        //arrange
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //act
        cadastroPessoas.remover(pessoa);
    }
}
