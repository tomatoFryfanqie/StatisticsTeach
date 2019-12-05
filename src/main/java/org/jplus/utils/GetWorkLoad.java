package org.jplus.utils;

import org.jplus.dto.BkssjjxEx;
import org.jplus.pojo.bks.Bkssjjx;
import org.springframework.beans.BeanUtils;


public class GetWorkLoad {
    //撰写人才培养方案分数
    private static final Integer TalentTrainingProgram_SCORE = 20;
    //编写每门课程教学大纲课程的分数
    private static final Integer CurriculumSyllabus_SCORE = 10;
    //编写每门实验教学大纲课程的分数
    private static final Integer ExperimentalSyllabus_SCORE = 10;
    private static final Integer TOP_PROJECT_NATIONAL_SCORE = 1000;
    private static final Integer TOP_PROJECT_PROVINCIAL_SCORE = 500;
    private static final Integer ORDINARY_PROJECT_NATIONAL_SCORE = 300;
    private static final Integer ORDINARY_PROJECT_PROVINCIAL_SCORE = 100;

    /**
     * @param zwbm   职务编码
     * @param zcbm   职称编码
     * @param gwlxbm 岗位类型编码
     * @param sfxrz  是否新入职
     * @return
     */
    public static Float getRatedWorkload(Integer zwbm, Integer zcbm, Integer gwlxbm, Integer sfxrz) {
        Float getWorkLoad = 0.0f;

        if (zcbm == 3 || zcbm == 4) {
            if (zcbm == 3) {
                if (sfxrz == 0) {
                    getWorkLoad = 140.0f;
                } else {
                    getWorkLoad = 280.0f;
                }
            } else {
                if (sfxrz == 0) {
                    getWorkLoad = 100.0f;
                } else {
                    getWorkLoad = 200.0f;
                }
            }
        } else {
            if (zcbm == 1) {
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
            if (zcbm == 2) {
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

        if (zwbm == 3 || zwbm == 4) {
            getWorkLoad = getWorkLoad * 0.5f;
        } else if (zwbm == 5) {
            getWorkLoad = getWorkLoad * 0.75f;
        }

        return getWorkLoad;
    }

    /**
     * @param zcbm   职称编码
     * @param gwlxbm 岗位类型编码
     * @return
     */
    public static Float getTeachTime(Integer zcbm, Integer gwlxbm) {

        Float getTime = 0.0f;

        if (zcbm == 3 || zcbm == 4) {
            getTime = 96.0f;
        } else {
            switch (gwlxbm) {
                case 1:
                    getTime = 160.0f;
                    break;
                case 2:
                    getTime = 96.0f;
                    break;
                case 3:
                    getTime = 32.0f;
                    break;
            }
        }
        return getTime;
    }

    /**
     * @param jhxs 计划学时
     * @param bzrs 标准人数
     * @param skrs 上课人数
     * @return
     */
    public static Float getYjsClassWorkLoad(Integer jhxs, Integer bzrs, Integer skrs) {
        Float getWork = 0.0f;

        /*判断人数*/
        if (skrs <= bzrs) {
            getWork = (float) jhxs * 1.5f;
        } else {
            getWork = (float) jhxs * 1.5f * (1.0f +  ((float)(skrs - bzrs) / skrs));
        }
        return getWork;
    }

    /*获得本科生课堂教学工作量*/

    /**
     * @param jhxs 教学学时
     * @param sfsy 是否双语
     * @param bzrs 标准人数
     * @param skrs 上课人数
     * @return 返回工作量
     */
    public static Float getClassWork(Integer jhxs, Integer sfsy, Integer bzrs, Integer skrs) {

        Float getWork = 0.0f;

        /*判断人数*/
        if (skrs <= bzrs) {
            if (sfsy == 1) {
                getWork = (float) jhxs * 1.5f;
            } else {
                getWork = (float) jhxs * 1.0f;
            }
        } else {
            if (sfsy == 1) {
                getWork = (float) jhxs * 1.5f * (1.0f + ((float) (skrs - bzrs) / skrs));
            } else {
                getWork = (float) jhxs * 1.0f * (1.0f + ((float) (skrs - bzrs) / skrs));
            }
        }

        return getWork;
    }

    /**
     * @param bkssjjx
     * @return 实践教学工作量
     */
    public static BkssjjxEx getSjjxWork(Bkssjjx bkssjjx) {
        //扩展类封装
        BkssjjxEx bkssjjxEx = new BkssjjxEx();
        BeanUtils.copyProperties(bkssjjx, bkssjjxEx);
        //计算
        float res = 0;
        //计算第一个实习类型工作量
        int sxlx1 = bkssjjx.getSxlxbm1();
        int sxts1 = bkssjjx.getSxts1() == null ? 0 : bkssjjx.getSxts1();
        res += getSxlxWork(sxlx1, sxts1);

        //计算第二个实习类型工作量
        int sxlx2 = bkssjjx.getSxlxbm2();
        int sxts2 = bkssjjx.getSxts2() == null ? 0 : bkssjjx.getSxts2();
        res += getSxlxWork(sxlx2, sxts2);

        //计算第三个实习类型工作量
        int sxlx3 = bkssjjx.getSxlxbm3();
        int sxts3 = bkssjjx.getSxts3() == null ? 0 : bkssjjx.getSxts3();
        res += getSxlxWork(sxlx3, sxts3);
        bkssjjxEx.setZdsxgzl(res); /*设置指导实习总工作量*/

        //微格式讲工作量
        int wgsj = 0;
        if (bkssjjx.getWgsjrs() == null) {
            bkssjjx.setWgsjrs(0);
        }
        wgsj = bkssjjx.getWgsjrs() * 2; /* 微格式讲人数*2 */
        res += wgsj;
        bkssjjxEx.setWgsjgzl(wgsj); /*设置微格式讲工作量*/

        //毕业论文工作量
        int lwbm = bkssjjx.getZylxbm(); //专业类型：文，理，工，留学
        int rs = 0;
        if (bkssjjx.getZdlwrs() == null) {
            bkssjjx.setZdlwrs(0);
        }
        rs = bkssjjx.getZdlwrs(); //指导人数
        float lwgzl = 0;
        if (lwbm == 1) {
            lwgzl += (rs >= 10 ? 80 : rs * 8); //文科：超过10人不计分数
        }
        if (lwbm == 2) {
            lwgzl += (rs >= 8 ? 72 : rs * 9); //理科：超过8人不记分
        }
        if (lwbm == 3) {
            lwgzl += (rs >= 8 ? 80 : rs * 10); //工科：超过8人不记分
        }
        if (lwbm == 4) {
            lwgzl += (rs >= 6 ? 90 : rs * 15); //留学生：超过6人不记分
        }
        res += lwgzl;
        bkssjjxEx.setZdlwgzl(lwgzl); /*设置指导毕业论文工作量*/

        //管理工作量
        if (bkssjjx.getGlgzl() == null) {
            bkssjjx.setGlgzl(0f);
        }
        float glgzl = bkssjjx.getGlgzl();
        bkssjjxEx.setGlgzl(glgzl); /*设置管理工作量*/

        //总工作量
        res += glgzl;
        bkssjjxEx.setGzl(res); /*设置总工作量*/
        return bkssjjxEx;
    }


    /**
     * @param sxlxbm
     * @param sxts
     * @return 各个实习类型对应实习天数的工作量
     */
    private static float getSxlxWork(int sxlxbm, int sxts) {
        float res = 0;
        if (sxlxbm == 1) { /*驻点实习 4分/天*/
            res += sxts * 4;
        } else if (sxlxbm == 2) { /*非驻地实习 1分/天*/
            res += sxts * 1;
        } else if (sxlxbm >= 3) { /*其他实习 2分天*/
            res += sxts * 2;
        }
        return res;
    }

    /**
     * 教师竞赛的竞赛形式
     * 1：讲课 2：课件 3：微课
     * 在同等竞赛等级情况下，课件和微课的工作量是讲课的一半
     *
     * @param teacherCompetitionform 竞赛形式
     * @param gzl                    工作量
     */
    public static Integer getTeacherCompetitionWorkload(Integer teacherCompetitionform, Integer gzl) {
        if (teacherCompetitionform != 1) {
            gzl /= 2;
        }
        return gzl;
    }

    /**
     * 教师指导学生学士学位论文获奖
     *
     * @param slwNum 省级论文数量
     * @param xlwNum 校级论文数量
     *               每篇省级论文工作量：30
     *               每篇省级论文工作量：10
     */
    public static Float getUndergradautePaper(Integer slwNum, Integer xlwNum) {
        float gzl = slwNum * 30 + xlwNum * 10;
        return gzl;
    }

    /**
     * 本科生其他教学工作量统计
     *
     * @param workloadOfTeachingSupervision      教学督导工作量
     * @param numberOfStudentsAssisted           帮扶学生人数
     * @param guideYoungTeachers                 指导青年教师
     * @param reviseTalentTrainingPlan           参与修订人才培养方案
     * @param prepareCourseSyllabusCount         编写课程教学大纲课程数
     * @param compilingExperimentalSyllabusCount 编写实验教学大纲课程数
     */
    public static Float getOtherTeachWorkload(Float workloadOfTeachingSupervision, Integer numberOfStudentsAssisted, Integer guideYoungTeachers,
                                              Integer reviseTalentTrainingPlan, Integer prepareCourseSyllabusCount, Integer compilingExperimentalSyllabusCount) {
        Float allGzl = workloadOfTeachingSupervision + guideYoungTeachers * 10 + numberOfStudentsAssisted * 10 + reviseTalentTrainingPlan * 20 + prepareCourseSyllabusCount * 10 + compilingExperimentalSyllabusCount * 10;
        return allGzl;
    }

    /**
     * 教师指导研究生学位论文获奖
     *
     * @param slwNum 省级论文数量
     * @param xlwNum 校级论文数量
     *               每篇省级论文工作量：50
     *               每篇省级论文工作量：10
     */
    public static Float getGraduatePaper(Integer slwNum, Integer xlwNum) {
        float gzl = slwNum * 50 + xlwNum * 10;
        return gzl;
    }

    /**
     * 研究生其他教学工作量统计
     *
     * @param workloadOfTeachingSupervision 教学督导工作量
     * @param proposition                   初复试自命题
     * @param examining                     初复试自命题审题
     * @param check                         初复试自命题校对
     * @param examiner                      复试面试考官
     * @param invigilator                   复试监考
     * @param checking                      考试阅卷（初试、复试）
     */
    public static Double getMasterOtherTeachWorkload(Float workloadOfTeachingSupervision, Integer proposition, Integer examining,
                                                     Integer check, Integer examiner, Integer invigilator, Integer checking) {
        double gzl = workloadOfTeachingSupervision + proposition * 8 + examining * 4 + check * 4 + examiner * 4 + invigilator * 3 + checking * 0.3;
        return gzl;
    }


    /**
     * @param projectType  项目类型
     * @param projectLevel 项目级别（1国家级 2省级）
     * @return int
     * @author MH
     * @date 2019/11/2 13:47
     */
    private static Integer calulateProjectScores(Integer projectType, Integer projectLevel) {
        Integer score = 0;
        if (projectType == 1 || projectType == 2) {
            switch (projectLevel) {
                case 1:
                    score = TOP_PROJECT_NATIONAL_SCORE;
                    break;
                case 2:
                    score = TOP_PROJECT_PROVINCIAL_SCORE;
                    break;
                default:
                    ;
            }
        } else if (projectType > 2) {
            switch (projectLevel) {
                case 1:
                    score = ORDINARY_PROJECT_NATIONAL_SCORE;
                    break;
                case 2:
                    score = ORDINARY_PROJECT_PROVINCIAL_SCORE;
                    break;
                default:
                    ;
            }
        }
        return score;
    }

    /**
     * @param projectRacking       个人在项目中的排名
     * @param projectMemberNumbers 项目总人数
     * @return float
     * @author MH
     * @date 2019/11/2 13:48
     */
    public static Float calculateWeight(Integer projectRacking, Integer projectMemberNumbers) {
        Float weight = 0f;
        if (projectMemberNumbers == 1) {
            weight = 1f;
        } else if (projectMemberNumbers == 2) {
            switch (projectRacking) {
                case 1:
                    weight = 0.7f;
                    break;
                case 2:
                    weight = 0.3f;
                    break;
                default:
                    ;
            }
        } else if (projectMemberNumbers == 3) {
            switch (projectRacking) {
                case 1:
                    weight = 0.7f;
                    break;
                case 2:
                    weight = 0.2f;
                    break;
                case 3:
                    weight = 0.1f;
                    break;
                default:
                    ;
            }
        } else if (projectMemberNumbers > 3){
            if (projectRacking == 1) {
                weight = 0.6f;
            } else if (projectRacking == 2) {
                weight = 0.2f;
            } else if (projectRacking == 3) {
                weight = 0.1f;
            } else if (projectRacking > 3){
                weight = 0.1f / (projectMemberNumbers - 3);
            }
        }
        return weight;
    }


    /**
     * @param projectType          项目类型
     * @param projectLevel         项目级别
     * @param projectRacking       个人在项目中的排名
     * @param projectMemberNumbers 项目总人数
     * @return float
     * @author MH
     * @date 2019/11/2 13:48
     */
    public static Float getQualityEngineerWorkLoad(Integer projectType, Integer projectLevel, Integer projectRacking, Integer projectMemberNumbers) {
        Integer score = calulateProjectScores(projectType, projectLevel);
        Float weight = calculateWeight(projectRacking, projectMemberNumbers);
        return weight * score;
    }

    /**
     * @param isTalentTrainingProgram      是否撰写人才培养方案分数
     * @param NumberOfCurriculumSyllabus   编写课程教学大纲课程的门数
     * @param NumberOfExperimentalSyllabus 编写每门实验教学大纲课程的门数
     * @return float
     * @author MH
     * @date 2019/11/9 13:01
     */
    public static Float getGraduateConstructionWorkload(Integer isTalentTrainingProgram, Integer NumberOfCurriculumSyllabus, Integer NumberOfExperimentalSyllabus) {
        Float workLoad = 0.0f;
        if (isTalentTrainingProgram == 1) {
            workLoad += TalentTrainingProgram_SCORE;
        }
        workLoad += (NumberOfCurriculumSyllabus * CurriculumSyllabus_SCORE + NumberOfExperimentalSyllabus * ExperimentalSyllabus_SCORE);
        return workLoad;
    }

    /**
     * @param sjts1 实践天数1
     * @param sjts2 实践天数2
     * @param sjts3 实践天数3
     * @return
     */
    public static Float getDayWorkLoad(Integer sjts1, Integer sjts2, Integer sjts3) {
        if (sjts1 == null) {
            sjts1 = 0;
        }
        if (sjts2 == null) {
            sjts2 = 0;
        }
        if (sjts3 == null) {
            sjts3 = 0;
        }

        Float getWork = 0.0f;
        getWork = (float) sjts1 * 2 + sjts2 * 2 + sjts3 * 2;
        return getWork;
    }

    /**
     * @param zdxshdcs 指导学生活动次数
     * @return
     */
    public static Float getForYjsWorkLoad(Integer zdxshdcs) {
        if (zdxshdcs == null) {
            zdxshdcs = 0;
        }
        Float getWork = 0.0f;
        getWork = (float) zdxshdcs * 1;
        return getWork;
    }
}
