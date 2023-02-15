package com.example.test.controller;


import com.example.test.model.Fibonacci;
import com.example.test.service.FibonacciService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class FibonacciController {
    private final FibonacciService fibonacciService;
    @GetMapping("/Fibonacci")
    public ResponseEntity<Fibonacci> process(@RequestBody Fibonacci fibonacci){
        log.info("getRequest sent");
        return ResponseEntity.accepted().body(fibonacciService.calculate(fibonacci));
    }
}
