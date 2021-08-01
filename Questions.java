package com.example.truefalse;

public class Questions {

    public String mQuestions[] = {
            "Mercury is the first planet in the solar system",
            "Venus is the third planet in the solar system",
            "Earth is the fourth planet in the solar system",
            "Mars is the first planet in the solar system",
            "Jupiter is the seventh planet in the solar system",
            "Saturn is the fifth planet in the solar system",
            "Uranus is the seventh planet in the solar system",
            "Neptune is the eight planet in the solar system",

    };

    public String mAnswers[] = {
            "true",
            "false",
            "false",
            "false",
            "false",
            "false",
            "true",
            "true"


    };

    public String getQuestion(int number) {
        return mQuestions[number];
    }
    public String getAnswer(int number) { return mAnswers[number]; }

}
