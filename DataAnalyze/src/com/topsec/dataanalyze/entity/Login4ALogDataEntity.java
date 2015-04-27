package com.topsec.dataanalyze.entity;

public class Login4ALogDataEntity extends DataEntity{
	public String master;
	public String loginuser;
	public String srcip;
	public String dstip;
	public String time;
	public String action;
	public String sessionid;
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String username) {
		master = username;
	}
	public String getLoginuser() {
		return loginuser;
	}
	public void setLoginuser(String loginName) {
		loginuser = loginName;
	}
	public String getSrcip() {
		return srcip;
	}
	public void setSrcip(String clientip) {
		srcip = clientip;
	}
	public String getDstip() {
		return dstip;
	}
	public void setDstip(String serverip) {
		dstip = serverip;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time1) {
		time = time1;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String loginResult) {
		action = loginResult;
	}
	@Override
	public String toString() {
		return "NABHDataEntity [master=" + master + ", loginuser=" + loginuser
				+ ", srcip=" + srcip + ", dstip=" + dstip + ", time=" + time
				+ ", action=" + action + ", sessionid=" + sessionid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((dstip == null) ? 0 : dstip.hashCode());
		result = prime * result
				+ ((loginuser == null) ? 0 : loginuser.hashCode());
		result = prime * result + ((master == null) ? 0 : master.hashCode());
		result = prime * result
				+ ((sessionid == null) ? 0 : sessionid.hashCode());
		result = prime * result + ((srcip == null) ? 0 : srcip.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Login4ALogDataEntity other = (Login4ALogDataEntity) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (dstip == null) {
			if (other.dstip != null)
				return false;
		} else if (!dstip.equals(other.dstip))
			return false;
		if (loginuser == null) {
			if (other.loginuser != null)
				return false;
		} else if (!loginuser.equals(other.loginuser))
			return false;
		if (master == null) {
			if (other.master != null)
				return false;
		} else if (!master.equals(other.master))
			return false;
		if (sessionid == null) {
			if (other.sessionid != null)
				return false;
		} else if (!sessionid.equals(other.sessionid))
			return false;
		if (srcip == null) {
			if (other.srcip != null)
				return false;
		} else if (!srcip.equals(other.srcip))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
}
