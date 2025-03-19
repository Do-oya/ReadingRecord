package chapter01;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementTest {

    @Test
    void testStatement() {
        Invoice.Performance performance1 = new Invoice.Performance();
        performance1.setPlayID("hamlet");
        performance1.setAudience(55);

        Invoice.Performance performance2 = new Invoice.Performance();
        performance2.setPlayID("as-like");
        performance2.setAudience(35);

        Invoice.Performance performance3 = new Invoice.Performance();
        performance3.setPlayID("othello");
        performance3.setAudience(40);

        Invoice invoice = new Invoice();
        invoice.setCustomer("BigCo");
        invoice.setPerformances(List.of(performance1, performance2, performance3));

        Play play1 = new Play();
        play1.setName("Hamlet");
        play1.setType("tragedy");

        Play play2 = new Play();
        play2.setName("As You Like It");
        play2.setType("comedy");

        Play play3 = new Play();
        play3.setName("Othello");
        play3.setType("tragedy");

        Map<String, Play> plays = new HashMap<>();
        plays.put("hamlet", play1);
        plays.put("as-like", play2);
        plays.put("othello", play3);

        String result = new Statement(invoice, plays).statement();

        // 예상 결과를 설정합니다.
        String expected = "청구내역 (고객명: BigCo)\n" +
                "Hamlet: $650.00 55석\n" +
                "As You Like It: $580.00 35석\n" +
                "Othello: $500.00 40석\n" +
                "총액 $1,730.00\n" +
                "적립 포인트 47점\n";

        // 결과를 검증합니다.
        assertEquals(expected, result);
    }
}
