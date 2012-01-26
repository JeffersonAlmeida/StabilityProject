package stability.mot.followUp;

public class Tombstone {
	
	private String directory;
	private String reportName;
	private String testCase;
	private String tipo;
	private String pid;
	private String tid;
	private String line;
	private String device;
	
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getTestCase() {
		return testCase;
	}
	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	@Override
	public String toString() {
		return "Tombstone [directory=" + directory + ", reportName="
				+ reportName + ", testCase=" + testCase + ", tipo=" + tipo
				+ ", pid=" + pid + ", tid=" + tid + ", line=" + line
				+ ", device=" + device + "]";
	}
	
	
	
}
