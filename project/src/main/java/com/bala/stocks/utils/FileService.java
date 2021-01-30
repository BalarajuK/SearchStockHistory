package com.bala.stocks.utils;

import com.bala.stocks.interfaces.IFileServices;

import java.io.*;

public class FileService implements IFileServices {

    @Override
    public String getWelcomePage() {
        return new UIUtils().getWelcomePage();
    }

    public String getFileContents(String path) {

        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        StringBuilder data = new StringBuilder();
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data.toString();

    }
}
