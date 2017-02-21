package com.theironyard.services;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

/**
 * Created by graceconnelly on 2/15/17.
 */
public interface QueryByExampleExecutor<T> {

    <S extends T> S findOne(Example<S> example);

    <S extends T> Iterable <S> findAll(Example<S> example, Sort sort);

    // order by numParts asc
}
