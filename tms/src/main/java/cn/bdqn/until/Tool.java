package cn.bdqn.until;



import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.InputStreamReader;
        import java.sql.ResultSet;

/**
 * Created by Happy on 2017-11-06.
 */
public class Tool {
    public static void main(String[] args) {
        //批量插入数据的方式
        BaseDao dao=new BaseDao();
        //读取一个文本文件
        try {
            String encoding="utf-8"; //简体中文  utf-8
            File file=new File("d:\\file.txt");
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                int i=3;
                String syscode =null;
                i++;
                while((lineTxt = bufferedReader.readLine()) != null){
                    String[] types = lineTxt.split(">");

                    //有父级
                    if (types[0]!=null&&!types[0].equals("")){
                        dao.executeUpdate("INSERT INTO `cm_column` VALUES (UUID(),"+(i+1)+" , '"+types[0]+"', null, '0', '0', null)");
                        i++;
                    }
                    ResultSet rs = dao.executeQuery("select syscode from cm_column where columnname=?", types[0]);
                    if (rs.next()){
                        syscode=rs.getString("syscode");
                    }
                    dao.executeUpdate("INSERT INTO `cm_column` VALUES (UUID(),"+i+" , '"+types[1]+"', null, '"+syscode+"', '0', null)");
                    rs.close();

                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i=3;i<3;i++){

        }

    }
}
