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

    List<Set> findAllBySetNum (String setNum);

    Set findById (int id);

    List<Set> findByStatusEnum(StatusEnum status);

    List<Set> findByskillEnum(SkillEnum skill);

    List<Set> findByTheme(String theme);

    //List<Set> findByThemeByStatusBySkill(String theme, StatusEnum status, SkillEnum skill);
    @Query("select distinct s.theme from Set s")
    List <String> selectDistinctThemes();
}
