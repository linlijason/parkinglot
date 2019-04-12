package com.thoughtworks.parkinglot.domain;

public interface ValueObject<T> {

    boolean equalOther(T other);
}
