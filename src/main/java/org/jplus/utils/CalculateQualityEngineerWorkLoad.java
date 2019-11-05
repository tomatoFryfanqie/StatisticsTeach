package org.jplus.utils;

/**
 * @program: StatisticsTeach
 * @description: 计算质量工程的工作量
 * @author: MH
 * @create: 2019-11-02 13:28
 **/
public class CalculateQualityEngineerWorkLoad {
    private static final int TOP_PROJECT_NATIONAL_SCORE = 1000;
    private static final int TOP_PROJECT_PROVINCIAL_SCORE = 500;
    private static final int ORDINARY_PROJECT_NATIONAL_SCORE = 300;
    private static final int ORDINARY_PROJECT_PROVINCIAL_SCORE = 100;

    /**
     * @author MH
     * @date 2019/11/2 13:47
     * @param projectType  项目类型
     * @param projectLevel 项目级别（1国家级 2省级）
     * @return int
     */
    private static int calulateProjectScores(int projectType, int projectLevel) {
        int score = 0;
        //从开始都是判断，到最后必须要返回一个值，返回的值如何处理
        if (projectType == 1 || projectType == 2) {
            if (projectLevel == 1) {
                score = TOP_PROJECT_NATIONAL_SCORE;
            }
            if (projectLevel == 2) {
                score = TOP_PROJECT_PROVINCIAL_SCORE;
            }
        } else if (projectType > 2) {
            if (projectLevel == 1) {
                score = ORDINARY_PROJECT_NATIONAL_SCORE;
            }
            if (projectLevel == 2) {
                score = ORDINARY_PROJECT_PROVINCIAL_SCORE;
            }
        }
        return score;
    }

    /**
     * @author MH
     * @date 2019/11/2 13:48
     * @param projectRacking 个人在项目中的排名
     * @param projectMemberNumbers 项目总人数
     * @return float
     */
    private static float calculateWeight(int projectRacking, int projectMemberNumbers) {
        //小于三人
        float weight = 0;
        if (projectMemberNumbers == 1) {
            weight = 1;
        } else if (projectMemberNumbers == 2) {
            if (projectRacking == 1) {
                weight = 0.7f;
            }
            if (projectRacking == 2) {
                weight = 0.3f;
            }
        } else if (projectMemberNumbers == 3) {
            if (projectRacking == 1) {
                weight = 0.7f;
            }
            if (projectRacking == 2) {
                weight = 0.2f;
            }
            if (projectRacking == 3) {
                weight = 0.1f;
            }
        } else if (projectMemberNumbers > 3) {
            if (projectRacking == 1) {
                weight = 0.6f;
            }
            if (projectRacking == 2) {
                weight = 0.2f;
            }
            if (projectRacking == 3) {
                weight = 0.1f;
            }
            if (projectRacking > 3) {
                weight = 0.1f / (projectMemberNumbers - 3);
            }
        }
        return weight;
    }

    /**
     * @author MH
     * @date 2019/11/2 13:48
     * @param projectType 项目类型
     * @param projectLevel 项目级别
     * @param projectRacking 个人在项目中的排名
     * @param projectMemberNumbers  项目总人数
     * @return float
     */
    public static float calculateWorkLoad(int projectType, int projectLevel, int projectRacking, int projectMemberNumbers) {
        int score = calulateProjectScores(projectType, projectLevel);
        float weight = calculateWeight(projectRacking, projectMemberNumbers);
        return weight * score;
    }

    public static void main(String[] args) {
        float workload = CalculateQualityEngineerWorkLoad.calculateWorkLoad(1,1,1,1);
        System.out.println(workload);
    }
}
