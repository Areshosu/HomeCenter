/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author sphal
 */
public class TableActionCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel rendererComponent = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        rendererComponent.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/images/delete.png"));
        rendererComponent.setText(null);
        rendererComponent.setHorizontalAlignment(SwingConstants.CENTER);
        rendererComponent.setVerticalAlignment(SwingConstants.CENTER);
        
        return rendererComponent;
    }
}
