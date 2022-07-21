package cn.com.yusys.yscrm.pcrm.common.util;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.List;

public class ExcelFillCellMergeStrategy implements CellWriteHandler {
    private int[] mergeColumnIndex;

    private int mergeRowIndex;

    public ExcelFillCellMergeStrategy(int[] mergeColumnIndex, int mergeRowIndex) {
        this.mergeColumnIndex = mergeColumnIndex;
        this.mergeRowIndex = mergeRowIndex;
    }

    public ExcelFillCellMergeStrategy() {
    }

    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer integer, Integer integer1, Boolean aBoolean) {

    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer integer, Boolean aBoolean) {

    }

    @Override
    public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, Cell cell, Head head, Integer integer, Boolean aBoolean) {
        Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setWrapText(true);
        cell.setCellStyle(cellStyle);
    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> list, Cell cell, Head head, Integer integer, Boolean aBoolean) {
        int curRowIndex = cell.getRowIndex();
        int curColIndex = cell.getColumnIndex();
        if (curRowIndex > mergeRowIndex){
            for (int i = 0; i < mergeColumnIndex.length; i++){
                if (curColIndex == mergeColumnIndex[i]){
                    mergeWithPreRow(writeSheetHolder,cell,curColIndex,curRowIndex);
                }
            }
        }
    }

    private void mergeWithPreRow(WriteSheetHolder writeSheetHolder, Cell cell, int curColIndex, int curRowIndex) {
        Cell curCell = cell.getSheet().getRow(curRowIndex).getCell(0);
        Object curData = curCell.getCellTypeEnum() == CellType.STRING ? curCell.getStringCellValue() : curCell.getNumericCellValue();
        Cell preCell = cell.getSheet().getRow(curRowIndex-1).getCell(0);
        Object preData = preCell.getCellTypeEnum() == CellType.STRING ? preCell.getStringCellValue() : preCell.getNumericCellValue();
        if (curData.equals(preData)){
            Sheet sheet = writeSheetHolder.getSheet();
            List<CellRangeAddress> mergeRegions = sheet.getMergedRegions();
            Boolean isMerged = false;
            for (int i = 0; i < mergeRegions.size(); i++) {
                CellRangeAddress cellRangeAddress = mergeRegions.get(i);
                if (cellRangeAddress.isInRange(curRowIndex-1,curColIndex)){
                    sheet.removeMergedRegion(i);
                    cellRangeAddress.setLastRow(curRowIndex);
                    sheet.addMergedRegion(cellRangeAddress);
                    isMerged = true;
                    break;
                }
            }
            if (!isMerged){
                CellRangeAddress cellRangeAddress = new CellRangeAddress(curRowIndex-1,curRowIndex,curColIndex,curColIndex);
                sheet.addMergedRegion(cellRangeAddress);
            }
        }
    }
}
