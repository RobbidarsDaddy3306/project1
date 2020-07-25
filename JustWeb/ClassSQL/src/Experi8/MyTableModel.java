package Experi8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class MyTableModel extends DefaultTableModel {

    private ArrayList<Integer> editedIndex = new ArrayList<Integer>();

    public MyTableModel(){
        super();
    }

    //设置表格模型第一列不能修改
    public boolean isCellEditable(int row,int column){
        if(column == 0){
            return false;
        }else {
            return true;
        }
    }

    //表格模型数据修改后 记录其行号
    public void setValueAt(Object aValue,int row,int column){
        super.setValueAt(aValue,row,column);
        int i;
        int count = editedIndex.size();
        if(count == 0){
            editedIndex.add(row);
        }else {
            for(i=0;i<count;i++){
                if(editedIndex.get(i).intValue()>row){
                    editedIndex.add(i+1,row);
                    break;
                }
            }
            if(i>=count){
                editedIndex.add(row);
            }
        }
    }

    //获取表格模型修改的数据行号列表
    public ArrayList<Integer> getEditedIndex(){
        return editedIndex;
    }

}
