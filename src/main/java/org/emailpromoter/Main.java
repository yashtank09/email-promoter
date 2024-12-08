package org.emailpromoter;

import org.emailpromoter.bean.ColdEmailingDataBean;
import org.emailpromoter.csvdatareader.CSVDataReader;
import org.emailpromoter.csvdatareader.FileHandler;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Yash Stuff\\Learning Stuff\\Java\\email-promoter\\src\\main\\resources\\job-emails-data.csv";
        List<ColdEmailingDataBean> coldEmailingDataList = CSVDataReader.readColdEmailingCSV(filePath);
        for (ColdEmailingDataBean data: coldEmailingDataList) {
            System.out.println("Email ID: " + data.getEmailAddress());
        }
    }
}