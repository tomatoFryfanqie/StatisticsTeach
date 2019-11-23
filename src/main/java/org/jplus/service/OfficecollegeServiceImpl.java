package org.jplus.service;

import org.jplus.mapper.CheckgzlMapper;
import org.jplus.pojo.Users;
import org.jplus.pojo.basisInfo.Jbxx;
import org.jplus.pojo.checkgzl.Checkgzl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:审核本院工作量1服务层接口实现
 * @author:zmj
 * @date 2019/11/1618:42
 */
@Service
public class OfficecollegeServiceImpl implements OfficecollegeService{
    @Autowired
    private CheckgzlMapper checkgzlMapper;

    public String getYxmc(String gh) {
        return checkgzlMapper.getYxByGh(gh);
    }

    public List<Checkgzl> getCheckgzlInf(String gh) {
        List<Checkgzl> checkgzlArrayList = new ArrayList<>();

        List<Users> userList = checkgzlMapper.getAllGhAndUname(gh);
        Jbxx allJbxx = checkgzlMapper.getAllJbxx("");


        Checkgzl checkgzl = null;
        for (Users user:userList) {
            checkgzl = new Checkgzl();
            //设置工号
           checkgzl.setGh(user.getGh());
           //设置姓名
           checkgzl.setUname(user.getUname());
           //设置职务
            if (checkgzlMapper.getAllJbxx(user.getGh()) != null && checkgzlMapper.getAllJbxx(user.getGh()).getZwbm() != null) {
                checkgzl.setZw(checkgzlMapper.getZwByZwbm(checkgzlMapper.getAllJbxx(user.getGh()).getZwbm().getZwbm()));
            }else{
                checkgzl.setZw("");
            }

           //设置额定工作量
            if (checkgzlMapper.getAllJbxx(user.getGh()) != null && checkgzlMapper.getAllJbxx(user.getGh()).getEdgzl() != null)
           checkgzl.setEdgzl(checkgzlMapper.getAllJbxx(user.getGh()).getEdgzl());
            else{
                checkgzl.setEdgzl(0);
            }

           //设置本科生教学
            if (checkgzlMapper.getBksSumGzl(user.getGh()) != null)
           checkgzl.setBksgzl(checkgzlMapper.getBksSumGzl(user.getGh()));
            else{
                checkgzl.setBksgzl(0);
            }

           //设置研究生教学
            if (checkgzlMapper.getYjsSumGzl(user.getGh()) != null)
           checkgzl.setYjsgzl(checkgzlMapper.getYjsSumGzl(user.getGh()));
            else{
                checkgzl.setYjsgzl(0);
            }

           //设置总工作量
            if (checkgzlMapper.getBksSumGzl(user.getGh()) != null && checkgzlMapper.getYjsSumGzl(user.getGh()) != null)
                checkgzl.setAllgzl(checkgzlMapper.getBksSumGzl(user.getGh()) + checkgzlMapper.getYjsSumGzl(user.getGh()));
            else{
                checkgzl.setAllgzl(0);
            }
           //设置审核状态
            if (checkgzlMapper.getTjztAndShzt(user.getGh()) != null && checkgzlMapper.getTjztAndShzt(user.getGh()).getTjzt() == 1) {
                checkgzl.setShzt(checkgzlMapper.getTjztAndShzt(user.getGh()).getShzt());
            }else {
                checkgzl.setShzt(4);
            }
            //放入checkgzl对象
            checkgzlArrayList.add(checkgzl);
        }
//        for ( Checkgzl checkgzl1 : checkgzlArrayList) {
//            System.out.println(checkgzl1);
//        }
        return checkgzlArrayList;
    }
}
