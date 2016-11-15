/* RLabel.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing;

import com.royestalab.rswing.utility.RImageEfek;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Label dengan efek glass pada icon
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RLabel extends JLabel{
    
    public RLabel() {
        super();
    }
    
    @Override
   public void setIcon(Icon defaultIcon) {
       if (defaultIcon instanceof ImageIcon) {
           ImageIcon icon = (ImageIcon) defaultIcon;
           icon = new ImageIcon(RImageEfek.getMirrorEfect(icon.getImage()));
           super.setIcon(icon);
       } else {
           super.setIcon(defaultIcon);
       }
   }

}
