package com.example.apibasicauth.controller;

import br.com.henrick.HelloRepresentation;
import br.com.henrick.V1Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
public class HelloController implements V1Api {

    @Operation(summary = "getHello", description = "", security = {
            @SecurityRequirement(name = "basicAuth")    }, tags={ "hello-controller" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = HelloRepresentation.class))) })
    @RequestMapping(value = "/v1/hello",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<HelloRepresentation> hello() throws RestClientException {
        HelloRepresentation helloRepresentation = new HelloRepresentation();
        helloRepresentation.setMessage("Hello");
        return ResponseEntity.ok(helloRepresentation);
    }

}
