package com.theironyard.services;

import com.theironyard.entities.Set;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by graceconnelly on 2/7/17.
 */
public interface SetRepository extends CrudRepository<Set,Integer> {
    List<Set> findAllBySetNum (String setNum);
}
