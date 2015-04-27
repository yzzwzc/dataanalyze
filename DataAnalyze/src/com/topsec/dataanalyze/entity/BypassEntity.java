package com.topsec.dataanalyze.entity;

/*
 * 	4A日志的实体类，用来记录输出日志的结构
 * */
public class BypassEntity {
private String abnormalBehaviorWarning;
private String abnormalBehaviorSub;
private String behaviorSourceIp;
private String primaryAccount;
private String address4A;
private String proxyAddress;
private String targetIp;
private String actionType;
private String minorAccount;
private String severity;
private String actionTime;
private String sequence;
public String getAbnormalBehaviorWarning() {
	return abnormalBehaviorWarning;
}
public void setAbnormalBehaviorWarning(String abnormalBehaviorWarning) {
	this.abnormalBehaviorWarning = abnormalBehaviorWarning;
}
public String getAbnormalBehaviorSub() {
	return abnormalBehaviorSub;
}
public void setAbnormalBehaviorSub(String abnormalBehaviorSub) {
	this.abnormalBehaviorSub = abnormalBehaviorSub;
}
public String getBehaviorSourceIp() {
	return behaviorSourceIp;
}
public void setBehaviorSourceIp(String behaviorSourceIp) {
	this.behaviorSourceIp = behaviorSourceIp;
}
public String getPrimaryAccount() {
	return primaryAccount;
}
public void setPrimaryAccount(String primaryAccount) {
	this.primaryAccount = primaryAccount;
}
public String getAddress4A() {
	return address4A;
}
public void setAddress4A(String address4a) {
	address4A = address4a;
}
public String getProxyAddress() {
	return proxyAddress;
}
public void setProxyAddress(String proxyAddress) {
	this.proxyAddress = proxyAddress;
}
public String getTargetIp() {
	return targetIp;
}
public void setTargetIp(String targetIp) {
	this.targetIp = targetIp;
}
public String getActionType() {
	return actionType;
}
public void setActionType(String actionType) {
	this.actionType = actionType;
}
public String getMinorAccount() {
	return minorAccount;
}
public void setMinorAccount(String minorAccount) {
	this.minorAccount = minorAccount;
}
public String getSeverity() {
	return severity;
}
public void setSeverity(String severity) {
	this.severity = severity;
}
public String getActionTime() {
	return actionTime;
}
public void setActionTime(String string) {
	this.actionTime = string;
}
public String getSequence() {
	return sequence;
}
public void setSequence(String sequence) {
	this.sequence = sequence;
}
@Override
public String toString() {
	return "Log4AEntity [abnormalBehaviorWarning=" + abnormalBehaviorWarning
			+ ", abnormalBehaviorSub=" + abnormalBehaviorSub
			+ ", behaviorSourceIp=" + behaviorSourceIp + ", primaryAccount="
			+ primaryAccount + ", address4A=" + address4A + ", proxyAddress="
			+ proxyAddress + ", targetIp=" + targetIp + ", actionType="
			+ actionType + ", minorAccount=" + minorAccount + ", severity="
			+ severity + ", actionTime=" + actionTime + ", sequence="
			+ sequence + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime
			* result
			+ ((abnormalBehaviorSub == null) ? 0 : abnormalBehaviorSub
					.hashCode());
	result = prime
			* result
			+ ((abnormalBehaviorWarning == null) ? 0 : abnormalBehaviorWarning
					.hashCode());
	result = prime * result
			+ ((actionTime == null) ? 0 : actionTime.hashCode());
	result = prime * result
			+ ((actionType == null) ? 0 : actionType.hashCode());
	result = prime * result + ((address4A == null) ? 0 : address4A.hashCode());
	result = prime * result
			+ ((behaviorSourceIp == null) ? 0 : behaviorSourceIp.hashCode());
	result = prime * result
			+ ((minorAccount == null) ? 0 : minorAccount.hashCode());
	result = prime * result
			+ ((primaryAccount == null) ? 0 : primaryAccount.hashCode());
	result = prime * result
			+ ((proxyAddress == null) ? 0 : proxyAddress.hashCode());
	result = prime * result + ((sequence == null) ? 0 : sequence.hashCode());
	result = prime * result + ((severity == null) ? 0 : severity.hashCode());
	result = prime * result + ((targetIp == null) ? 0 : targetIp.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	BypassEntity other = (BypassEntity) obj;
	if (abnormalBehaviorSub == null) {
		if (other.abnormalBehaviorSub != null)
			return false;
	} else if (!abnormalBehaviorSub.equals(other.abnormalBehaviorSub))
		return false;
	if (abnormalBehaviorWarning == null) {
		if (other.abnormalBehaviorWarning != null)
			return false;
	} else if (!abnormalBehaviorWarning.equals(other.abnormalBehaviorWarning))
		return false;
	if (actionTime == null) {
		if (other.actionTime != null)
			return false;
	} else if (!actionTime.equals(other.actionTime))
		return false;
	if (actionType == null) {
		if (other.actionType != null)
			return false;
	} else if (!actionType.equals(other.actionType))
		return false;
	if (address4A == null) {
		if (other.address4A != null)
			return false;
	} else if (!address4A.equals(other.address4A))
		return false;
	if (behaviorSourceIp == null) {
		if (other.behaviorSourceIp != null)
			return false;
	} else if (!behaviorSourceIp.equals(other.behaviorSourceIp))
		return false;
	if (minorAccount == null) {
		if (other.minorAccount != null)
			return false;
	} else if (!minorAccount.equals(other.minorAccount))
		return false;
	if (primaryAccount == null) {
		if (other.primaryAccount != null)
			return false;
	} else if (!primaryAccount.equals(other.primaryAccount))
		return false;
	if (proxyAddress == null) {
		if (other.proxyAddress != null)
			return false;
	} else if (!proxyAddress.equals(other.proxyAddress))
		return false;
	if (sequence == null) {
		if (other.sequence != null)
			return false;
	} else if (!sequence.equals(other.sequence))
		return false;
	if (severity == null) {
		if (other.severity != null)
			return false;
	} else if (!severity.equals(other.severity))
		return false;
	if (targetIp == null) {
		if (other.targetIp != null)
			return false;
	} else if (!targetIp.equals(other.targetIp))
		return false;
	return true;
}

}
