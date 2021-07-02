package com.example.demo.service;

import com.example.demo.model.Root;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NbpService {
    private RestTemplate restTemplate;

    public NbpService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Double getAvgRate(String currency, int days){
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/last/" + days;
        Root root = restTemplate.getForObject(url, Root.class);
        return root.getRates()
                .stream()
                .mapToDouble(x-> x.mid)
                .average().orElse(0.0);
    }
}
