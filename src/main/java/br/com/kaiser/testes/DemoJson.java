package br.com.kaiser.testes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DemoJson {

  public static void main(String[] args) {

    final URL arquivo = DemoJson.class.getResource("/teste.json");

    System.out.println(arquivo);
    ObjectMapper mapper = new ObjectMapper();
    try(final BufferedReader reader = Files.newBufferedReader(Paths.get(arquivo.toURI()))){
      final JsonNode json = mapper.readTree(reader);
      System.out.println(json);//imprime o arquivo inteiro

      System.out.println(json.getNodeType());//como tem uma lista ele mostra um array
      //entao podemos fazer um for
      for(JsonNode carro : json){
        System.out.println(carro);//aqui ele ja vai imprimir cada um dos json
        //e podemos pegar cada uma das propriedades pelo nome
        System.out.println(carro.get("marcaModelo"));
        System.out.println(carro.get("ano"));
        System.out.println(carro.get("km"));
        System.out.println(carro.get("cor"));
        System.out.println(carro.get("cambio"));
        System.out.println(carro.get("valor"));

      }

    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }

  }

}
