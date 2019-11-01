package org.jplus.controller;

import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.bks.Bkssjjx;
import org.jplus.service.BkssjjxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

/**
 * @author imlgw.top
 * @date 2019/10/30 16:11
 */

@Controller
public class BkssjjxController {

    @Autowired
    private BkssjjxService bkssjjxService;

    @RequestMapping("/saveBkssjjx")
    @NeedLogin
    public void insertTest(@RequestBody Bkssjjx bkssjjxVo){
        bkssjjxService.insertBkssjjx(bkssjjxVo);
    }

    @RequestMapping("/practiceteh") //本科生实践教学入口
    @NeedLogin
    public String bkssjjx(Model model, Users user){ //User由参数解析器自动注入
        Optional.ofNullable(bkssjjxService.selectSxlx()).ifPresent( sxlx-> model.addAttribute("sxlxlist",sxlx));
        Optional.ofNullable(bkssjjxService.selectZylxbm()).ifPresent(zybm-> model.addAttribute("zylxlist",zybm));
        Optional.ofNullable(bkssjjxService.selectBkssjjx(user.getGh())).ifPresent(bkssjjx -> model.addAttribute("bkssjjx",bkssjjx));
        //System.err.println(user);
        //System.err.println(bkssjjxService.selectBkssjjx(user.getGh()));
        return "practicalteaching";
    }
}
