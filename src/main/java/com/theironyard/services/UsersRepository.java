package com.theironyard.services;

import com.theironyard.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by graceconnelly on 2/7/17.
 */
public interface UsersRepository extends JpaRepository<User,Integer> {
    User findByName (String name);
}
