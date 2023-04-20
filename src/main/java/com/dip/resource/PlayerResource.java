package com.dip.resource;

import com.dip.model.Player;
import com.dip.repository.PlayerRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/players")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {
    private final int defaultSize;
    private final PlayerRepository playerRepository;

    public PlayerResource(int defaultSize, PlayerRepository playerRepository) {
        this.defaultSize = defaultSize;
        this.playerRepository = playerRepository;
    }

    @GET
    public List<Player> getBrands(@QueryParam("size") Optional<Integer> size) {
        return playerRepository.findAll(size.orElse(defaultSize));
    }

    @GET
    @Path("/{id}")
    public Player getByJerseryumber(@PathParam("jerseyNumber") int jerseyNumber) {
        return playerRepository
               .findByJerseyNumber(jerseyNumber)
                .orElseThrow(RuntimeException::new);
    }
}

