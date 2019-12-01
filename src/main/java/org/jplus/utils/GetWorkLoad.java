package org.jplus.utils;

import org.jplus.dto.BkssjjxEx;
import org.jplus.pojo.bks.Bkssjjx;
import org.springframework.beans.BeanUtils;

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
     * @param bkssjjx
     * @return 实践教学工作量
     */
    public static BkssjjxEx getSjjxWork(Bkssjjx bkssjjx){
        //扩展类封装
        BkssjjxEx bkssjjxEx=new BkssjjxEx();
        BeanUtils.copyProperties(bkssjjx,bkssjjxEx);
        //计算
        float res=0;
        //计算第一个实习类型工作量
        int sxlx1=bkssjjx.getSxlxbm1();
        int sxts1=bkssjjx.getSxts1()==null?0:bkssjjx.getSxts1();
        res+=getSxlxWork(sxlx1,sxts1);

        //计算第二个实习类型工作量
        int sxlx2=bkssjjx.getSxlxbm2();
        int sxts2=bkssjjx.getSxts2()==null?0:bkssjjx.getSxts2();
        res+=getSxlxWork(sxlx2,sxts2);

        //计算第三个实习类型工作量
        int sxlx3=bkssjjx.getSxlxbm3();
        int sxts3=bkssjjx.getSxts3()==null?0:bkssjjx.getSxts3();
        res+=getSxlxWork(sxlx3,sxts3);
        bkssjjxEx.setZdsxgzl(res); /*设置指导实习总工作量*/

        //微格式讲工作量
        int wgsj = 0;
        if(bkssjjx.getWgsjrs()==null){
            bkssjjx.setWgsjrs(0);
        }
        wgsj=bkssjjx.getWgsjrs()*2; /* 微格式讲人数*2 */
        res+=wgsj;
        bkssjjxEx.setWgsjgzl(wgsj); /*设置微格式讲工作量*/

        //毕业论文工作量
        int lwbm=bkssjjx.getZylxbm(); //专业类型：文，理，工，留学
        int rs = 0;
        if(bkssjjx.getZdlwrs()==null){
            bkssjjx.setZdlwrs(0);
        }
        rs=bkssjjx.getZdlwrs(); //指导人数
        float lwgzl=0;
        if (lwbm==1){
            lwgzl+=(rs>=10?80:rs*8); //文科：超过10人不计分数
        }if (lwbm==2){
            lwgzl+=(rs>=8?72:rs*9); //理科：超过8人不记分
        }if (lwbm==3){
            lwgzl+=(rs>=8?80:rs*10); //工科：超过8人不记分
        }if (lwbm==4){
            lwgzl+=(rs>=6?90:rs*15); //留学生：超过6人不记分
        }
        res+=lwgzl;
        bkssjjxEx.setZdlwgzl(lwgzl); /*设置指导毕业论文工作量*/

        //管理工作量
        if(bkssjjx.getGlgzl()==null){
            bkssjjx.setGlgzl(0f);
        }
        float glgzl=bkssjjx.getGlgzl();
        bkssjjxEx.setGlgzl(glgzl); /*设置管理工作量*/

        //总工作量
        res+=glgzl;
        bkssjjxEx.setGzl(res); /*设置总工作量*/
        return bkssjjxEx;
    }


    /**
     * @param sxlxbm
     * @param sxts
     * @return 各个实习类型对应实习天数的工作量
     */
    private static float getSxlxWork(int sxlxbm,int sxts){
        float res=0;
        if (sxlxbm==1){ /*驻点实习 4分/天*/
            res+=sxts*4;
        }else if (sxlxbm==2){ /*非驻地实习 1分/天*/
            res+=sxts*1;
        }else if (sxlxbm>=3){ /*其他实习 2分天*/
            res+=sxts*2;
        }
        return  res;
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

    /**
     * 本科生教学研究和研究生教学研究项目纵向工作量获取
     * @param xmzrs 项目总人数
     * @param xmpm 项目排名
     * @param xmfs 项目分数
     * */
    //纵向工作量获取
    public static Float GetWorkCount(int xmzrs, int xmpm, int xmfs) {
    //项目权重
        Float xmqz = 0.0f;
        if (xmzrs == 1 && xmpm == 1) {
            xmqz = 1.0f;
        } else if (xmzrs == 2 && xmpm == 1) {
            xmqz = 0.7f;
        } else if (xmzrs == 2 && xmpm == 2) {
            xmqz = 0.3f;
        } else if (xmzrs == 3 && xmpm == 1) {
            xmqz = 0.7f;
        } else if (xmzrs == 3 && xmpm == 2) {
            xmqz = 0.2f;
        } else  {
            if (xmpm == 1) xmqz = 0.6f;
            else if (xmpm == 2) xmqz = 0.2f;
            else if (xmpm == 3) xmqz = 0.1f;
            else xmqz = (float) 0.1 / (xmzrs - 3);
        }
        return xmfs * xmqz;
    }

    /**
     * 本科生教学研究和研究生教学研究项目纵向工作量获取
     * @param xmzrs 项目总人数
     * @param xmpm 项目排名
     * @param dzjf 到账经费
     * */
    //横向工作量获取
    public static Float GetHxWorkCount(int xmzrs, int xmpm, float dzjf) {

        return GetWorkCount(xmzrs,xmpm,(int)Math.ceil(0.001 * dzjf));
    }
}
