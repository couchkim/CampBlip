package com.theironyard.services;

import com.theironyard.datamodels.SkillEnum;
import com.theironyard.datamodels.StatusEnum;
import com.theironyard.entities.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.context.Theme;

import java.util.List;

/**
 * Created by graceconnelly on 2/7/17.
 */
public interface SetRepository extends JpaRepository<Set,Integer> {
    List<Set> findAllBySetNum (String setNum);

    Set findById (int id);

    List<Set> findByStatusEnum(StatusEnum status);

    List<Set> findByskillEnum(SkillEnum skill);

    List<Set> findByTheme(String theme);

    //List<Set> findByThemeByStatusBySkill(String theme, StatusEnum status, SkillEnum skill);




    @Query("select distinct s.theme from Set s")
    List <String> selectDistinctThemes();
}
