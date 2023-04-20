package com.dip.repository;

import com.dip.model.Player;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlayerRepository {
    private final List<Player> players;

    public PlayerRepository(List<Player> players) {
        this.players = ImmutableList.copyOf(players);
    }

    public List<Player> findAll(int size) {
        return players.stream()
                .limit(size)
                .collect(Collectors.toList());
    }

    public Optional<Player> findByJerseyNumber(int number) {
        return players.stream()
                .filter(brand -> brand.getJerseyNumber() == number )
                .findFirst();
    }
}
