package com.github.krystianmadra.guitarshop.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuitarRestfulTest {

    @Test
    public void shouldReturnWholeGuitarWithId1() throws IOException {
        restTest("http://localhost:8080/war/guitar/1", "controller/1.json");
    }

    @Test
    public void shouldReturnAllIGuitars() throws IOException {
        restTest("http://localhost:8080/war/guitar", "controller/all.json");
    }

    private void restTest(String aRestUrl, String aPreparedFilePath) throws IOException {
        //given - prepare html request
        HttpGet getRequest = new HttpGet(aRestUrl);
        //given - prepare expected result
        JsonParser parser = new JsonParser();
        FileReader preparedFile = new FileReader(
                getClass().getClassLoader().getResource(aPreparedFilePath).getFile());
        JsonElement expected = parser.parse(preparedFile);

        //when make rest call
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(getRequest);
        String content = EntityUtils.toString(httpResponse.getEntity());

        //then
        assertEquals(200, httpResponse.getStatusLine().getStatusCode());

        JsonElement result = parser.parse(content);
        assertEquals(expected, result);
    }
}
