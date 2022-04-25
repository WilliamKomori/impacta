package fit.ImcApi.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fit.ImcApi.models.Person;

@RestController
@RequestMapping("/imc")
public class ImcController {

    @PostMapping("calculate")
    public Person calculateImc(@RequestBody Person person) {
        System.out.println(person.getWeight() / (person.getHeight() * person.getHeight()));
        person.setImc(person.getWeight() / (person.getHeight() * person.getHeight()));
        person.setImcDescription(calculateImcText(person.getImc()));
        
        return person;
    }

    private String calculateImcText (double imc) {
        String imcDescription = "";
        if (imc <= 18.5) {
            imcDescription = "Sua Classificação é de Magreza";
        } else if (imc >= 18.5 && imc <= 24.9) {
            imcDescription =  "Sua Classificação Está Dentro do Normal";
        } else if (imc >= 25.0 && imc <= 29.9) {
            imcDescription =  "Sua Classificação é de Sobrepeso I";
        } else if (imc >= 30.0 && imc <= 39.9) {
            imcDescription =  "Sua Classificação é Obesidade II";
        } else if (imc <= 40.0 ){
            imcDescription = "Sua Classificação é Obesidade Grave III";
        }

        return imcDescription;

    }
}
