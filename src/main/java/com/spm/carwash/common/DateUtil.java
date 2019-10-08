package com.spm.carwash.common;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 8/10/19
 */
public class DateUtil {
    public static Date String2Date(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(str, pos);
    }

    public static List<String> times = new ArrayList<>();
}
