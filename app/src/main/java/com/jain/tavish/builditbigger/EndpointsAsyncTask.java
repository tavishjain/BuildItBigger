package com.jain.tavish.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.jain.tavish.joke_provider.JokeProvider;
import com.jain.tavish.jokescreen.JokeActivity;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.backend.jokeApi.model.MyBean;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static JokeApi myApiService = null;
    private Context context;
    private View progressBar;

    public EndpointsAsyncTask(Context mContext, View mProgressBar){
        context = mContext;
        progressBar = mProgressBar;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (myApiService == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://cloudenginetest-992.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        try {
            return myApiService.putJoke(new MyBean()).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        JokeProvider jokeProvider = new JokeProvider();
        String joke = jokeProvider.getRandomJoke();
        progressBar.setVisibility(View.GONE );
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra("joke", joke);
        context.startActivity(intent);
    }
}
