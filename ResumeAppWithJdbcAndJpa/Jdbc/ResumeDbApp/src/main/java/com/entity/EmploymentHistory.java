package com.entity;

import java.sql.Date;
import lombok.Data;

@Data
public class EmploymentHistory {
    private Integer id;
    private String header;
    private Date beginDate;
    private Date endDate;
    private String jobDescription;
    private User user;

    public EmploymentHistory() {
    }

    public EmploymentHistory(Integer id, String header, Date beginDate, Date endDate, String jobDescription, User user) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.user = user;
    }
}
