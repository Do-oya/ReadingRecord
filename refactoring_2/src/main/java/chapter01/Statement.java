package chapter01;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class Statement {
    private Invoice invoice;
    private Map<String, Play> plays;

    public Statement(Invoice invoice, Map<String, Play> plays) {
        this.invoice = invoice;
        this.plays = plays;
    }

    public static String statement(Invoice invoice, Map<String, Play> plays) {
        double totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder(String.format("청구내역 (고객명: %s)\n", invoice.getCustomer()));

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        for (Invoice.Performance perf : invoice.getPerformances()) {
            Play play = playFor(plays, perf);
            double thisAmount = amountFor(perf, play);

            // 포인트 적립
            volumeCredits += Math.max(perf.getAudience() - 30, 0);

            // 희극 관객 5명마다 추가 포인트
            if ("comedy".equals(play.getType())) {
                volumeCredits += (int) Math.floor((double) perf.getAudience() / 5);
            }

            // 청구 내역 출력
            result.append(String.format("%s: %s %d석\n", play.getName(), formatter.format(thisAmount / 100), perf.getAudience()));
            totalAmount += thisAmount;
        }

        result.append(String.format("총액 %s\n", formatter.format(totalAmount / 100)));
        result.append(String.format("적립 포인트 %d점\n", volumeCredits));

        return result.toString();
    }

    private static Play playFor(Map<String, Play> plays, Invoice.Performance aPerformance) {
        return plays.get(aPerformance.getPlayID());
    }

    private static double amountFor(Invoice.Performance aPerformance, Play play) {
        double result = 0;

        switch (play.getType()) {
            case "tragedy":
                result = 40000;
                if (aPerformance.getAudience() > 30) {
                    result += 1000 * (aPerformance.getAudience() - 30);
                }
                break;

            case "comedy":
                result = 30000;
                if (aPerformance.getAudience() > 20) {
                    result += 10000 + 500 * (aPerformance.getAudience() - 20);
                }
                result += 300 * aPerformance.getAudience();
                break;

            default:
                throw new IllegalArgumentException("알 수 없는 장르: " + play.getType());
        }
        return result;
    }
}
