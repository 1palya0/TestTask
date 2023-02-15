package com.example.test.service;

import com.example.test.exception.ApiException;
import com.example.test.model.Fibonacci;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@Service
@Slf4j
public class FibonacciService {


    public Fibonacci calculate(Fibonacci fibonacci) {
        if (!checkFibonacci(fibonacci)) {
            throw new ApiException("Your row is bad, you don't study a lot!");
        }
        reverse(fibonacci);
        fileWrite(fibonacci);
        return fibonacci;
    }

    public boolean checkFibonacci(Fibonacci fibonacci) {
        int first = 0;
        int second = 0;
        for (int i = 0; i < fibonacci.getFibonacci().size() - 2; i++) {
            first = fibonacci.getFibonacci().get(i);
            second = fibonacci.getFibonacci().get(i + 1);
            if (first + second != fibonacci.getFibonacci().get(i + 2)) {
                return false;
            }
        }
        return true;
    }

    public Fibonacci reverse(Fibonacci fibonacci) {
        ArrayList<Integer> fibonacci1 = fibonacci.getFibonacci();
        for (int i = fibonacci1.size() - 1, j = 0; i > j; i--, j++) {
            int tmp = fibonacci1.get(i);
            fibonacci1.set(i, fibonacci1.get(j));
            fibonacci1.set(j, tmp);
        }

        return fibonacci;
    }

    public void fileWrite(Fibonacci fibonacci) {
        try (FileWriter writer = new FileWriter("test1.txt")) {
            log.info("File created/opened");
            writer.write(fibonacci.getFibonacci().toString());
            log.info("Successful writing");
        } catch (IOException e) {
            log.warn("Unsuccessful writing");
            log.error(e.getClass().getName()+"| Message: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
