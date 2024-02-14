package com.interview.validpasswordapi.model;

public class Output {
    private boolean answer;
    private String message;


    public Output(boolean answer, String message) {
        this.answer = answer;
        this.message = message;
    }
    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {this.message = message; }


}
