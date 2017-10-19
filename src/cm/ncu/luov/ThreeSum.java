package cm.ncu.luov;

import cm.ncu.luov.entity.Answer;
import cm.ncu.luov.entity.Question;
import cm.ncu.luov.utils.FileUtils;
import cm.ncu.luov.utils.InputUtils;

import java.io.File;
import java.util.*;


class ThreeSum {
    public ThreeSum() {
    }

    Answer threeSumClosest(Double[] nums, Double target) {
        System.out.println("这个数组是:"+Arrays.toString(nums));
        System.out.println("");
        Arrays.sort(nums);
        System.out.println("这个数组最大数是：" + nums[nums.length - 1] + "\t最小数是：" + nums[0] + "\t目标数是" + target);
        Double closetSum;
        Double minDiff=Double.MAX_VALUE/2;
        Double gap;
        Double sum;
        for (int i = 0; i < nums.length; ++i) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                // 当前组合的和与目标的差值
                gap = Math.abs(sum - target);
                if (gap < minDiff) {
                    closetSum = sum;
                    minDiff = gap;
                    Answer ans = new Answer(nums[i], nums[left], nums[right], sum);
                }
                // 双指针的移动法样
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return ans;
                }
            }
        }
        return null;
    }
    List<Question> giveQuestion() {
        while (true) {
            int chose = InputUtils.inputInt("请选择数据途径：\n1)完全系统随机生成，2)手动输入上下界,3)从文件读取：");
            switch (chose) {
                case 1:
                    List<Question> questionLi = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        Question question = makeQuestionWholeRandom();
                        questionLi.add(question);
                    }
                    return questionLi;
                case 2:
                    List<Question> questions = new ArrayList<>();
//                    for (int i = 0; i <10 ; i++) {
                    Question question = makeQuestionRandom();
                    questions.add(question);
//                    }
                    return questions;
                case 3:
                    return makeQuestionFile();
                default:
                    System.out.println("输入有误，请重新输入。");
            }
        }
    }

    private Double getTarget() {
        return InputUtils.inputDouble("请输入参照数：");
    }

    /**
     * 系统完全随机生成
     * @return
     */
    private Question makeQuestionWholeRandom() {
        Random random = new Random();
        Set<Double> numSet = new HashSet<>();
        int length = random.nextInt(100) % (100 - 1 + 1) + 1;
        double min = 1 + Math.random() * (100 - 1);
        double max = 1 + Math.random() * (100 - 1);
        while (true) {
            if (max < min || max == min) {
                max = 1 + Math.random() * (100 - 1);
            } else {
                break;
            }
        }
        while (numSet.size() < length) {
            numSet.add(min + Math.random() * (max - min));
        }
        Object[] objects = numSet.toArray();
        Double[] outArr = new Double[objects.length];
        for (int i = 0; i < objects.length; i++) {
            outArr[i] = (Double) objects[i];
        }
        double target = 1 + Math.random() * (100 - 1);
        return new Question(outArr, target);
    }

    /**
     * @return
     */
    private Question makeQuestionRandom() {
        Set<Double> numSet = new HashSet<>();
        int length = InputUtils.inputInt("请输入集合的大小：");
        Double min = InputUtils.inputDouble("请输入集合中的最小数：");
        Double max = InputUtils.inputDouble("请请输入集合中的最大数：");
        while (true) {
            if (max < min || max == min) {
                max = InputUtils.inputDouble("请请输入集合中的最大数：");
            } else {
                break;
            }
        }
        Random random = new Random();
        while (numSet.size() < length) {
            numSet.add(min + Math.random() * (max - min));
        }
        Object[] objects = numSet.toArray();
        Double[] outArr = new Double[objects.length];
        for (int i = 0; i < objects.length; i++) {
            outArr[i] = (Double) objects[i];
        }
        double target = getTarget();
        return new Question(outArr, target);
    }

    private List makeQuestionFile() {
        List<Question> questions = new ArrayList<>();
        Set<Double> numSet = new HashSet<>();
        File numFile = InputUtils.inputFile("输入数据文件路径：");
        String numStr = FileUtils.readTextFromFile(numFile);
        assert numStr != null;
        String[] numList = numStr.split("\r\n");
        for (String aNumList : numList) {
            String[] splits = aNumList.split(",");
            for (int i = 0; i < splits.length - 2; i++) {
                numSet.add(Double.valueOf(splits[i]));
            }
            System.out.println("输入了" + numSet.size() + "个数");
            Object[] objects2 = numSet.toArray();
            Double[] outArr = new Double[objects2.length];
            for (int i = 0; i < objects2.length; i++) {
                outArr[i] = (Double) objects2[i];
            }
            Double target = Double.parseDouble(splits[splits.length - 1]);
            Question question = new Question(outArr, target);
            questions.add(question);
        }
        return questions;
    }
    private Double doublePointer(Double[] nums,double target){
        Double minDiff =Double.MAX_VALUE;
        Double gap;
        Double sum;
        Double closetSum;
        for (int i = 0; i < nums.length; ++i) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                Answer ans = new Answer(i, left, right, sum);
                // 当前组合的和与目标的差值
                gap = Math.abs(sum - target);
                if (gap < minDiff) {
                    closetSum = sum;
                    minDiff = gap;
                }
                // 双指针的移动法样
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }
        return null;
    }
}
