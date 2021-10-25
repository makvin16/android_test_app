package com.zm.testapp.domain.usecase;

public interface UseCase<In, Out> {

    Out execute(In in);
}
