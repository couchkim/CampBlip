package com.theironyard.services;

import com.theironyard.datamodels.Enums.SkillEnum;
import com.theironyard.datamodels.Enums.StatusEnum;
import com.theironyard.entities.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by graceconnelly on 2/7/17.
 */
public interface SetRepository extends JpaRepository<Set,Long>, QueryByExampleExecutor<Set> {

    Set findById (int id);

    //List<Set> findByThemeByStatusBySkill(String theme, StatusEnum status, SkillEnum skill);
    @Query("select distinct s.theme from Set s order by s.theme asc")
    List <String> selectDistinctThemes();
}
