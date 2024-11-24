package org.emailpromoter.csvdatareader;

import com.opencsv.CSVReader;
import org.emailpromoter.bean.ColdEmailingDataBean;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReader {
    public static List<ColdEmailingDataBean> readColdEmailingCSV(String filePath) {
        List<ColdEmailingDataBean> dataList = new ArrayList<>();
        try (CSVReader dataReader = new CSVReader(new FileReader(filePath))) {
            String[] nextDataLine;
            dataReader.readNext();
            while ((nextDataLine = dataReader.readNext()) != null) {
                String emailAddress = nextDataLine[0];
                String recruiterName = nextDataLine[1];
                String companyName = nextDataLine[2];
                String jobTitle = nextDataLine[3];

                dataList.add(new ColdEmailingDataBean(emailAddress, recruiterName, companyName, jobTitle));
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
        return dataList;
    }
}
