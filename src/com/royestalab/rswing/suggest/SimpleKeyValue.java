/* SimpleKeyValue.java
 * 
 * Copyright(c) 2016. RoyestaLab.Com. All Rights Reserved.
 * This software is the proprientary information of Royesta Lab.
 */

package com.royestalab.rswing.suggest;

/**
 * Simple Key Value
 * 
 * @author Roy Royesta Pampey (royroyesta54@gmail.com)
 * @author ocol
 */
public class SimpleKeyValue {
    
    public final String KEY, VALUE;
    public SimpleKeyValue(String key, String value){
        this.KEY = key;
        this.VALUE = value;
    }

    @Override
    public String toString(){
        return VALUE;
    }
    
}
