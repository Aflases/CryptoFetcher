package com.backendtest.ProjectForm.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.backendtest.ProjectForm.Entity.CryptoEntity;
import com.backendtest.ProjectForm.Entity.CryptoRequest;
import com.backendtest.ProjectForm.Entity.History;
import com.backendtest.ProjectForm.Repo.CryptoRepo;
import com.backendtest.ProjectForm.Repo.HistoryRepo;



@Service
public class CryptoService {
	
	@Autowired
	private CryptoRepo cryptoRepo;
	
	private final RestTemplate restTemplate;

	
    private static final int MAX_HISTORY_SIZE = 20;

	

	    
	    @Value("${api.key}")
	    private String apiKeyValue;
	
	public CryptoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public Optional<CryptoEntity> fetchCryptoData(String code)
	{
			return cryptoRepo.findByCode(code);
	}

@Scheduled(fixedRate = 10000)
	public void fetchApiDataMeta() {
	
	String apiUrl = "https://api.livecoinwatch.com/";

    String url = apiUrl + "coins/map";
    
    
    
    List<String> cryptoCode = Arrays.asList("ETH", "BNB", "BTC", "USDT", "SOL");
    
    HttpHeaders headers = new HttpHeaders();
    headers.set("x-api-key", apiKeyValue);
    headers.setContentType(MediaType.APPLICATION_JSON);
    CryptoRequest requestBody = new CryptoRequest();
    
    
       requestBody.setCurrency("USD");
       requestBody.setCodes(cryptoCode);
       requestBody.setSort("rank");
       requestBody.setOrder("ascending");
       requestBody.setOffset(0);
       requestBody.setLimit(0);
       requestBody.setMeta(true);	     

      	     

    HttpEntity<CryptoRequest> entity = new HttpEntity<>(requestBody, headers);
    
    try {
   	 
        ResponseEntity<List<CryptoEntity>> response =  restTemplate.exchange(
                   url,
                   HttpMethod.POST,
                   entity,
                   new ParameterizedTypeReference<List<CryptoEntity>>() {}
               );
        List<CryptoEntity> cryptoEntities = response.getBody();
        
         
        if (cryptoEntities != null) {
            for (CryptoEntity ce : cryptoEntities) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedNow = now.format(formatter);

                Optional<CryptoEntity> optionalCrypto = cryptoRepo.findByCode(ce.getCode());

                if (optionalCrypto.isPresent()) {
                    CryptoEntity existingCrypto = optionalCrypto.get();
                    cryptoRepo.deleteByCode(ce.getCode());

                    List<History> historyList = existingCrypto.getHistory();

                    if (historyList == null) {
                        historyList = new ArrayList<>();
                    }

                    // Add new history entry
                    History newHistory = new History(ce.getCode(), formattedNow, ce.getRate(), ce.getVolume(), ce.getCap());
                    historyList.add(newHistory);

                    // Maintain the history size limit
                    if (historyList.size() > MAX_HISTORY_SIZE) {
                        // Remove the oldest entries
                        historyList = historyList.subList(historyList.size() - MAX_HISTORY_SIZE, historyList.size());
                    }
                    
                    existingCrypto.setHistory(historyList);
                    cryptoRepo.save(existingCrypto);

                } else {
                    // Add new entry
                    ce.setHistory(new ArrayList<>(Collections.singletonList(
                        new History(ce.getCode(), formattedNow, ce.getRate(), ce.getVolume(), ce.getCap())
                    )));
                    cryptoRepo.save(ce);
                }
    	}
        }
    }
    catch (HttpClientErrorException e) {
        // Handle HTTP error
        System.out.println("Error: " + e.getMessage());
    }
    
    return;
}

}
