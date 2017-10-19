package cm.ncu.luov.entity;

import java.util.Arrays;

public class Answer {
    private Double a;
    private Double b;
    private Double c;
    private Double sum;

    @Override
    public String toString() {
        return "数组对：" +
                "[" + a +
                "," + b +
                "," + c +
                "],接近和：" + sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;

        Answer answer = (Answer) o;

        if (!getA().equals(answer.getA())) return false;
        if (!getB().equals(answer.getB())) return false;
        if (!getC().equals(answer.getC())) return false;
        return getSum().equals(answer.getSum());
    }

    @Override
    public int hashCode() {
        int result = getA().hashCode();
        result = 31 * result + getB().hashCode();
        result = 31 * result + getC().hashCode();
        result = 31 * result + getSum().hashCode();
        return result;
    }

    public Double getA() {

        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Answer(Double a, Double b, Double c, Double sum) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.sum = sum;
    }
}
