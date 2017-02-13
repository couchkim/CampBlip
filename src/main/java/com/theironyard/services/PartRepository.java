package com.theironyard.services;

import com.theironyard.entities.Part;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by graceconnelly on 2/7/17.
 */
public interface PartRepository extends CrudRepository<Part,Integer>{
    Part findFirstByElementId(int elementId);
}