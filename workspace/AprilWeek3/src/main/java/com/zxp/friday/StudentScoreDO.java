package com.zxp.friday;

public class StudentScoreDO {
    private Integer studentId;
    private Integer chineseScore;
    private Integer mathScore;

    public Integer getTotalScore(){
        return chineseScore + mathScore;
    }
}
