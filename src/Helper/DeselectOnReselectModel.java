/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import javax.swing.DefaultListSelectionModel;

/**
 *
 * @author sphal
 */
public class DeselectOnReselectModel extends DefaultListSelectionModel {
     @Override
     public void setSelectionInterval(int index0, int index1) {
         if (isSelectedIndex(index0)) {
             super.clearSelection();
         } else {
             super.setSelectionInterval(index0, index1);
         }
     }
}
