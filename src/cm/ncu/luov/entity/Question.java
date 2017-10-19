package cm.ncu.luov.entity;

import java.util.List;

public class Question {
    private Double[] array;
    private Double target;

    public Question(Double[] array, Double target) {
        this.array = array;
        this.target = target;
    }

    public Double[] getArray() {
        return array;
    }

    public void setArray(Double[] array) {
        this.array = array;
    }

    public Double getTarget() {
        return target;
    }

    public void setTarget(Double target) {
        this.target = target;
    }
}
