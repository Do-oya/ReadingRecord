package chapter01;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class Statement {
    private final Invoice invoice;
    private final Map<String, Play> plays;

    public Statement(Invoice invoice, Map<String, Play> plays) {
        this.invoice = invoice;
        this.plays = plays;
    }

    public String statement() {
        double totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder(String.format("청구내역 (고객명: %s)\n", invoice.getCustomer()));

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        for (Invoice.Performance perf : invoice.getPerformances()) {

            volumeCredits = volumnCreditsFor(perf, volumeCredits);

            // 청구 내역 출력
            result.append(String.format("%s: %s %d석\n", playFor(perf).getName(), formatter.format(amountFor(perf) / 100), perf.getAudience()));
            totalAmount += amountFor(perf);
        }

        result.append(String.format("총액 %s\n", formatter.format(totalAmount / 100)));
        result.append(String.format("적립 포인트 %d점\n", volumeCredits));

        return result.toString();
    }

    private int volumnCreditsFor(Invoice.Performance perf, int volumeCredits) {
        int result = 0;
        // 포인트 적립
        volumeCredits += Math.max(perf.getAudience() - 30, 0);

        // 희극 관객 5명마다 추가 포인트
        if ("comedy".equals(playFor(perf).getType())) {
            volumeCredits += (int) Math.floor((double) perf.getAudience() / 5);
        }
        return volumeCredits;
    }

    private Play playFor(Invoice.Performance aPerformance) {
        return plays.get(aPerformance.getPlayID());
    }

    private double amountFor(Invoice.Performance aPerformance) {
        double result = 0;

        switch (playFor(aPerformance).getType()) {
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
                throw new IllegalArgumentException("알 수 없는 장르: " + playFor(aPerformance).getType());
        }
        return result;
    }
}
