package com.theironyard.viewmodels;

import java.util.List;

/**
 * Created by graceconnelly on 2/8/17.
 */
public class SetViewModel {
    List<SetView> sets;

    public SetViewModel() {
    }

    public SetViewModel(List<SetView> sets) {
        this.sets = sets;
    }

    public List<SetView> getSets() {
        return sets;
    }

    public void setSets(List<SetView> sets) {
        this.sets = sets;
    }
}
