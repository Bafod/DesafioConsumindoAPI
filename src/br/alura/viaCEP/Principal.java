package br.alura.viaCEP;

import br.alura.viaCEP.modelos.Endereco;
import br.alura.viaCEP.modelos.GeradorJson;
import br.alura.viaCEP.requisicao.RequisicaoViaCep;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitor = new Scanner(System.in);
        String cep = "";
        List<Endereco> enderecos = new ArrayList<>();

        while (!cep.equalsIgnoreCase("sair")) {
            System.out.println("Digite um CEP valido para pesquisa:");
            cep = leitor.nextLine();
            if (cep.equalsIgnoreCase("sair")) {
                break;
            }
            try {

                RequisicaoViaCep requisicaoViaCep = new RequisicaoViaCep();

                Endereco novoEndereco = requisicaoViaCep.pesquisaCep(cep);

                enderecos.add(novoEndereco);

            }catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("CEP invalido");
            }
        }
        System.out.println(enderecos);
        GeradorJson gerador = new GeradorJson();
    }
}
