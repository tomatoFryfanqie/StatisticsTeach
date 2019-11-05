package org.jplus.controller;

import org.jplus.dto.BkssjjxEx;
import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.bks.Bkssjjx;
import org.jplus.service.BkssjjxService;
import org.jplus.utils.YearAndClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
import static org.jplus.utils.GetSjjxWork.getSjjxWork;

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
    public String insertTest(@Validated @ModelAttribute(value = "bkssjjxVo") Bkssjjx bkssjjxVo, Users users,Model model){
        bkssjjxVo.setGh(users.getGh());
        if (bkssjjxVo.getSjjxgzl()==null){
            BkssjjxEx sjjxWork = getSjjxWork(bkssjjxVo);
            bkssjjxVo.setNd(YearAndClass.getYears());
            bkssjjxVo.setSjjxgzl(sjjxWork.getSjjxgzl());
            bkssjjxService.insertBkssjjx(bkssjjxVo);
        }else {
            BkssjjxEx sjjxWork = getSjjxWork(bkssjjxVo);
            bkssjjxVo.setSjjxgzl(sjjxWork.getSjjxgzl());
            bkssjjxService.updateBkssjjx(bkssjjxVo);
        }
        return "redirect:/practiceteh";
    }

    @RequestMapping("/practiceteh") //本科生实践教学入口
    @NeedLogin
    public String bkssjjx(Model model, Users user){ //User由参数解析器自动注入
        Optional.ofNullable(bkssjjxService.selectSxlx()).ifPresent( sxlx-> model.addAttribute("sxlxlist",sxlx));
        Optional.ofNullable(bkssjjxService.selectZylxbm()).ifPresent(zybm-> model.addAttribute("zylxlist",zybm));
        Optional.ofNullable(bkssjjxService.selectBkssjjx(user.getGh())).ifPresent(sjjx->model.addAttribute
                ("bkssjjx",getSjjxWork(sjjx)));
        /*BkssjjxEx sjjxWork = getSjjxWork(bkssjjxService.selectBkssjjx(user.getGh()));
        Optional.ofNullable(sjjxWork).ifPresent(bkssjjx -> model
                .addAttribute
                ("bkssjjx",bkssjjx));*/
        return "practicalteaching";
    }
}
