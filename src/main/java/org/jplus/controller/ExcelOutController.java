package org.jplus.controller;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jplus.interceptor.NeedLogin;
import org.jplus.mapper.TjbMapper;
import org.jplus.pojo.Tjzt.Tjb;
import org.jplus.pojo.Tjzt.Tjzt;
import org.jplus.service.TjbService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.controller
 * @Author: lzh
 * @CreateTime: 2019/11/26
 * @Description: Description
 */
@Controller
public class ExcelOutController {

    @Autowired
    private TjbService tjbService;

    @NeedLogin
    @RequestMapping("excelOut")
    public void excleOut(HttpServletRequest request, HttpServletResponse response){

        List<Tjb> tjbs = tjbService.getAllTjb();
        /*创建Excel*/
        HSSFWorkbook sheets = new HSSFWorkbook();
        /*填充颜色*/
        //HSSFCellStyle cellStyle = sheets.createCellStyle();
        /*改变字体*/
        /*HSSFFont font = sheets.createFont();
        font.setFontHeight((short) 20);
        font.setBold(true);
        cellStyle.setFont(font);*/

        HSSFSheet workLoad = sheets.createSheet("workLoad");
        HSSFRow row = workLoad.createRow(0);
        row.setHeightInPoints(30);
        HSSFCell cell = row.createCell(0);
        HSSFCellStyle cellStyle = sheets.createCellStyle();
        //cellStyle.set

        /*

        row.createCell(0).setCellValue("工号");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("职务");
        row.createCell(3).setCellValue("本科生课堂教学");
        row.createCell(4).setCellValue("本科生实践教学");
        row.createCell(5).setCellValue("本科生质量工程建设");
        row.createCell(6).setCellValue("本科生教学研究");
        row.createCell(7).setCellValue("本科生其他");
        row.createCell(8).setCellValue("研究生课堂教学");
        row.createCell(9).setCellValue("研究生实践教学");
        row.createCell(10).setCellValue("研究生学科建设");
        row.createCell(11).setCellValue("研究生教研项目");
        row.createCell(12).setCellValue("研究生竞赛获奖");
        row.createCell(13).setCellValue("研究生其他");
        row.createCell(14).setCellValue("本科生最低授课");
        row.createCell(15).setCellValue("额定教学工作量");
        row.createCell(16).setCellValue("实际教学工作量");
        row.createCell(17).setCellValue("本科生授课未完成");
        row.createCell(18).setCellValue("额定教学未完成");

        */
        HSSFRow workLoadRow = null;
        /*取出数据*/
        for (int i = 0 ; i<tjbs.size();i++){
            Tjb tjb = tjbs.get(i);
            workLoadRow = workLoad.createRow(i + 1);
            workLoadRow.createCell(0).setCellValue(tjb.getNd());
            workLoadRow.createCell(1).setCellValue(tjb.getXm());
            workLoadRow.createCell(2).setCellValue(tjb.getZw());
            workLoadRow.createCell(2).setCellValue(tjb.getBksktgzl());
            workLoadRow.createCell(2).setCellValue(tjb.getBkssjgzl());
            workLoadRow.createCell(2).setCellValue(tjb.getZlgcgzl());
        }
        /*响应给浏览器*/
        try {
            String fileName = new String("工作量.xls".getBytes("utf-8"), "iso8859-1");
            response.setHeader("content-Disposition", "attachment;fileName="+fileName);
            sheets.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
