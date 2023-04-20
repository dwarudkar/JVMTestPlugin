package com.dip;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class PlayerResourceTest {

    @Test
    void shouldTestFetchByPlayersJerseyNumber() {
        Response response = RestAssured.get("http://localhost:62156/players");
        assertThat(response.getStatusCode(), equalTo(200));
    }
}
