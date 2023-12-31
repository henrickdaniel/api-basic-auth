package com.example.apibasicauth.controller;

import br.com.henrick.HelloRepresentation;
import br.com.henrick.V1Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
public class HelloController implements V1Api {


    @Override
    @GetMapping("/v1/hello")
    public ResponseEntity<HelloRepresentation> hello() throws RestClientException {
        HelloRepresentation helloRepresentation = new HelloRepresentation();
        helloRepresentation.setMessage("Hello");
        return ResponseEntity.ok(helloRepresentation);
    }

}
