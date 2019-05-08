package cn.javabus.common.util;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangkaihui
 * @date 2018/12/11
 */
public class DeviationFormulaUtil implements Serializable {

    private static final int scale = 2;

    public static BigDecimal standardDeviation(List<BigDecimal> nodes) {
        nodes = removeNullNode(nodes);
        if (nodes.isEmpty()) {
            return null;
        }
        BigDecimal average = average(nodes);
        BigDecimal powerSum = BigDecimal.ZERO;
        for (BigDecimal node : nodes) {
            BigDecimal subtract = node.subtract(average);
            powerSum = powerSum.add(subtract.multiply(subtract));
        }
        double sqrt;
        if (powerSum.doubleValue() > 0) {
            sqrt = Math.sqrt(powerSum.doubleValue() / nodes.size());
        } else {
            sqrt = 0D;
        }
        BigDecimal standardDeviation = new BigDecimal(sqrt);
        return standardDeviation.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * sum average
     * @param nodes
     * @return
     */
    public static BigDecimal average(List<BigDecimal> nodes) {
        nodes = removeNullNode(nodes);
        if (nodes.isEmpty()) {
            return null;
        }
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal node : nodes) {
            sum = sum.add(node);
        }
        return sum.divide(new BigDecimal(nodes.size()), scale, BigDecimal.ROUND_HALF_UP);
    }

    public static List<BigDecimal> removeNullNode(List<BigDecimal> nodes) {
        List<BigDecimal> noNullList = new ArrayList<>();
        if (nodes != null) {
            for (BigDecimal node : nodes) {
                if (node != null) {
                    noNullList.add(node);
                }
            }
        }
        return noNullList;
    }

    public static long costTime(Runnable runnable) {
        LocalTime before = LocalTime.now();
        runnable.run();
        LocalTime after = LocalTime.now();
        System.out.println("before : " + before);
        System.out.println("after : " + after);
        long until = before.until(after, ChronoUnit.MILLIS);
        System.out.println("until : " + until);
        return until;
    }
}
