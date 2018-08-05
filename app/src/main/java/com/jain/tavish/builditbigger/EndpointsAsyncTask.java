package com.jain.tavish.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.jain.tavish.builditbigger.backend.jokeApi.JokeApi;
import com.jain.tavish.builditbigger.backend.jokeApi.model.MyBean;
import com.jain.tavish.jokescreen.JokeActivity;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static JokeApi mJokeApi  = null;
    private Context context;
    private View progressBar;

    public EndpointsAsyncTask(Context mContext, View mProgressBar){
        context = mContext;
        progressBar = mProgressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (mJokeApi == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://cloudenginetest-992.appspot.com/_ah/api/");

            mJokeApi = builder.build();
        }

        try {
            MyBean myBean = mJokeApi.putJoke().execute();
            return myBean.getData();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_CONSTANT, result);
        context.startActivity(intent);
    }
}
