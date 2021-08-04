package id.co.bca.magenta.api.merchantcare.entity.viewmodel;

import java.util.List;

public class TerminalViewModel {
	private String mid;
	private List<String> terminal;

	public TerminalViewModel(String mid, List<String> terminal) {
		super();
		this.mid = mid;
		this.terminal = terminal;
	}

	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public List<String> getTerminal() {
		return terminal;
	}
	public void setTerminal(List<String> terminal) {
		this.terminal = terminal;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TerminalViewModel [mid=");
		builder.append(mid);
		builder.append(", terminal=");
		builder.append(terminal);
		builder.append("]");
		return builder.toString();
	}

}
