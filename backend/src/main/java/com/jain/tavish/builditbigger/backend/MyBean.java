package com.jain.tavish.builditbigger.backend;

import com.jain.tavish.joke_provider.JokeProvider;

public class MyBean {

    private JokeProvider provider;

    MyBean(){
        provider = new JokeProvider();
    }

    public String getData() {
        return provider.getRandomJoke();
    }
}