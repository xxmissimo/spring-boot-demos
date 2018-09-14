package com.issimo.web.utils;

import java.util.UUID;

public class UUIDUtils {
	  public static String getUUID() {
		    return  UUID.randomUUID().toString().replaceAll("\\-", "");		
			}
	  
	  /**
	     * 获得8个长度的十六进制的UUID
	     * @return UUID
	     */
	    public static String get8UUID(){
	        UUID id=UUID.randomUUID();
	        String[] idd=id.toString().split("-");
	        return idd[0];
	    }
}
