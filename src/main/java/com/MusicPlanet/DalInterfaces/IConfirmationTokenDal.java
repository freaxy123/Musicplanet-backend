package com.MusicPlanet.DalInterfaces;

import com.MusicPlanet.Entities.ConfirmationToken;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IConfirmationTokenDal {
    Optional<ConfirmationToken> findByToken(String token);
    int updateConfirmedAt(String token, LocalDateTime confirmedAt);
    void save(ConfirmationToken token);
}
