package com.x.utils.json;

import java.io.*;
import java.util.ArrayList;

public class ReadJsonFile {
    public static String readJsonFromFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ArrayList<String> getJsonFiles(String path) {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile() && tempList[i].getName().contains("_full")) {
                files.add(tempList[i].toString());
            }
        }
        return files;
    }
    public static void main(String[] args) {
        //System.out.println(readJsonFromFile("src/main/resources/chinaGeo/中国.json"));
        ArrayList<String> files = getJsonFiles("src/main/resources/chinaGeo/");
        for (int i = 0; i < files.size(); i++) {
            System.out.println(files.get(i));
        }
    }
}
