package com.coindesk.service;

import com.coindesk.entity.Coin;

import java.util.List;

public interface CoinServiceImpl {
    List<Coin> findAll();
    Coin findByCode(String code);
    Coin create (Coin coin);
    Coin update(String code,Coin coin);
    void deleteByCode(String code);
}
