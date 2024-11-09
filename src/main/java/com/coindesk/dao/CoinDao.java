package com.coindesk.dao;

import com.coindesk.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinDao extends JpaRepository<Coin, Long> {
    Coin findByCode(String code);
    void deleteByCode(String code);

}