package com.dip.repository;

import com.dip.Main;
import com.dip.model.Player;
import com.dip.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerRepositoryTest {

    private List<Player> players = new Main().initBrands();
    private PlayerRepository playerRepository = new PlayerRepository(players);

    @Test
    public void testFindByJerseyNumber() {

        assertThat(playerRepository.findByJerseyNumber(1) ).isNotEmpty();


    }
}
