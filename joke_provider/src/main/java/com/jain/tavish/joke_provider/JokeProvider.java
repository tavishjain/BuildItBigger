package com.jain.tavish.joke_provider;

import java.util.Random;

public class JokeProvider {

    String[] jokes = new String[] {
            "Q. What is the biggest lie in the entire universe?\n" +
                    "\n" +
                    "A. \"I have read and agree to the Terms & Conditions.\"",

            "Q. Why did the PowerPoint Presentation cross the road?\n" +
                    "\n" +
                    "A. To get to the other slide.\n" +
                    "\n",

            "Q: Why did the computer show up at work late?\n" +
                    "\n" +
                    "A: It had a hard drive.",

            "The guy who invented auto-correct for smart phones passed away today.\n" +
                    "\n" +
                    "Restaurant in peace.\n" +
                    "\n",

            "Q: Why was the cell phone wearing glasses?\n" +
                    "\n" +
                    "A: It lost its contacts."};

    public String getRandomJoke() {
        Random random = new Random();
        int a = random.nextInt(jokes.length);
        return jokes[a];

    }
}