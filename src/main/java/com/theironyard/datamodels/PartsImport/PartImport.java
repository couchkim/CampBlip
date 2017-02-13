package com.theironyard.datamodels.PartsImport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by graceconnelly on 2/10/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PartImport {
    private int count;
    private List<Result> results;

    public PartImport() {
    }

    public PartImport(int count, List<Result> results) {
        this.count = count;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "PartImport{" +
                "count=" + count +
                ", results=" + results +
                '}';
    }
}
