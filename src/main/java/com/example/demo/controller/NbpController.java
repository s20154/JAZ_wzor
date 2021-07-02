package com.example.demo.controller;


import com.example.demo.service.NbpService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nbp")
public class NbpController {
    private NbpService nbpService;

    public NbpController(NbpService nbpService){
        this.nbpService = nbpService;
    }

    @GetMapping("/")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok("Welcome");
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Currency not found"),
            @ApiResponse(code = 504, message = "Server is on fire :(")}
    )
    @ApiOperation(value = "Get average price of currency form past days", notes = "Provide your cuurnecy and days")
    @GetMapping("/{currency}")
    public ResponseEntity<Double> getAvgLastDays(
            @ApiParam(value = "Currency you want to retrieve", example = "eur")
            @PathVariable String currency,

            @ApiParam(value = "Amount of days", example = "10")
            @RequestParam("days") int days){
        return ResponseEntity.ok(nbpService.getAvgRate(currency,days));
    }
}
