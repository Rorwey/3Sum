package cm.ncu.luov.utils;

import java.io.*;

/**
 * File 工具类
 *
 * @author linhuaming
 *
 */
public class FileUtils {

    /**
     * 获取 file文件的所有字节
     *
     * @param file
     *            需要获取的File
     * @return byte[]
     */
    public static byte[] getFileAllBytes(File file) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
             ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = bis.read(b)) != -1) {
                baos.write(b, 0, len);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeBytes2File(byte[] b, File file) {
        try (FileOutputStream fos = new FileOutputStream(file);) {
            fos.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写文本到指定文件中
     *
     * @param content
     *            写入的文本内容
     * @param to
     *            指定的文件
     * @param append
     *            是否是追加写入
     * @return 成功与否
     */
    public static boolean writeText2File(String content, File to, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(to, append));) {
            bw.write(content);
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    /**
     * 使用文本流，读取文件的文本内容
     *
     * @param file
     *            需要读取的文本文件
     * @return String 读取的内容
     */
    public static String readTextFromFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file));) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line).append("\r\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 在指定文件末尾追加文本内容
     *
     * @param content
     *            追加的内容
     * @param file
     *            指定文件对象
     * @return 成功与否
     */
    public static boolean appendText2File(String content, File file) {
        return writeText2File(content, file, true);
    }

    /**
     * 覆盖指定文件的文本内容为新的文本
     *
     * @param content
     *            新的文本
     * @param file
     *            被覆盖的文件对象
     * @return 成功与否
     */
    public static boolean overrideText2File(String content, File file) {
        return writeText2File(content, file, false);
    }

    /**
     * 编写一个方法，接受第一个FIle fromFile,接受第二参数 File toFile；
     *
     * 将 fromFIle 文件内容复制到 toFile 中。
     *
     */
    /**
     * 文件的复制
     *
     * @param fromFile
     *            拷贝的文件位置
     * @param toFile
     *            粘贴的文件位置
     * @return 成功与否
     */
    public static boolean copy(File fromFile, File toFile) {
        try (FileInputStream fis = new FileInputStream(fromFile);
             FileOutputStream fos = new FileOutputStream(toFile);) {
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
