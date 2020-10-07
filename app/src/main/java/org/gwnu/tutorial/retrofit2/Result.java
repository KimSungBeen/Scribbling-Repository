package org.gwnu.tutorial.retrofit2;

import org.jetbrains.annotations.NotNull;

public class Result {
    private String NM_CONTENTS;
    private String SYNOPSIS;
    private String ID_GENRE;
    private String STARRING;

    public String getNM_CONTENTS() {
        return NM_CONTENTS;
    }

    public void setNM_CONTENTS(String NM_CONTENTS) {
        this.NM_CONTENTS = NM_CONTENTS;
    }

    public String getSYNOPSIS() {
        return SYNOPSIS;
    }

    public void setSYNOPSIS(String SYNOPSIS) {
        this.SYNOPSIS = SYNOPSIS;
    }

    public String getID_GENRE() {
        return ID_GENRE;
    }

    public void setID_GENRE(String ID_GENRE) {
        this.ID_GENRE = ID_GENRE;
    }

    public String getSTARRING() {
        return STARRING;
    }

    public void setSTARRING(String STARRING) {
        this.STARRING = STARRING;
    }

    @NotNull
    @Override
    public String toString() {
        return "Result{" +
                "NM_CONTENTS='" + NM_CONTENTS + '\'' +
                ", SYNOPSIS='" + SYNOPSIS + '\'' +
                ", ID_GENRE='" + ID_GENRE + '\'' +
                ", STARRING='" + STARRING + '\'' +
                '}';
    }
}