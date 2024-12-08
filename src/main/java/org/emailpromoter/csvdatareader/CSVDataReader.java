package org.emailpromoter.csvdatareader;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.emailpromoter.bean.ColdEmailingDataBean;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReader {
    public static List<ColdEmailingDataBean> readColdEmailingCSV(String filePath) {
        List<ColdEmailingDataBean> dataList = new ArrayList<>();
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        try (CSVReader dataReader = new CSVReaderBuilder(new FileReader(filePath)).withCSVParser(parser).build()) {
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
