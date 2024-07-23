package com.backendtest.ProjectForm.Controller;

import com.backendtest.ProjectForm.Service.CryptoService;
import com.backendtest.ProjectForm.Entity.CryptoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/crypto/{code}")
    public Optional<CryptoEntity> getCryptoData(@PathVariable("code") String code) {
    		
    	return cryptoService.fetchCryptoData(code);
    	
         
         
    }
}
