package com.example.employeeapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionOption {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("questionMasterID")
    @Expose
    public String questionMasterID;
    @SerializedName("optionContent")
    @Expose
    public String optionContent;
    @SerializedName("optionWeightage")
    @Expose
    public String optionWeightage;
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("add_date")
    @Expose
    public String addDate;
    @SerializedName("it_selected")
    @Expose
    public String itSelected;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionMasterID() {
        return questionMasterID;
    }

    public void setQuestionMasterID(String questionMasterID) {
        this.questionMasterID = questionMasterID;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    public String getOptionWeightage() {
        return optionWeightage;
    }

    public void setOptionWeightage(String optionWeightage) {
        this.optionWeightage = optionWeightage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getItSelected() {
        return itSelected;
    }

    public void setItSelected(String itSelected) {
        this.itSelected = itSelected;
    }
}