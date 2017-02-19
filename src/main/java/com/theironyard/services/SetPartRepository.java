package com.theironyard.services;

import com.theironyard.entities.SetPart;
import com.theironyard.viewmodels.PartView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by graceconnelly on 2/10/17.
 */
public interface SetPartRepository extends JpaRepository<SetPart, Integer> {
    @Query("select new com.theironyard.viewmodels.PartView(s.id, p.name, p.color, p.partUrl, p.elementId, sp.setQty, sp.invQty, sp.currInv, sp.id) from SetPart sp " +
            "join sp.part p" +
            " join sp.set s" +
            " where s.id = :setId" +
            " order by p.color asc")
    List<PartView> partViewFromSetId(@Param("setId") int setId);

    SetPart findFirstById(int id);

    SetPart findBySetId(int setId);
}
