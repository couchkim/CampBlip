package com.theironyard.services;

import com.theironyard.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by graceconnelly on 2/21/17.
 */
public interface StatusRepository extends JpaRepository<Part,Integer> {
}
