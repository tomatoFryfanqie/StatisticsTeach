package org.jplus.service;

import org.jplus.pojo.bks.Bkssjjx;
import org.jplus.pojo.bks.Sxlx;
import org.jplus.pojo.bks.Zylxbm;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface BkssjjxService {

    int insertBkssjjx(Bkssjjx bkssjjx);

    Bkssjjx selectBkssjjx(String gh);

    List<Sxlx> selectSxlx();

    List<Zylxbm> selectZylxbm();

    void updateBkssjjx(Bkssjjx bkssjjxVo);

}
