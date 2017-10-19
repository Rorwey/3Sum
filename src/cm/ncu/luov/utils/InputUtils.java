package cm.ncu.luov.utils;


import java.io.File;
import java.util.Scanner;

/**
 * 控制台输入 工具类
 * @author linhuaming
 *
 */
public class InputUtils {
    private static Scanner sc = new Scanner(System.in);

    /**
     * 从控制台输入int值
     *
     * @param tip
     *            提示内容
     * @return 返回输入的int值
     */
    public static int inputInt(String tip) {
        while (true) {
            System.out.println(tip);
            boolean hasNextInt = sc.hasNextInt();
            if (!hasNextInt) {
                System.out.println("输入有误，请重新输入！");
                sc.next();
                continue;
            }
            return sc.nextInt();
        }
    }
    /**
     * 从控制台输入double值
     *
     * @param tip
     *            提示内容
     * @return 返回输入的double值
     */
    public static Double inputDouble(String tip) {
        while (true) {
            System.out.println(tip);
            boolean hasNextDouble = sc.hasNextDouble();
            if (!hasNextDouble) {
                System.out.println("输入有误，请重新输入！");
                sc.next();
                continue;
            }
            return sc.nextDouble();
        }
    }
    /**
     * 从控制台输入文本。
     * @param tip 提示输入信息
     * @return 返回输入的文本内容
     */
    public static String inputStr(String tip) {
        System.out.println(tip);
        return sc.next();
    }
    /**
     * 从控制台输入文本。
     * @param tip 提示输入信息
     * @return 返回输入的文本内容
     */
    public static File inputFile(String tip) {
        String str = inputStr(tip);
        File file=new File(str);
        while (true) {
            System.out.println(tip);
            if (!file.exists()){
                inputStr("文件路径错误，请重新输入");
                sc.next();
                continue;
            }
                return file;
        }
    }
}

