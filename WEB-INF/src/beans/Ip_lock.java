package beans;

public class Ip_lock{


	private String ip = null;
	private int fail_count = 0;
	
	public Ip_lock(){
		
	}
	
	
	public Ip_lock(String ip, int fail_count) {
		this.ip = ip;
		this.fail_count = fail_count;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public int getFail_count() {
		return fail_count;
	}


	public void setFail_count(int fail_count) {
		this.fail_count = fail_count;
	}
	
	
}