package com.theironyard.services;

import com.theironyard.entities.SetPart;
import com.theironyard.viewmodels.PartView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by graceconnelly on 2/10/17.
 */
public interface SetPartRepository extends JpaRepository<SetPart, Integer> {

//    @Query("select new com.theironyard.viewmodels.PartView(pp.name, pp.color, pp.partUrl, pp.elementId, p.setQty, p.invQty) from SetPart p join p.part pp where p.set = setId"))
//    @Query("select new com.theironyard.viewmodels.PartView(p.name, p.color, p.partUrl, p.elementId, sp.setQty, sp.invQty) from SetPart sp " +
//            "join sp.part p " +
//            "WHERE sp.set = :setId")
//    List<PartView> partViewFromSetId(@Param("setId") int setId);
}
