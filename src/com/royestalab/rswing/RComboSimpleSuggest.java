/* RComboSimpleSuggest.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */
package com.royestalab.rswing;

import com.royestalab.rswing.suggest.AutoSuggest;
import com.royestalab.rswing.suggest.AutoSuggestListener;

/**
 * JCombo with simple suggest
 *
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class RComboSimpleSuggest extends AutoSuggest implements AutoSuggestListener {

    private String[] dataItems;

    public RComboSimpleSuggest() {
        super();

        setListener(this);
    }

    /**
     * Set Data Items.
     * example:
     * <code>
     * RComboSimpleSuggest comboSuggest = new RComboSimpleSuggest();
     * 
       comboSuggest.setDataItems("belajar,coba,kenapa,apa,semangat,anu", ",");
     * </code>
     * 
     * @param dataItem
     * @param separator 
     */
    public void setDataItems (String dataItem, String separator) {
        this.dataItems = dataItem.split(separator);
        
        String data;
        for (int i = 0; i < dataItems.length; i++) {
            data = dataItems[i];
            addItem(data);
        }
        
    }

    @Override
    public void filter(AutoSuggest c, String s) {
        c.removeAllItems();
        String data;
        for(int i = 0; i < dataItems.length; i++){
            data = dataItems[i];
            // kita hanya memeriksa apakah kata yang diketik adalah awal kata dari buah
            if(data.toString().trim().toLowerCase().contains(s.toLowerCase())){
                c.addItem(data);
            }
        }
    }

    @Override
    public Object getSelectedObject(Object c) {
        return c;
    }

}
