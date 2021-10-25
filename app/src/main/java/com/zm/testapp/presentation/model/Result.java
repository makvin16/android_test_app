package com.zm.testapp.presentation.model;

public class Result <T> {

    private final Stage stage;
    private final T data;
    private final int error;

    public Result(Stage stage, T data, int error) {
        this.stage = stage;
        this.data = data;
        this.error = error;
    }

    public Stage getStage() {
        return stage;
    }

    public T getData() {
        return data;
    }

    public int getError() {
        return error;
    }

    public static class Builder {

        public <T> Result<T> loading() {
            return new Result<T>(Stage.LOADING, null, 0);
        }

        public <T> Result<T> success(T data) {
            return new Result<T>(Stage.SUCCESS, data, 0);
        }

        public <T> Result<T> error(int error) {
            return new Result<T>(Stage.ERROR, null, error);
        }
    }

    public enum Stage {
        SUCCESS,
        ERROR,
        LOADING
    }
}
