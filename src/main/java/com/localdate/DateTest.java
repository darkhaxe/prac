package com.localdate;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author haze
 * @date created at 2018/2/12 下午2:54
 */
public class DateTest {

    @Test
    public void date() {

        String datetime = "20140212111012";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime ldt = LocalDateTime.parse(datetime, dtf);
        System.out.println(ldt);
        DateTimeFormatter fa = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String datetime2 = ldt.format(fa);
        System.out.println(datetime2);

        System.out.println(LocalDateTime.now().format(fa));

    }

    //这两个方法使我们可以方便的实现将旧的日期类转换为新的日期类，具体思路都是通过Instant当中介，
    // 然后通过Instant来创建LocalDateTime（这个类可以很容易获取LocalDate和LocalTime），新的日期类转旧的也是如此，将新的先转成LocalDateTime，然后获取Instant，接着转成Date，具体实现细节如下：

    // 01. java.util.Date --> java.time.LocalDateTime
    public void UDateToLocalDateTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
    }

    // 02. java.util.Date --> java.time.LocalDate
    public void UDateToLocalDate() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
    }

    // 03. java.util.Date --> java.time.LocalTime
    public void UDateToLocalTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
    }


    // 04. java.time.LocalDateTime --> java.util.Date
    public void LocalDateTimeToUdate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
    }


    // 05. java.time.LocalDate --> java.util.Date
    public void LocalDateToUdate() {
        LocalDate localDate = LocalDate.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
    }

    // 06. java.time.LocalTime --> java.util.Date
    public void LocalTimeToUdate() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
    }

}
