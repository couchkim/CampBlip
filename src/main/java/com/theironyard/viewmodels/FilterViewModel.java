package com.theironyard.viewmodels;

import java.util.List;

/**
 * Created by graceconnelly on 2/14/17.
 */
public class FilterViewModel {
    List<String> themes;
    List<String> skills;
    List<String> status;

    public FilterViewModel() {
    }

    public FilterViewModel(List<String> themes, List<String> skills, List<String> status) {
        this.themes = themes;
        this.skills = skills;
        this.status = status;
    }

    public List<String> getThemes() {
        return themes;
    }

    public void setThemes(List<String> themes) {
        this.themes = themes;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }
}

