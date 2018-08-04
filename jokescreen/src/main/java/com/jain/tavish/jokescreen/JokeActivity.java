package com.jain.tavish.jokescreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Objects;

public class JokeActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke = Objects.requireNonNull(getIntent().getExtras()).getString("joke");

        TextView tvJoke = findViewById(R.id.tv_joke);

        tvJoke.setText(joke);

    }
}
