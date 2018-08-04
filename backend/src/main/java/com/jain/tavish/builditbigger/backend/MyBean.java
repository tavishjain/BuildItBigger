package com.jain.tavish.builditbigger.backend;

import com.jain.tavish.joke_provider.JokeProvider;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private JokeProvider provider;

    public MyBean(){
        provider = new JokeProvider();
    }

    public String getData() {
        return provider.getRandomJoke();
    }
}