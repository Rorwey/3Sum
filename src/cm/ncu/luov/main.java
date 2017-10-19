package cm.ncu.luov;

import cm.ncu.luov.entity.Answer;
import cm.ncu.luov.entity.Question;

import java.util.List;

public class main {
    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        List<Question> questions = ts.giveQuestion();
        for (Question question : questions) {
            Answer ans = ts.threeSumClosest(question.getArray(), question.getTarget());
            if (ans!=null){
            System.out.println("最接近" + question.getTarget() + "的数是 " + ans.getSum());
            System.out.println("数组对："+ans.toString());}
        }
    }
}
