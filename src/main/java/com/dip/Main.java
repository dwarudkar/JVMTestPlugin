package com.dip;


import com.dip.model.Player;
import com.dip.repository.PlayerRepository;
import com.dip.resource.PlayerResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.List;

public class Main extends Application<BaseConfiguration> {

    public static void main(String[] args) throws Exception {
        new Main().run("server", "introduction-config.yml");
    }

    @Override
    public void initialize(Bootstrap<BaseConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        super.initialize(bootstrap);
    }

    @Override
    public void run(BaseConfiguration basicConfiguration, Environment environment) {
        int defaultSize = basicConfiguration.getDefaultSize();
        PlayerRepository playerRepository = new PlayerRepository(initBrands());
        PlayerResource playerResource = new PlayerResource(defaultSize, playerRepository);

        environment
                .jersey()
                .register(playerResource);

        environment
                .healthChecks()
                .register("application",new AppHealthCheck());
    }

    public List<Player> initBrands(){
        return List.of(
                Player.builder()
                        .jerseyNumber(2)
                        .name("James")
                        .build(),
                Player.builder()
                        .jerseyNumber(1)
                        .name("john")
                        .build(),
                Player.builder()
                        .jerseyNumber(3)
                        .name("Meeram")
                        .build());
    }
}
