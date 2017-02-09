package com.theironyard.services;

import com.theironyard.entities.Theme;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by graceconnelly on 2/7/17.
 */
public interface ThemeRepository extends CrudRepository<Theme,Integer> {
}
