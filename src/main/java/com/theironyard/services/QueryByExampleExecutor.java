package com.theironyard.services;

import org.springframework.data.domain.Example;

/**
 * Created by graceconnelly on 2/15/17.
 */
public interface QueryByExampleExecutor<T> {

    <S extends T> S findOne(Example<S> example);

    <S extends T> Iterable <S> findAll(Example<S> example);


    // order by numParts asc
}
