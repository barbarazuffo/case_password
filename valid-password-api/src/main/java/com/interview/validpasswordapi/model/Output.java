package com.interview.validpasswordapi.model;

public class Output {
    public Output(boolean answer) {
        this.answer = answer;
    }
    private boolean answer;

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

}
