package com.topsec.dataanalyze.entity;

public class SyslogDataEntity extends DataEntity {
	public String clientip;
	public String user;
	public String sender;
	public String timestamp;
	public String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getClientip() {
		return clientip;
	}
	public void setClientip(String clientip) {
		this.clientip = clientip;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Boolean timeequals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SyslogDataEntity other = (SyslogDataEntity) obj;
		if ((timestamp == null) || (other.timestamp == null)) {
			return false;
		}
		return timestamp.substring(0,timestamp.length() - 2).equals(other.timestamp.substring(0,other.timestamp.length() - 2));
	}
	public int compareTo(Object obj) {
		if (this == obj)
			return 0;
		if (obj == null)
			return 1;
		SyslogDataEntity other = (SyslogDataEntity) obj;
		if (timestamp == null || other.timestamp == null)
			return -1;
        return timestamp.compareTo(other.timestamp);
    }
	@Override
	public String toString() {
		return "SyslogDataEntity [clientip=" + clientip + ", user=" + user
				+ ", sender=" + sender + ", timestamp=" + timestamp
				+ ", result=" + result + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clientip == null) ? 0 : clientip.hashCode());
		result = prime * result
				+ ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		SyslogDataEntity other = (SyslogDataEntity) obj;
		if (clientip == null) {
			if (other.clientip != null)
				return false;
		} else if (!clientip.equals(other.clientip))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
}
