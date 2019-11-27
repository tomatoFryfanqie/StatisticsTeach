package org.jplus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.jplus.pojo.Tjzt.Tjb;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author imlgw.top
 * @date 2019/11/19 17:34
 */
@Component
public interface TjbMapper {


    List<Tjb> getAllTjb();
}
