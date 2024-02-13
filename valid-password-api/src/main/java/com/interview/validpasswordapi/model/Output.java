package com.interview.validpasswordapi.model;

public class Output {
    private boolean answer;
    private String errorMessage;

    public Output(boolean answer, String errorMessage) {

        this.answer = answer;
        this.errorMessage = errorMessage;
    }
    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
