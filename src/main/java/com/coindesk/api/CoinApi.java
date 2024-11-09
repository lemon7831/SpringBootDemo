package com.coindesk.api;

import com.coindesk.entity.Coin;
import com.coindesk.service.CoinServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoinApi {

    @Autowired
    private CoinServiceImpl service;

    @GetMapping("/coins")
    public ResponseEntity<List<Coin>> findAll() {
        List<Coin> list = service.findAll();
        return new ResponseEntity<List<Coin>>(list, HttpStatus.OK);
    }

    @GetMapping("/coin/{code}")
    public ResponseEntity<Coin> findByCode(@PathVariable String code) {
        Coin coin = service.findByCode(code);
        return ResponseEntity.status(HttpStatus.OK).body(coin);
    }

    @PostMapping("/coin")
    public ResponseEntity<Coin> create(@RequestBody Coin coin){
        Coin newCoin = service.create(coin);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCoin);
    }

    @PutMapping("/coin/{code}")
    public ResponseEntity<Coin> update(@PathVariable String code,
            @RequestBody Coin coin) {
        Coin newCoin =service.update(code,coin);
        return ResponseEntity.status(HttpStatus.OK).body(newCoin);
    }

    @DeleteMapping("/coin/{code}")
    public ResponseEntity<?> delete(@PathVariable String code) {
        service.deleteByCode(code);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}