package com.muhammet;

import java.time.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        /**
         * 1- kullanıcıların yada müşterilerin doğum tarihleri
         * 2- ürünlerin skt leri
         * 3- kayıt ettiğimiz verilerin oluşturulma ve güncellenme zamanları
         * gibi pek çok dataya ait zaman tutma ihtiyacımız bulunmaktadır.
         * Zaman damgası içi Long kullanımı yaygındır.
         * createDate  -> Long ->  01.01.1970 tarihini başlangıç kabul ederek
         * o zamandan şuanki zamana kadar olan süreyi long olarak hesaplamaktadır.
         * 1000ms   -> 1sn
         * 60sn     -> 1dk
         * 60dk     -> 1sa
         * 24sa     -> 1d
         * static final Long 3d = 1000L*60*60*24*3;
         * şuan ın zamanı -> System.currentTimeMillis();
         */
        System.out.println("Suanki zaman....: "+ System.currentTimeMillis());
        /**
         * Date -> tarih
         * Date kullanımı java artık tarih olmak üzere, birçok method
         * u kullanılamayacak.
         *    @Deprecated -> bir method un ilerleyen java versiyonlarınde
         *    desteklanmeyeceğini anlatır. böyle bir durumda ilerleyen
         *    zamanlarda java versiyonunuzu günceller iseniz uygulamanız
         *    çalışmayacaktır. DAte olarak kullandığınız tüm kodları
         *    değiştirmek zorunda kalacaksınız demektir.
         */
        Date date = new Date();
        System.out.println("Tarih....: "+ date); // Tue Jan 03 09:48:15 TRT 2023
        System.out.println("Tarih....: "+ date.getTime()); //1672728495537
        System.out.println("Tarih....: "+ date.getDate()); //3
        System.out.println("Tarih....: "+ date.getYear()); // 2023

        /**
         * LocalDate, LocalTime, LocalDateTime, ZonedDateTime
         */
        System.out.println("Local Date....: "+ LocalDate.now());
        System.out.println("Local Time....: "+ LocalTime.now());
        System.out.println("Local DateTime....: "+ LocalDateTime.now());
        System.out.println("Atomik Zaman.....: "+ System.nanoTime());
        /**
         * LocalDate -> of(year,month,day)
         * LocalTime -> of(hour,minute,second,nanotime->(,000000000))
         */
        LocalDate localDate = LocalDate.of(2025,5,22);
        localDate = LocalDate.of(2033, Month.NOVEMBER,6);
        System.out.println("Elle Zaman Tanımlama....: "+localDate.toString());
        LocalTime localTime = LocalTime.of(5,25,58,504441111);
        System.out.println("Local Time.....: "+ localTime.toString());
        ZonedDateTime zonedDateTime = ZonedDateTime
                .of(2023,1,3,
                    10,15,36,221111,
                        ZoneId.of("Europe/London"));
        System.out.println(ZonedDateTime.now());
        System.out.println(zonedDateTime);
        /**
         * Kullandığımız uygulamalarda, zaman için en uygun kullanımı
         * ZoneId yi ihtiyacımıza göre belirleyip kullanmaktır.
         */
        System.out.println("lond...: "+ZonedDateTime.now(ZoneId.of("Europe/London")));
        System.out.println("ist....: "+ZonedDateTime.now(ZoneId.of("Europe/Istanbul")));

        /**
         * LocalDate, Time Manipülasyonları ve Period Kullanımı
         */
        LocalDate localDate1 = LocalDate.now();
        System.out.print("Gün olarak 10 gün sonrası....: ");
        System.out.println(localDate1.plusDays(10));
        System.out.print("hafta olarak 2 hafta sonrası....: ");
        System.out.println(localDate1.plusWeeks(2));
        System.out.print("ay olarak 2 ay öncesi...: ");
        System.out.println(localDate1.minusMonths(2));

        /**
         * eklenilecek zaman dilimi, gün-ay-hafta-yıl v.s olabiliyorken her işlem
         * için ayrı ayrı kontrol sağlama gerekecek.
         * DİKKAT!!!!
         * mevcut zamana ait işlemlerde, plus, minus v.s.
         * hiç birisi zamanı değiştirmez. sadece işlem yapıldığı method eklediği
         * yada çıkarttığı zamanı döner.
         */
        Period period = Period.ofWeeks(6);
        System.out.println("Mevcut date...: "+ localDate1);
        System.out.println("period kullanımı....: "+localDate1.plus(period));
        System.out.println("Mevcut date...: "+ localDate1);
        localDate1 = localDate1.plus(period);
        System.out.println("Mevcut date...: "+ localDate1);

        /**
         * Zamanı takip etmek
         *
         */
        Long start_ms = System.currentTimeMillis();
        Long start_nn = System.nanoTime();
        Instant start_ins = Instant.now();
        long toplam =0;
        for(long i=0;i<20_000_000_000l;i++){
            toplam++;
        }
        System.out.println("Toplam....: "+ toplam);
        Long end_ms = System.currentTimeMillis();
        Long end_nn = System.nanoTime();
        Instant end_ins = Instant.now();
        System.out.println("Milisaniye....: "+ (end_ms-start_ms));
        System.out.println("Nanosaniye....: "+ (end_nn-start_nn));
        Duration duration = Duration.between(start_ins,end_ins);
        //System.out.println("INst Mili....: "+ duration.getSeconds());
        //System.out.println("INst Nano....: "+ duration.getNano());
        System.out.println("INst Mili....: "+ duration.toMillis());
        System.out.println("INst Nano....: "+ duration.toNanos());





    }
}