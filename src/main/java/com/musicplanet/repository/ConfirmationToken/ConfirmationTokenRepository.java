package com.musicplanet.repository.ConfirmationToken;

import com.musicplanet.dalinterfaces.IConfirmationTokenDal;
import com.musicplanet.entities.Authentication.ConfirmationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class ConfirmationTokenRepository implements IConfirmationTokenDal {

    @Autowired
    IConfirmationTokenRepository repo;

    @Override
    public Optional<ConfirmationToken> findByToken(String token) {
        return repo.findByToken(token);
    }

    @Override
    public int updateConfirmedAt(String token, LocalDateTime confirmedAt) {
        return repo.updateConfirmedAt(token, confirmedAt);
    }

    @Override
    public void save(ConfirmationToken token) {
        repo.save(token);
    }
}
