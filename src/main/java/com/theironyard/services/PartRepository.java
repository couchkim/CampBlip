package com.theironyard.services;

import com.theironyard.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by graceconnelly on 2/7/17.
 */
public interface PartRepository extends JpaRepository<Part,Integer> {
    Part findFirstByElementId(int elementId);
}