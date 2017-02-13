package com.theironyard.services;

import com.theironyard.entities.Set;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by graceconnelly on 2/7/17.
 */
public interface SetRepository extends JpaRepository<Set,Integer> {
    List<Set> findAllBySetNum (String setNum);
    Set findById(int id);
}
