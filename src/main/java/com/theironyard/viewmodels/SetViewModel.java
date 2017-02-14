package com.theironyard.viewmodels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by graceconnelly on 2/8/17.
 */
public class SetViewModel {
    List<SetView> setViews = new ArrayList<SetView>();

    public SetViewModel() {
    }

    public SetViewModel(List<SetView> setViews) {
        this.setViews = setViews;
    }

    public List<SetView> getSetViews() {
        return setViews;
    }

    public void setSetViews(List<SetView> setViews) {
        this.setViews = setViews;
    }
}
