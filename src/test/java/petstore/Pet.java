//1 - pacote
package petstore;

// 2 - Bibliotecas

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

// 3 - Classe
public class Pet {

    // 3.1 - Atributos

    String uri = "https://petstore.swagger.io/v2/pet";  // endereço entetidade Pet

    // 3.2 - Metodos e Funções
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // Incluir - creat - post
    @Test // Indentifica o metodo ou funcção como um teste para testNG
    public void incluirPet() throws IOException {
    String jsonBody = lerJson("DadosPet/pet1.json");

     // Sintaxe Gherkin
    // Dado - Quando - Então
   //  Given - When - Then

        given()//Dado
                .contentType("application/json") // comum em API REST - API antiga usava-se 'text/xml'
                .log().all()
                .body(jsonBody)

        .when() //Quanto
                .post(uri)
        .then() // Então
                .log().all()
                .statusCode(200)
        ;
    }
}

