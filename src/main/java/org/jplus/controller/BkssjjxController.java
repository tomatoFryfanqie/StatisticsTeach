package org.jplus.controller;

import org.jplus.dto.BkssjjxEx;
import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Users;
import org.jplus.pojo.bks.Bkssjjx;
import org.jplus.service.BkssjjxService;
import org.jplus.service.TjztService;
import org.jplus.utils.GetYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
import static org.jplus.utils.GetWorkLoad.getSjjxWork;


@Controller
public class BkssjjxController {

    @Autowired
    private BkssjjxService bkssjjxService;

    @Autowired
    private TjztService tjztService;

    @RequestMapping("/saveBkssjjx")
    @NeedLogin
    public String insertTest(@ModelAttribute(value = "bkssjjxVo") Bkssjjx bkssjjxVo, Users users,Model model){
        if (tjztService.getTjzt(users.getGh()).getTjzt() == 0) {
            bkssjjxVo.setGh(users.getGh());
            if (bkssjjxVo.getGzl() == null) {
                BkssjjxEx sjjxWork = getSjjxWork(bkssjjxVo);
                bkssjjxVo.setNd(GetYear.getYears());
                bkssjjxVo.setGzl(sjjxWork.getGzl());
                bkssjjxService.insertBkssjjx(bkssjjxVo);
            } else {
                BkssjjxEx sjjxWork = getSjjxWork(bkssjjxVo);
                bkssjjxVo.setNd(GetYear.getYears());
                bkssjjxVo.setGzl(sjjxWork.getGzl());
                bkssjjxService.updateBkssjjx(bkssjjxVo);
            }
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
        model.addAttribute("hidden",tjztService.getTjzt(user.getGh()).getTjzt());
        /*BkssjjxEx sjjxWork = getSjjxWork(bkssjjxService.selectBkssjjx(user.getGh()));
        Optional.ofNullable(sjjxWork).ifPresent(bkssjjx -> model
                .addAttribute
                ("bkssjjx",bkssjjx));*/
        return "practicalteaching";
    }
}
