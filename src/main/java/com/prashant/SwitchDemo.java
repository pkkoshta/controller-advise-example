package com.prashant;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class SwitchDemo {
    public static void main(String[] args) {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        Integer result = switch (dayOfWeek){
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> {
                System.out.println("Hi week = " );
                yield 5;
            }
            case SATURDAY , SUNDAY-> {
                System.out.println("This is weekend");
                yield 10;
            }
            
        };
        System.out.println("result = " + result);

        Instant nowUtc = Instant.now();
        ZoneId asiaSingapore = ZoneId.of("Asia/Kolkata");
        System.out.println(ZoneId.getAvailableZoneIds());
        System.out.println(nowUtc.atZone(asiaSingapore));
    }
}
