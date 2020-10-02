package org.gwnu.tutorial.retrofit2;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RModel {
    private String RES_MSG, RES_CODE;
    private List<Result> RESULT;

    public List<org.gwnu.tutorial.retrofit2.Result> getResult() {
        return RESULT;
    }

    public void setResult(List<org.gwnu.tutorial.retrofit2.Result> result) {
        RESULT = result;
    }

    public String getRES_MSG() {
        return RES_MSG;
    }

    public void setRES_MSG(String RES_MSG) {
        this.RES_MSG = RES_MSG;
    }

    public String getRES_CODE() {
        return RES_CODE;
    }

    public void setRES_CODE(String RES_CODE) {
        this.RES_CODE = RES_CODE;
    }

    @NotNull
    @Override
    public String toString() {
        return "RModel{" +
                "RES_MSG='" + RES_MSG + '\'' +
                ", RES_CODE='" + RES_CODE + '\'' +
                ", Result=" + RESULT +
                '}';
    }
}
