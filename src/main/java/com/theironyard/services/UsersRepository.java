package com.theironyard.services;

import com.theironyard.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by graceconnelly on 2/7/17.
 */
public interface UsersRepository extends CrudRepository<User,Integer> {
}
