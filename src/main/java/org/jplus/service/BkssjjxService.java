package org.jplus.service;

import org.jplus.pojo.bks.Bkssjjx;
import org.jplus.pojo.bks.Sxlx;
import org.jplus.pojo.bks.Zylxbm;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author imlgw.top
 * @date 2019/10/30 16:09
 */
@Service
public interface BkssjjxService {

    int insertBkssjjx(Bkssjjx bkssjjx);

    Bkssjjx selectBkssjjx(String gh);

    List<Sxlx> selectSxlx();

    List<Zylxbm> selectZylxbm();
}
