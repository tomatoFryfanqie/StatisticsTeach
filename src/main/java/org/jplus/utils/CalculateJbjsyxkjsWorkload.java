package org.jplus.utils;

/**
 * @program: StatisticsTeach
 * @description: 计算教学基本建设与学科建设工作的总工作量
 * @author: MH
 * @create: 2019-11-08 15:45
 **/
public class CalculateJbjsyxkjsWorkload {
    //撰写人才培养方案分数
    private static final int TalentTrainingProgram_SCORE = 20;
    //编写每门课程教学大纲课程的分数
    private static final int CurriculumSyllabus_SCORE = 10;
    //编写每门实验教学大纲课程的分数
    private static final int ExperimentalSyllabus_SCORE = 10;

    /**
     * @author MH
     * @date 2019/11/9 13:01
     * @param isTalentTrainingProgram  是否撰写人才培养方案分数
     * @param NumberOfCurriculumSyllabus 编写课程教学大纲课程的门数
     * @param NumberOfExperimentalSyllabus 编写每门实验教学大纲课程的门数
     * @return float
     */
    public static float calculateWorkload(int isTalentTrainingProgram, int NumberOfCurriculumSyllabus, int NumberOfExperimentalSyllabus) {
        float workLoad = 0.0f;
        if (isTalentTrainingProgram == 1) {
            workLoad += TalentTrainingProgram_SCORE;
        }
        workLoad += (NumberOfCurriculumSyllabus * CurriculumSyllabus_SCORE + NumberOfExperimentalSyllabus * ExperimentalSyllabus_SCORE);
        return workLoad;
    }
}
