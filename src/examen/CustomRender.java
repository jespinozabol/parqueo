/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author jeez
 */
class CustomRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected) {
            table.clearSelection();
        } else {
            setBackground(table.getBackground());
            try {
                if (table.getValueAt(row, column).equals("Ocupado")) {
                    setBackground(Color.RED);
                } else {
                    setBackground(Color.GREEN);
                }
            } catch (Exception e) {
            }
        }

        return this;
    }

}
