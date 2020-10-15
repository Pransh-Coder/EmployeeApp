package com.example.employeeapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Datum {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("masterId")
    @Expose
    public String masterId;
    @SerializedName("questionId")
    @Expose
    public String questionId;
    @SerializedName("optionValue")
    @Expose
    public String optionValue;
    @SerializedName("weightageValue")
    @Expose
    public String weightageValue;
    @SerializedName("questionContent")
    @Expose
    public String questionContent;
    @SerializedName("qustionUUID")
    @Expose
    public String qustionUUID;
    @SerializedName("question_options")
    @Expose
    public List<QuestionOption> questionOptions = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public String getWeightageValue() {
        return weightageValue;
    }

    public void setWeightageValue(String weightageValue) {
        this.weightageValue = weightageValue;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQustionUUID() {
        return qustionUUID;
    }

    public void setQustionUUID(String qustionUUID) {
        this.qustionUUID = qustionUUID;
    }

    public List<QuestionOption> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(List<QuestionOption> questionOptions) {
        this.questionOptions = questionOptions;
    }
}
