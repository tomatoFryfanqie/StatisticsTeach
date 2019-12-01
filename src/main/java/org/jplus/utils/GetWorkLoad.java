package org.jplus.utils;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.utils
 * @Author: lzh
 * @CreateTime: 2019/12/1
 * @Description: Description
 */
public class GetWorkLoad {

    /*获得额定教学工作量*/
    /**
     *
     * @param zcbm      职称编码
     * @param gwlxbm    岗位类型编码
     * @param sfxrz     是否新入职 0为是，1为否
     * @return
     */
    public static Float getRatedWorkload(Integer zcbm,Integer gwlxbm,Integer sfxrz){
        Float getWorkLoad = 0.0f;
        if(zcbm==3||zcbm==4){
            if (zcbm==3){
                if (sfxrz==0){
                    getWorkLoad = 140.0f;
                }else {
                    getWorkLoad = 280.0f;
                }
            }else {
                if (sfxrz==0){
                    getWorkLoad = 100.0f;
                }else {
                    getWorkLoad = 200.0f;
                }
            }
        }else{
            if (zcbm==1) {
                switch (gwlxbm) {
                    case 1:
                        getWorkLoad = 330f;
                        break;
                    case 2:
                        getWorkLoad = 260f;
                        break;
                    case 3:
                        getWorkLoad = 80f;
                        break;
                }
            }
            if (zcbm==2){
                switch (gwlxbm) {
                    case 1:
                        getWorkLoad = 360f;
                        break;
                    case 2:
                        getWorkLoad = 280f;
                        break;
                    case 3:
                        getWorkLoad = 100f;
                        break;
                }
            }
        }
        return getWorkLoad;
    }

    /*获得本科生课堂教学工作量*/
    /**
     *
     * @param jhxs  教学学时
     * @param sfsy  是否双语
     * @param bzrs  标准人数
     * @param skrs  上课人数
     * @return      返回工作量
     */
    public static Float getClassWork(Integer jhxs,Integer sfsy,Integer bzrs,Integer skrs){

        Float getWork = 0.0f;

        /*判断人数*/
        if(skrs<=bzrs){
            if (sfsy==1){
                getWork = (float)jhxs*1.5f;
            }
            else {
                getWork = (float)jhxs*1.0f;
            }
        }else {
            if (sfsy==1){
                getWork = (float)jhxs*1.5f*(1.0f+(float)((skrs-bzrs)/skrs));
            }else {
                getWork = (float)jhxs*1.0f*(1.0f+(float)((skrs-bzrs)/skrs));
            }
        }

        return getWork;
    }

    /**
     * 教师竞赛的竞赛形式
     *      1：讲课 2：课件 3：微课
     *          在同等竞赛等级情况下，课件和微课的工作量是讲课的一半
     * @param teacherCompetitionform  竞赛形式
     * @param gzl  工作量
     *
     * */
    public static Integer getTeacherCompetitionWorkload(Integer teacherCompetitionform, Integer gzl) {
        if(teacherCompetitionform != 1) {
            gzl /= 2;
        }
        return gzl;
    }

    /**
     * 教师指导学生学士学位论文获奖
     * @param slwNum  省级论文数量
     * @param xlwNum  校级论文数量
     *       每篇省级论文工作量：30
     *       每篇省级论文工作量：10
     * */
    public static Float getUndergradautePaper(Integer slwNum, Integer xlwNum) {
        float gzl = slwNum * 30 + xlwNum * 10;
        return gzl;
    }

    /**
     * 本科生其他教学工作量统计
     * @param workloadOfTeachingSupervision 教学督导工作量
     * @param numberOfStudentsAssisted 帮扶学生人数
     * @param guideYoungTeachers 指导青年教师
     * @param reviseTalentTrainingPlan 参与修订人才培养方案
     * @param prepareCourseSyllabusCount 编写课程教学大纲课程数
     * @param compilingExperimentalSyllabusCount 编写实验教学大纲课程数
     * */
    public static Float getOtherTeachWorkload(Float workloadOfTeachingSupervision, Integer numberOfStudentsAssisted, Integer guideYoungTeachers,
                                              Integer reviseTalentTrainingPlan, Integer prepareCourseSyllabusCount, Integer compilingExperimentalSyllabusCount) {
        Float allGzl = workloadOfTeachingSupervision + guideYoungTeachers*10 + numberOfStudentsAssisted*10 + reviseTalentTrainingPlan*20 + prepareCourseSyllabusCount*10 + compilingExperimentalSyllabusCount*10;
        return allGzl;
    }

    /**
     * 教师指导研究生学位论文获奖
     * @param slwNum  省级论文数量
     * @param xlwNum  校级论文数量
     *       每篇省级论文工作量：50
     *       每篇省级论文工作量：10
     * */
    public static Float getGraduatePaper(Integer slwNum, Integer xlwNum) {
        float gzl = slwNum * 50 + xlwNum * 10;
        return gzl;
    }

    /**
     * 研究生其他教学工作量统计
     * @param workloadOfTeachingSupervision 教学督导工作量
     * @param proposition 初复试自命题
     * @param examining 初复试自命题审题
     * @param check 初复试自命题校对
     * @param examiner 复试面试考官
     * @param invigilator 复试监考
     * @param checking 考试阅卷（初试、复试）
     * */
    public static Double getMasterOtherTeachWorkload(Float workloadOfTeachingSupervision, Integer proposition, Integer examining,
                                                     Integer check, Integer examiner, Integer invigilator, Integer checking) {
        double gzl = workloadOfTeachingSupervision + proposition*8 + examining*4 + check*4 + examiner*4 + invigilator*3 + checking*0.3;
        return gzl;
    }
}
