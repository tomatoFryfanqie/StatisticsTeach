package org.jplus.service;

import org.jplus.mapper.CheckgzlMapper;
import org.jplus.pojo.checkgzl.Checkgzl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        //先查询到所有该院系的工号，职务编码和额定工作量
        List<Map<String,Object>> mapList = checkgzlMapper.getAllJbxx(gh);

        //定义上面三列的List集合
        List<String> ghList = new ArrayList<>();
        List<Integer> zwbmList = new ArrayList<>();
        List<Float> edgzlList = new ArrayList<>();

        //对三列赋值
        for (Map<String,Object> map:mapList) {
            ghList.add((String)map.get("gh"));
            zwbmList.add((Integer) map.get("zwbm"));
            edgzlList.add((Float)map.get("edgzl"));
        }
        Checkgzl checkgzl = new Checkgzl();
        for (int i = 0;i < ghList.size();i++) {
            //工号放入对象集合
                checkgzl.setGh(ghList.get(i));

            //姓名放入对象集合
                checkgzl.setUname(checkgzlMapper.getAllUname(ghList).get(i));

            //职务放进对象集合
                checkgzl.setZw(checkgzlMapper.getAllZw(zwbmList).get(i));
            //额定工作量放入集合
                checkgzl.setEdgzl(edgzlList.get(i));
            //本科生工作量总和放入集合
                checkgzl.setBksgzl(checkgzlMapper.getBksSumGzl(ghList).get(i));
            //研究生工作量总和放入集合
                checkgzl.setYjsgzl(checkgzlMapper.getYjsSumGzl(ghList).get(i));
            //本科生和研究生总和放入集合
                checkgzl.setAllgzl(checkgzlMapper.getBksSumGzl(ghList).get(i) + checkgzlMapper.getYjsSumGzl(ghList).get(i)                     );
            //提交状态放入对象集合
                checkgzl.setShzt(checkgzlMapper.getAllTjzt(ghList).get(i));

            checkgzlArrayList.add(checkgzl);
        }
        return checkgzlArrayList;
    }
}
