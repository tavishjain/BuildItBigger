package com.jain.tavish.joke_provider;

import java.util.Random;

public class JokeProvider {

    public String getRandomJoke() {
        String[] jokes = new String[5];
        jokes[0] = "Q. What is the biggest lie in the entire universe?\n" +
                "\n" +
                "A. \"I have read and agree to the Terms & Conditions.\"";

        jokes[1] = "Q. Why did the PowerPoint Presentation cross the road?\n" +
                "\n" +
                "A. To get to the other slide.\n" +
                "\n";

        jokes[2] = "Q: Why did the computer show up at work late?\n" +
                "\n" +
                "A: It had a hard drive.";

        jokes[3] = "The guy who invented auto-correct for smart phones passed away today.\n" +
                "\n" +
                "Restaurant in peace.\n" +
                "\n";

        jokes[4] = "Q: Why was the cell phone wearing glasses?\n" +
                "\n" +
                "A: It lost its contacts.";

        Random random = new Random();
        int a = random.nextInt(4);

        return jokes[a];

    }
}
