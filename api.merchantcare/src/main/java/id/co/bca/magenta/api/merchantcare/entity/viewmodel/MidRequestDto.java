package id.co.bca.magenta.api.merchantcare.entity.viewmodel;

import java.util.Arrays;

public class MidRequestDto {
	String[] mid;

	public String[] getMid() {
		return mid;
	}

	public void setMid(String[] mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mid [mid=");
		builder.append(Arrays.toString(mid));
		builder.append("]");
		return builder.toString();
	}


}
