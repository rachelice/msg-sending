package com.sunshineroad.framework.util;

import java.util.WeakHashMap;

/**
 * omplatformNew
 * com.sunshineroad.framework.util
 * @{#} KeySynchronizer.java Create on  2013-6-13 上午9:10:22
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:xxxxxx">xxxxxx</a>
 * @version 1.0
 * 功能说明：同步器
 *
 */

public class KeySynchronizer {
    
    private static final WeakHashMap<Object, Locker> LOCK_MAP = new WeakHashMap<Object, Locker>();
    
    private static class Locker {
        private Locker() {
            
        }
    }
    
    
    public static synchronized Object acquire(Object key) {
        Locker locker = LOCK_MAP.get(key);
        if(locker == null) {
            locker = new Locker();
            LOCK_MAP.put(key, locker);
        }
        return locker;
    }
}
