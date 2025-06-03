package cn.lnd;

import java.math.BigDecimal;

/**
 * @Author lnd
 * @Description
 * @Date 2025/2/6 10:28
 */// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        BigDecimal res = new BigDecimal(200).multiply(new BigDecimal(100).divide(new BigDecimal(100)));
        System.out.println(res);
    }
}