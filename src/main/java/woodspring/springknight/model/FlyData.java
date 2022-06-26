package woodspring.springknight.model;

public class FlyData {
	int pId;
	int lId;
	double mean;
	double variance;
	double sD;
	double confd99Up;
	double confd99Low;
	long pTime;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	public double getVariance() {
		return variance;
	}
	public void setVariance(double variance) {
		this.variance = variance;
	}
	public double getsD() {
		return sD;
	}
	public void setsD(double sD) {
		this.sD = sD;
	}
	public double getConfd99Up() {
		return confd99Up;
	}
	public void setConfd99Up(double confd99Up) {
		this.confd99Up = confd99Up;
	}
	public double getConfd99Low() {
		return confd99Low;
	}
	public void setConfd99Low(double confd99Low) {
		this.confd99Low = confd99Low;
	}
	public long getpTime() {
		return pTime;
	}
	public void setpTime(long pTime) {
		this.pTime = pTime;
	}
	@Override
	public String toString() {
		return "FlyData [pId=" + pId + ", lId=" + lId + ", mean=" + mean + ", variance=" + variance + ", sD=" + sD
				+ ", confd99Up=" + confd99Up + ", confd99Low=" + confd99Low + ", pTime=" + pTime + "]";
	}

}
