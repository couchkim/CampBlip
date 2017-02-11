package com.theironyard.datamodels.Instructions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by graceconnelly on 2/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Build {
    private String description;
    private String pdfLocation;

    public Build() {
    }

    public Build(String description, String pdfLocation) {
        this.description = description;
        this.pdfLocation = pdfLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPdfLocation() {
        return pdfLocation;
    }

    public void setPdfLocation(String pdfLocation) {
        this.pdfLocation = pdfLocation;
    }

    @Override
    public String toString() {
        return "Build{" +
                "description='" + description + '\'' +
                ", pdfLocation='" + pdfLocation + '\'' +
                '}';
    }
}
