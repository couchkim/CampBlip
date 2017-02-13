package com.theironyard.viewmodels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by graceconnelly on 2/8/17.
 */
public class SimpleImport {
    List<SetView> sets = new ArrayList<SetView>();

    public SimpleImport() {
    }

    public SimpleImport(List<SetView> sets) {
        this.sets = sets;
    }

    public List<SetView> getSets() {
        return sets;
    }

    public void setSets(List<SetView> sets) {
        this.sets = sets;
    }
}
