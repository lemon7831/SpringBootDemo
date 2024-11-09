package com.coindesk.service;

import com.coindesk.dao.CoinDao;
import com.coindesk.entity.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class CoinService implements CoinServiceImpl {

    @Autowired
    private CoinDao repo;

    @Override
    public List<Coin> findAll() {
        return repo.findAll();
    }

    @Override
    public Coin findByCode(String code) {
        return repo.findByCode(code);
    }

    @Override
    public Coin create(Coin coin) {
        Coin saveEntity = Coin.builder()
                .code(coin.getCode())
                .name(coin.getName())
                .symbol(coin.getSymbol())
                .rate(coin.getRate())
                .description(coin.getDescription())
                .rateFloat(coin.getRateFloat())
                .updateTime(new Date())
                .build();

        return repo.saveAndFlush(saveEntity);
    }

    @Override
    public Coin update(String code, Coin coin) {
        Coin saveEntity = repo.findByCode(code);

        saveEntity.setName(coin.getName());
        saveEntity.setSymbol(coin.getSymbol());
        saveEntity.setRate(coin.getRate());
        saveEntity.setDescription(coin.getDescription());
        saveEntity.setRateFloat(coin.getRateFloat());
        saveEntity.setUpdateTime(new Date());

        return repo.saveAndFlush(saveEntity);
    }

    @Override
    @Transactional
    public void deleteByCode(String code) {
        repo.deleteByCode(code);
    }

}
