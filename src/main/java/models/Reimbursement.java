package models;

import jdk.jshell.spi.SPIResolutionException;

import java.util.Date;
import java.util.Objects;

public class Reimbursement {
    private String firstName;
    private String lastName;
    private String userRole;
    private Double amount;
    private Date submittedDate;
    private String status;
    private String type;
    private Integer statusId;
    private Integer authorId;
    private Integer typeId;
    private String description;
    private Integer resolverId;
    private Integer reimbId;

    public Integer getReimbId() {
        return reimbId;
    }

    public void setReimbId(Integer reimbId) {
        this.reimbId = reimbId;
    }

    public Integer getResolverId() {
        return resolverId;
    }

    public void setResolverId(Integer resolverId) {
        this.resolverId = resolverId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Reimbursement() {
    }

    public Reimbursement(Integer statusId, Integer authorId) {
        this.statusId = statusId;
        this.authorId = authorId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userRole='" + userRole + '\'' +
                ", amount=" + amount +
                ", submittedDate=" + submittedDate +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }


}
