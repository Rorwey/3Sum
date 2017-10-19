package cm.ncu.luov.utils;

import javax.sound.midi.MidiChannel;
import java.lang.reflect.Array;
import java.util.*;

public class ArrayUtils {
    /**
     * int数组转化为Integer数组
     * @param array int数组
     * @return Integer数组
     */
    public static Integer[] int2Integer(int[] array) {
        Integer[] outArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            outArray[i] = array[i];
        }
        return outArray;
    }

    /**
     * 检查数组中是否有重复值
     *
     * @param array 待检数组
     * @return 真或假
     */
    public static boolean checkRepeat(int[] array) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int anArray : array) {
            hashSet.add(anArray);
        }
        return hashSet.size() == array.length;
    }

    /**
     * 比较两个类型数组间的差异（数组的补集）
     *
     * @param list1 待比较数组
     * @param t2    标准数组（全集）
     * @param <T>   类型
     * @return 差异数组
     */
    public static <T> List<T> ArrayComplement(List<T> list1, List<T> t2) {
        List<T> list2 = new ArrayList<>();
        for (T t : t2) {
            if (!list1.contains(t)) {
                list2.add(t);
            }
        }
        return list2;
    }

    /**
     * 比较两个数组中相同的部分（数组的交集）
     *
     * @param list1 待比较数组1
     * @param list2 待比较数组2
     * @return 数组中相同的部分
     */
    public static List<Integer> ArrayIntersect(List<Integer> list1, List<Integer> list2) {
        List<Integer> listOut = new ArrayList<>();
        if (list1.size() > list2.size()) {
            for (Integer aList1 : list1) {
                for (Integer aList2 : list2) {
                    if (aList1.equals(aList2)) {
                        listOut.add(aList1);
                    }
                }
            }
        } else {
            for (Integer aList2 : list2) {
                for (Integer aList1 : list1) {
                    if (aList2.equals(aList1)) {
                        listOut.add(aList2);
                    }
                }
            }
        }
        return listOut;
    }

    /**
     * 将两个数组合并（数组的并集），利用set的元素唯一性
     *
     * @param t1 待合并数组1
     * @param t2 待合并数组2
     * @return Set集
     */
    public static <T> Set<T> ArrayUnion(T[] t1, T[] t2) {
        List<T> list1 = Arrays.asList(t1);
        List<T> list2 = Arrays.asList(t2);
        Set<T> set = new HashSet<>();
        set.addAll(list1);
        set.addAll(list2);
        return set;
    }

    /**
     * 将两个整型数组合并（求并集），无重复
     *
     * @param ins1 数组1
     * @param ins2 数组2
     * @return 新数组
     */
    public static Integer[] ArrayUnion(Integer[] ins1, Integer[] ins2) {
        int length1 = ins1.length, length2 = ins2.length;
        Integer[] outArr = new Integer[length1 + length2];
        System.arraycopy(ins1, 0, outArr, 0, length1);
        System.arraycopy(ins2, 0, outArr, length1, length2);
//        System.arraycopy(ins2, length1 - length1, ins1, length1, length2 + length1 - length1);

        return (Integer[]) DeleteRepeatData(outArr);
    }

    /**
     * 将整型Set转为整形数组
     *
     * @param set SET
     * @return 数组
     */
    public static Integer[] IntSet2Array(Set set) {
        Integer[] outArr = new Integer[set.size()];
        Iterator iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            outArr[i] = (Integer) iterator.next();
            i++;
        }
        return outArr;
    }

    /**
     * 去掉数组中重复的数据
     *
     * @param arr 整型数组
     * @return 处理好的数组
     */
    private static Object[] DeleteRepeatData(Object[] arr) {
        Set set = new HashSet();
        //遍历数组并存入集合,如果元素已存在则不会重复存入
        Collections.addAll(set, arr);
        //返回Set集合的数组形式
        return set.toArray();
    }

    /**
     * 找到数组第一个最小值的索引
     *
     * @param array 数组
     * @return 最小值的索引
     */
    public static Integer ArrayMin(Integer[] array) {
        ArrayList<Integer> tempArr = new ArrayList<>();
        for (Integer anArray : array) {
            if (anArray != null) {
                tempArr.add(anArray);
            }
        }
        Integer[] objects = IntList2Array(tempArr);
        ArrayQuickSort(objects, 0, tempArr.size() - 1);
        for (Integer i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].equals(objects[0])) {
                    return i;
                }
            }
        }
        return null;
    }

    /**
     * 找到数组第一个，大于num的最小值的索引
     *
     * @param array 数组
     * @param num   参照最小值
     * @return 最小值的索引
     */
    public static Integer ArrayMin(Integer[] array, Integer num) {
        Integer temp = null;
        ArrayList<Integer> tempArr = new ArrayList<>();
        for (Integer anArray : array) {
            if (anArray != null) {
                tempArr.add(anArray);
            }
        }
        Integer[] objects = IntList2Array(tempArr);
        ArrayQuickSort(objects, 0, tempArr.size() - 1);
        temp = Find1stMin(objects, num);
        if (temp.equals(num)) return null;
        else {
            for (Integer i = 0; i < array.length; i++) {
                if (array[i] != null && array[i].equals(temp)) {
                    return i;
                }
            }
        }
        return null;
    }

    /**
     * 找到递增数组中第一个大于参照值的最小数
     *
     * @param array 待比较数组
     * @param num   参考值
     * @return 值
     */
    private static Integer Find1stMin(Integer[] array, Integer num) {
        for (Integer aList : array) {
            if (num < aList)
                return aList;
        }
        return num;
    }
    /**
     * 找到递增数组中第一个大于参照值的最小数的下标
     *
     * @param array 待比较数组
     * @param num   参考值
     * @return 值
     */
    public static Integer Find1stMinIndex(Double[] array, Double num) {
        Integer mid=array.length/2;
        Double[] next ;
        if(num<array[mid]){
            next= Arrays.copyOfRange(array, 0,mid);
            Integer a=Find1stMinIndex(next,num);
        }else {
            next= Arrays.copyOfRange(array, mid,array.length-1);
            Integer b=Find1stMinIndex(next,num);
        }
        return null;
    }


    /**
     * 数组的快速排序，从小到大
     * 对数组全排序，应传入0及数组长度-1
     * @param arrays 待排序数组
     * @param start  排序起点
     * @param end    排序终点
     */
    public static void ArrayQuickSort(Double[] arrays, Integer start, Integer end) {
        if (start >= end) {                              //判断数组的起始和终止是否相同，相同表示已经都全部排完，返回
            return;
        }
        Integer i = start;                              //i指向数组的起始位
        Integer j = end;                                //j指向数组的末位
        Double key = arrays[i];                        //选取数组的第一位为关键字key，基准元素
        boolean flag = true;                        //设置标志位，用于判断是i++还是j--;这个很重要
        //int temp;
        while (!i.equals(j)) {                              //如果i≠j，表示还没有比较完，即即关键字左右两侧还不是最小与最大
            if (flag) {
                if (key > arrays[j]) {                   //从后向前遍历，找到小于key的值，
                    swap(arrays, i, j);               //找到小于key的值后将arrays[i]与此值交换
                    flag = false;
                } else {                              //如果没有找到的话j--，向前遍历
                    j--;
                }
            } else {
                if (key < arrays[i]) {                   //从前向后遍历，找到大于key的值
                    swap(arrays, i, j);               //将此值与arrays[j]进行交换
                    flag = true;
                } else {                              //如果没有找到话就将i++,向后遍历
                    i++;
                }
            }
        }
//        sprint(arrays);                             //打印每次排序后的数组
        ArrayQuickSort(arrays, start, j - 1);                  //递归调用，将基准元素的前半段数组再用此方法进行排序，直到所有都排完为止。
        ArrayQuickSort(arrays, i + 1, end);                    //递归调用，将基准元素的后半段数组再用此方法进行排序，直到所有都排完为止。
    }
    public static void ArrayQuickSort(Integer[] arrays, Integer start, Integer end) {
        if (start >= end) {                              //判断数组的起始和终止是否相同，相同表示已经都全部排完，返回
            return;
        }
        Integer i = start;                              //i指向数组的起始位
        Integer j = end;                                //j指向数组的末位
        Integer key = arrays[i];                        //选取数组的第一位为关键字key，基准元素
        boolean flag = true;                        //设置标志位，用于判断是i++还是j--;这个很重要
        //int temp;
        while (!i.equals(j)) {                              //如果i≠j，表示还没有比较完，即即关键字左右两侧还不是最小与最大
            if (flag) {
                if (key > arrays[j]) {                   //从后向前遍历，找到小于key的值，
                    swap(arrays, i, j);               //找到小于key的值后将arrays[i]与此值交换
                    flag = false;
                } else {                              //如果没有找到的话j--，向前遍历
                    j--;
                }
            } else {
                if (key < arrays[i]) {                   //从前向后遍历，找到大于key的值
                    swap(arrays, i, j);               //将此值与arrays[j]进行交换
                    flag = true;
                } else {                              //如果没有找到话就将i++,向后遍历
                    i++;
                }
            }
        }
//        sprint(arrays);                             //打印每次排序后的数组
        ArrayQuickSort(arrays, start, j - 1);                  //递归调用，将基准元素的前半段数组再用此方法进行排序，直到所有都排完为止。
        ArrayQuickSort(arrays, i + 1, end);                    //递归调用，将基准元素的后半段数组再用此方法进行排序，直到所有都排完为止。
    }
    /**
     * 交换函数
     *
     * @param array 待交换的数组
     * @param i
     * @param j
     */
    private static void swap(Integer[] array, Integer i, Integer j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private static void swap(Double[] array, Integer i, Integer j) {
        double temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 统计数组中指定值的数量
     *
     * @param t1 待比较数组
     * @param t2 比较元素
     * @return 数量
     */
    public static <T> int ArrayCountElement(T[] t1, T t2) {
        int count = 0;
        for (int i = 0; i < t1.length; i++) {
            if (t1[i] == t2)
                count++;
        }
        return count;
    }

    public static int ArrayCountElement(int[] t1, int t2) {
        int count = 0;
        for (int i = 0; i < t1.length; i++) {
            if (t1[i] == t2)
                count++;
        }
        return count;
    }

    /**
     * List转换为对应数组
     *
     * @param list 要转换的List
     * @return 对应数组
     */
//    public static Object[] IntList2Array(List<Object> list) {
//        Object[] arr = new Object[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            arr[i] = list.get(i);
//        }
//        return arr;
//    }
    public static Integer[] IntList2Array(List<Integer> list) {
        Integer[] arr = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
