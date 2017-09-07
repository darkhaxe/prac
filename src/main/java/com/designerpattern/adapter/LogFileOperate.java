package com.designerpattern.adapter;

import java.io.*;
import java.util.List;

public class LogFileOperate implements LogFileApi {
    private String filePathName = "logfile.log";

    public LogFileOperate(String filePathName) {
        this.filePathName = filePathName;
    }

    @Override
    public List<LogModel> readLogFile() {
        List<LogModel> logs = null;
        ObjectInputStream in = null;
        File f = new File(filePathName);
        if (f.exists()) {
            try {
                in = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(f)));
                logs = (List<LogModel>) in.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return logs;
        }

        return null;
    }

    @Override
    public void writeLogFile(List<LogModel> logs) {
        File f = new File(filePathName);
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(f)
                    )
            );
            out.writeObject(logs);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
