package chapter01;

import java.util.List;

public class Invoice {
    private String customer;
    private List<Performance> performances;

    public String getCustomer() {
        return customer;
    }

    public List<Performance> getPerformances() {
        return performances;
    }

    public static class Performance {
        private String playID;
        private int audience;

        public String getPlayID() {
            return playID;
        }

        public int getAudience() {
            return audience;
        }
    }
}
