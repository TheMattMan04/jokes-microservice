package com.myorg.jokesservice.service;

import com.google.gson.Gson;
import com.myorg.jokesservice.configuration.Configuration;
import com.myorg.jokesservice.model.JokeBody;
import com.myorg.jokesservice.model.ResponseBody;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JokesService {

    @Autowired
    private Configuration configuration;

    private final Gson gson = new Gson();

    private final OkHttpClient client = new OkHttpClient();

    public ResponseBody getJoke() {
        JokeBody joke = new JokeBody();
        ResponseBody responseBody = new ResponseBody();

        Request request = new Request.Builder()
                .header("accept", "application/json")
                .url(configuration.getUrl())
                .build();

        Call call = client.newCall(request);

        try {
            Response response = call.execute();

            String responseString = response.body().string();

            joke = gson.fromJson(responseString, JokeBody.class);

            responseBody.setResponseMessage("Success");
            responseBody.setResponse(joke);

        } catch (IOException e) {
            joke.setJoke(null);
            joke.setStatus(500);

            responseBody.setResponseMessage("Error getting response: " + '\n' + e.getMessage());
            responseBody.setResponse(joke);
        }

        return responseBody;
    }
}
