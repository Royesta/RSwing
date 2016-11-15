/* AutoSuggestListener.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */
package com.royestalab.rswing.suggest;

/**
 * Interface untuk Listener Auto Suggest Combo
 * 
 * @author ocol
 */
public interface AutoSuggestListener {
    public abstract void filter(AutoSuggest c, String s);
    public abstract Object getSelectedObject(Object c);
}
