/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.libman.netbeans;

import GUI.fk;
import javax.swing.UIManager;

/**
 *
 * @author Nam
 */
public class LibManNetbeans {

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        javax.swing.SwingUtilities.invokeLater(() -> new fk().setVisible(true));
    }
}
