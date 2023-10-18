package br.alura.viaCEP.requisicao;

import br.alura.viaCEP.modelos.Endereco;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequisicaoViaCep {
    public Endereco pesquisaCep(String cep) throws IOException, InterruptedException{

        String endereco = "https://viacep.com.br/ws/"+ cep +"/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

       try {
           HttpResponse<String> response = client.
                   send(request, HttpResponse.BodyHandlers.ofString());


           return new Gson().fromJson(response.body(), Endereco.class);
       }catch (IOException | InterruptedException | IllegalArgumentException | JsonSyntaxException e) {
           System.out.println("CEP invalido");
           throw new RuntimeException(e);
       }
    }

}
