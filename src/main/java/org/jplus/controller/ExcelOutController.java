package org.jplus.controller;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.jplus.interceptor.NeedLogin;
import org.jplus.pojo.Tjzt.Tjb;
import org.jplus.pojo.Users;
import org.jplus.pojo.basisInfo.Yxbm;
import org.jplus.service.TjbService;
import org.jplus.utils.GetWorkLoad;
import org.jplus.utils.GetYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
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

    /*导出全校*/
    @NeedLogin
    @RequestMapping("QXexcelOut")
    public void QXexcelOut(HttpServletRequest request, HttpServletResponse response, Users users) {
        /*创建Excel*/
        HSSFWorkbook sheets = new HSSFWorkbook();
        HSSFCellStyle cellStyle = sheets.createCellStyle();
        HSSFFont font = sheets.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints((short) 10);
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());

        HSSFCellStyle cellStyle1 = sheets.createCellStyle();
        HSSFFont font1 = sheets.createFont();
        font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font1.setFontHeightInPoints((short) 20);
        cellStyle1.setFont(font1);
        cellStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        HSSFSheet workLoad = sheets.createSheet("workLoad");
        HSSFRow row = workLoad.createRow(0);
        HSSFCell cell = row.createCell(0);
        CellRangeAddress cellRangeAddress1 = new CellRangeAddress(0, 2, 0, 20);
        workLoad.addMergedRegion(cellRangeAddress1);
        cell.setCellStyle(cellStyle1);
        cell.setCellValue("湖北师范大学"+ GetYear.getYears() +"度教师教学工作量统计表");

        HSSFRow row_0 = workLoad.createRow(3);
        HSSFCell cell_0 = row_0.createCell(0);
        cell_0.setCellValue("院系");
        CellRangeAddress cellRangeAddress = new CellRangeAddress(3, 4, 0, 0);
        workLoad.addMergedRegion(cellRangeAddress);
        cell_0.setCellStyle(cellStyle);

        HSSFCell cell_1 = row_0.createCell(1);
        cell_1.setCellValue("工号");
        CellRangeAddress cellAddresses_1 = new CellRangeAddress(3, 4, 1, 1);
        workLoad.addMergedRegion(cellAddresses_1);
        cell_1.setCellStyle(cellStyle);

        /*前面有改动 这里随便写了 呜呜呜*/
        HSSFCell cell_100 = row_0.createCell(2);
        cell_100.setCellValue("姓名");
        CellRangeAddress cellAddresses_100 = new CellRangeAddress(3, 4, 2, 2);
        workLoad.addMergedRegion(cellAddresses_100);
        cell_100.setCellStyle(cellStyle);

        HSSFCell cell_2 = row_0.createCell(3);
        cell_2.setCellValue("职务");
        CellRangeAddress cellAddresses_2 = new CellRangeAddress(3, 4, 3, 3);
        workLoad.addMergedRegion(cellAddresses_2);
        cell_2.setCellStyle(cellStyle);

        HSSFCell cell_3 = row_0.createCell(4);
        cell_3.setCellValue("本科生教学工作量");
        CellRangeAddress cellAddresses_3 = new CellRangeAddress(3, 3, 4, 9);
        workLoad.addMergedRegion(cellAddresses_3);
        cell_3.setCellStyle(cellStyle);

        HSSFCell cell_4 = row_0.createCell(10);
        cell_4.setCellValue("研究生教学工作量");
        CellRangeAddress cellAddresses_4 = new CellRangeAddress(3, 3, 10, 15);
        workLoad.addMergedRegion(cellAddresses_4);
        cell_4.setCellStyle(cellStyle);

        HSSFCell cell_5 = row_0.createCell(16);
        cell_5.setCellValue("本科生最低授课");
        CellRangeAddress cellAddresses_5 = new CellRangeAddress(3, 4, 16, 16);
        workLoad.addMergedRegion(cellAddresses_5);
        cell_5.setCellStyle(cellStyle);

        HSSFCell cell_6 = row_0.createCell(17);
        cell_6.setCellValue("额定教学工作量");
        CellRangeAddress cellAddresses_6 = new CellRangeAddress(3, 4, 17, 17);
        workLoad.addMergedRegion(cellAddresses_6);
        cell_6.setCellStyle(cellStyle);

        HSSFCell cell_7 = row_0.createCell(18);
        cell_7.setCellValue("实际教学工作量");
        CellRangeAddress cellAddresses_7 = new CellRangeAddress(3, 4, 18, 18);
        workLoad.addMergedRegion(cellAddresses_7);
        cell_7.setCellStyle(cellStyle);

        HSSFCell cell_8 = row_0.createCell(19);
        cell_8.setCellValue("本科生授课未完成");
        CellRangeAddress cellAddresses_8 = new CellRangeAddress(3, 4, 19, 19);
        workLoad.addMergedRegion(cellAddresses_8);
        cell_8.setCellStyle(cellStyle);

        HSSFCell cell_9 = row_0.createCell(20);
        cell_9.setCellValue("额定教学未完成");
        CellRangeAddress cellAddresses_9 = new CellRangeAddress(3, 4, 20, 20);
        workLoad.addMergedRegion(cellAddresses_9);
        cell_9.setCellStyle(cellStyle);

        HSSFRow row_1 = workLoad.createRow(4);
        HSSFCell cell_13 = row_1.createCell(4);
        cell_13.setCellValue("课堂教学");
        cell_13.setCellStyle(cellStyle);

        HSSFCell cell_14 = row_1.createCell(5);
        cell_14.setCellValue("实践教学");
        cell_14.setCellStyle(cellStyle);

        HSSFCell cell_15 = row_1.createCell(6);
        cell_15.setCellValue("质量工程建设");
        cell_15.setCellStyle(cellStyle);

        HSSFCell cell_16 = row_1.createCell(7);
        cell_16.setCellValue("教学研究");
        cell_16.setCellStyle(cellStyle);

        HSSFCell cell_17 = row_1.createCell(8);
        cell_17.setCellValue("竞赛获奖");
        cell_17.setCellStyle(cellStyle);

        HSSFCell cell_18 = row_1.createCell(9);
        cell_18.setCellValue("其他");
        cell_18.setCellStyle(cellStyle);

        HSSFCell cell_19 = row_1.createCell(10);
        cell_19.setCellValue("课堂教学");
        cell_19.setCellStyle(cellStyle);

        HSSFCell cell_110 = row_1.createCell(11);
        cell_110.setCellValue("实践教学");
        cell_110.setCellStyle(cellStyle);

        HSSFCell cell_111 = row_1.createCell(12);
        cell_111.setCellValue("学科建设");
        cell_111.setCellStyle(cellStyle);

        HSSFCell cell_112 = row_1.createCell(13);
        cell_112.setCellValue("教研项目");
        cell_112.setCellStyle(cellStyle);

        HSSFCell cell_113 = row_1.createCell(14);
        cell_113.setCellValue("竞赛获奖");
        cell_113.setCellStyle(cellStyle);

        HSSFCell cell_114 = row_1.createCell(15);
        cell_114.setCellValue("其他");
        cell_114.setCellStyle(cellStyle);

        HSSFRow workLoadRow = null;


        /*取出数据*/
        List<Tjb> tjbs = null;
        if(users.getActor()==2){

             tjbs = tjbService.getAllTjbByYxbm(users.getYxbm());
        }else {
             tjbs = tjbService.getAllTjb();
        }
        for (int i = 0; i < tjbs.size(); i++) {
            Tjb tjb = tjbs.get(i);
            workLoadRow = workLoad.createRow(i + 5);
            /*院系*/
            workLoadRow.createCell(0).setCellValue(tjb.getYxmc());
            /*工号*/
            workLoadRow.createCell(1).setCellValue(tjb.getGh());
            /*姓名*/
            workLoadRow.createCell(2).setCellValue(tjb.getXm());
            /*职务*/
            workLoadRow.createCell(3).setCellValue(tjb.getZw());
            /*本科生课堂教学*/
            workLoadRow.createCell(4).setCellValue(tjb.getBksktgzl());
            /*本科生实践教学*/
            workLoadRow.createCell(5).setCellValue(tjb.getBkssjgzl());
            /*本科生质量工程*/
            workLoadRow.createCell(6).setCellValue(tjb.getZlgcgzl());
            /*本科生教学研究*/
            workLoadRow.createCell(7).setCellValue(tjb.getJxcggzl() + tjb.getBkszxxmgzl() + tjb.getBkshxxmgzl() + tjb.getJcgzl() + tjb.getJxgggzl());
            /*本科生教学知识竞赛*/
            workLoadRow.createCell(8).setCellValue(tjb.getBksjsgzl() + tjb.getJsjsgzl() + tjb.getBkslwgzl());
            /*本科生其他*/
            workLoadRow.createCell(9).setCellValue(tjb.getBksqtgzl());
            /*研究生课堂教学*/
            workLoadRow.createCell(10).setCellValue(tjb.getYjsktjxgzl());
            /*研究生实践教学*/
            //workLoadRow.createCell(10).setCellValue(tjb.getYjssjjxgzl());
            workLoadRow.createCell(11).setCellValue(tjb.getJsjsjjxgzl());
            /*研究生学科建设*/
            workLoadRow.createCell(12).setCellValue(tjb.getXkjsgzl());
            /*研究生教研项目*/
            workLoadRow.createCell(13).setCellValue(tjb.getYjsjyxmgzl() + tjb.getYjshxxmgzl());
            /*研究生竞赛与论文*/
            /*差一个竞赛*/
            workLoadRow.createCell(14).setCellValue(tjb.getYjslwgzl());
            /*研究生其他*/
            workLoadRow.createCell(15).setCellValue(tjb.getYjsqtgzl());
            /*本科生最低授课*/
            workLoadRow.createCell(16).setCellValue(tjb.getBkszdsk());
            /*额定工作量*/
            workLoadRow.createCell(17).setCellValue(tjb.getEdgzl());
            /*实际教学工作量*/
            workLoadRow.createCell(18).setCellValue(tjb.getSjjxgzl());
            /*本科生授课未完成*/
            workLoadRow.createCell(19).setCellValue(tjb.getBksskwwc());
            /*额定未完成*/
            workLoadRow.createCell(20).setCellValue(tjb.getEdjxwwc());
        }
        /*响应给浏览器*/
        try {
            String fileName = new String("工作量.xls".getBytes("utf-8"), "iso8859-1");
            response.setHeader("content-Disposition", "attachment;fileName=" + fileName);
            sheets.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
