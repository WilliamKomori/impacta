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
            imcDescription = "Magreza, quando o resultado é menor que 18,5 kg/m2";
        } else if (imc >= 18.5 && imc <= 24.9) {
            imcDescription =  "Sua classificação está dentro do Normal, quando o resultado está entre 18,5 e 24,9 kg/m2";
        } else if (imc >= 25.0 && imc <= 29.9) {
            imcDescription =  "Sua classificação é de Sobrepeso I, quando o resultado está entre 24,9 e 30 kg/m2";
        } else if (imc >= 30.0 && imc <= 34.9) {
            imcDescription =  "Sua classificação é Obesidade I, quando o resultado está entre 30 e 34.9 kg/m2";
        }else if (imc >= 35 && imc <= 39.9) {
            imcDescription =  "Sua classificação é Obesidade II, quando o resultado está entre 35 e 39.9 kg/m2";
        } else if (imc <= 40.0 ){
            imcDescription = "Sua classificação é Obesidade Grave III, quando o resultado é maior que 40.0 kg/m2";
        }

        return imcDescription;

    }
}
