package com.yusys.streaminghub.rpc.domain;

import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.Serializable;
import java.util.Date;

public class TPSmOperLogInf implements Serializable {

    private static final long serialVersionUID = 1L;

    private String flowId;

    private String backTime;

    private String busObject;

    private String flowNum;

    private String flowType;

    private String ifSuccess;

    private String launch;

    private String launchTime;

    private String mouldName;

    private String mouldType;

    private String opType;

    private String operateDt;

    private String operateYear;

    private String receive;

    private String srcFlowNo;

    private String userName;

    private String userNo;

    private String srcUpdatedTs;

    public TPSmOperLogInf() {
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getBackTime() {
        return backTime;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime;
    }

    public String getBusObject() {
        return busObject;
    }

    public void setBusObject(String busObject) {
        this.busObject = busObject;
    }

    public String getFlowNum() {
        return flowNum;
    }

    public void setFlowNum(String flowNum) {
        this.flowNum = flowNum;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    public String getIfSuccess() {
        return ifSuccess;
    }

    public void setIfSuccess(String ifSuccess) {
        this.ifSuccess = ifSuccess;
    }

    public String getLaunch() {
        return launch;
    }

    public void setLaunch(String launch) {
        this.launch = launch;
    }

    public String getLaunchTime() {
        return launchTime;
    }

    public void setLaunchTime(String launchTime) {
        this.launchTime = launchTime;
    }

    public String getMouldName() {
        return mouldName;
    }

    public void setMouldName(String mouldName) {
        this.mouldName = mouldName;
    }

    public String getMouldType() {
        return mouldType;
    }

    public void setMouldType(String mouldType) {
        this.mouldType = mouldType;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getOperateDt() {
        return operateDt;
    }

    public void setOperateDt(String operateDt) {
        this.operateDt = operateDt;
    }

    public String getOperateYear() {
        return operateYear;
    }

    public void setOperateYear(String operateYear) {
        this.operateYear = operateYear;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getSrcFlowNo() {
        return srcFlowNo;
    }

    public void setSrcFlowNo(String srcFlowNo) {
        this.srcFlowNo = srcFlowNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSrcUpdatedTs() {
        return srcUpdatedTs;
    }

    public void setSrcUpdatedTs(String srcUpdatedTs) {
        this.srcUpdatedTs = srcUpdatedTs;
    }

    @Override
    public String toString() {
        return "TPSmOperLogInf{" +
                "flowId='" + flowId + '\'' +
                ", backTime='" + backTime + '\'' +
                ", busObject='" + busObject + '\'' +
                ", flowNum='" + flowNum + '\'' +
                ", flowType='" + flowType + '\'' +
                ", ifSuccess='" + ifSuccess + '\'' +
                ", launch='" + launch + '\'' +
                ", launchTime='" + launchTime + '\'' +
                ", mouldName='" + mouldName + '\'' +
                ", mouldType='" + mouldType + '\'' +
                ", opType='" + opType + '\'' +
                ", operateDt=" + operateDt +
                ", operateYear='" + operateYear + '\'' +
                ", receive='" + receive + '\'' +
                ", srcFlowNo='" + srcFlowNo + '\'' +
                ", userName='" + userName + '\'' +
                ", userNo='" + userNo + '\'' +
                '}';
    }

}