package com.theironyard.services;

import com.theironyard.entities.InventoryItems;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by graceconnelly on 2/7/17.
 */
public interface InventoryItemsRepository extends CrudRepository<InventoryItems,Integer> {
}
