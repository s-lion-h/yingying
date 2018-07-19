package com.util;

/*
 * Create by s lion h on 2018/6/24
 */
public class AA {
    public static final DBProcess dbprocess=new DBProcess();

    public static void main(String[] args) {
        for(int i=600000;i<=600020;i++){
            String sql="CREATE TABLE `"+i+"` (\n" +
                    "        id INT NOT NULL AUTO_INCREMENT,\n" +
                    "        text varchar(256),\n" +
                    "        date varchar(256),\n" +
                    "        sentiment int(11),\n" +
                    "        confidence double,\n" +
                    "        positive_prob double,\n" +
                    "        negative_prob double,\n" +
                    "        PRIMARY KEY (`id`)\n" +
                    "        )";
            dbprocess.insertDeleteUpdate(sql);
        }
    }
}
