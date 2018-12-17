package Split;

import java.io.*;

public class splitX {

    public static void main(String[] args) {
        //读取整个文本
        String read = "C:\\Users\\Administrator\\Desktop\\t1.txt";
        String write = "C:\\Users\\Administrator\\Desktop\\1111.txt";
        String s = readToString(read);
        String s1;
        String s2;
        //创建表结构
        String c1 = "create table test2 (";
        //创建表结构有关
        String c2 = "";
        //插入表结构有关
        String i1 = "";
        //查询表
        String ss1 = "";
        //查表关
        String ss2;
        //task
        String t1 = "";
        String t2 = "";
        String cc1 = "";
        BufferedWriter out = writeFile(write);
        //切分成行

        s = s.replace("\"", "");
        s = s.replace("{", "\t");
        String[] split = s.split("}");
        //处理
        for (int i = 0; i < split.length; i++) {
            s2 = split[i].substring(1, split[i].length());
            String[] split1 = s2.split("\t");
            split1[0] = split1[0].replace(":", "_");
            String[] split2 = split1[1].split(",");

            for (int j = 0; j < split2.length; j++) {
                String[] split3 = split2[j].split(":");
                if (!split3[0].contains("\\")) {
                    s1 = split1[0] + split3[0];
                    ss2 = s1.replace("_", ".");
                    c2 = c2 + s1 + " string,";
                    i1 = i1 + s1 + " ,";

                    ss2 = "get_json_object(t.variable,'$." + ss2 + "') as " + s1 + ",";
                    ss1 = ss1 + ss2;
                }
            }
//            try {
//                out.write(s1);
//                out.flush(); // 把缓存区内容压入文件
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        c2 = c2.substring(0, c2.length() - 1);
//        System.out.println(s4);

//        System.out.println(c1);
        //插入表
        i1 = i1.substring(0, i1.length() - 1);
        i1 = "insert into test1 ( " + i1 + ")";
//        System.out.println(i1);
        //查询数据
        ss1 = ss1.substring(0, ss1.length() - 1);
        ss1 = "select " + ss1 + " from risk_center.t_risk_context t WHERE t.year=2018 and t.month = 11 and t.day =27";
//        System.out.println(ss1);

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        read = "C:\\Users\\Administrator\\Desktop\\task.txt";
        s = readToString(read);

        String[] split1 = s.split(",");

        for (int i = 0; i < split1.length; i++) {
            String[] split2 = split1[i].split(" ");

            cc1 = cc1+ "task_"+split2[0]+" "+ split2[1] +" ,";
        }

        //创建表
        c1 = c1 + cc1 +"task1_id bigint ,"+ c2 + ") partitioned by(year string, month string,day string) ";
        System.out.println(c1);
    }

    public static String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    public static BufferedWriter writeFile(String write) {
        try {
            File writeName = new File(write); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            FileWriter writer = new FileWriter(writeName);
            BufferedWriter out = new BufferedWriter(writer);
            return out;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}

