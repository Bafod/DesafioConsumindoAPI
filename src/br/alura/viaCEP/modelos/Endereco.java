package br.alura.viaCEP.modelos;

import br.alura.viaCEP.requisicao.RequisicaoViaCep;

public record Endereco(String cep, String logradouro, String bairro, String localidade, String uf) {

}