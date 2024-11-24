package org.emailpromoter.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ColdEmailingDataBean {
    private String emailAddress;
    private String recruiterName;
    private String companyName;
    private String jobTitle;
}
