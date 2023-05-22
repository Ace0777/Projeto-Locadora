package br.com.locadora.model.locadora;

import br.com.locadora.model.locacao.Locacao;
import br.com.locadora.model.usuario.Cliente;
import br.com.locadora.model.usuario.Funcionario;

import java.util.ArrayList;

public class Locadora {

    private ArrayList<Funcionario> funcionarios;

    public Locadora(){

    }
    public Locadora(ArrayList<Locacao> locacaos, ArrayList<Funcionario> funcionarios, ArrayList<Cliente> clientes) {
        this.locacaos = locacaos;
        this.funcionarios = funcionarios;
    }
}
