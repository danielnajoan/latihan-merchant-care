package id.co.bca.magenta.api.merchantcare.monitor.jamon;

import java.util.Date;

import com.jamonapi.MonitorComposite;

import id.co.bca.magenta.api.merchantcare.monitor.GlobalMonitorStatistics;
import id.co.bca.magenta.api.merchantcare.monitor.Monitor;
import id.co.bca.magenta.api.merchantcare.monitor.MonitorFactory;

public class JamonMonitorFactory implements MonitorFactory, GlobalMonitorStatistics {

	private com.jamonapi.MonitorFactoryInterface monitorFactory = com.jamonapi.MonitorFactory.getFactory();

	public Monitor start(String name) {
		return new JamonMonitor(monitorFactory.start(name));
	}

	public long getCallsCount() {
		return (long) getMonitors().getHits();
	}

	public long getTotalCallTime() {
		return (long) getMonitors().getTotal();
	}

	public Date getLastAccessTime() {
		return getMonitors().getLastAccess();
	}

	public MonitorComposite getMonitors() {
		return monitorFactory.getRootMonitor();
	}

	public long averageCallTime(String methodName) {
		return (long) monitorFactory.getMonitor(methodName, "ms.").getAvg();
	}

	public long callCount(String methodName) {
		return (long) monitorFactory.getMonitor(methodName, "ms.").getHits();
	}

	public long lastCallTime(String methodName) {
		return (long) monitorFactory.getMonitor(methodName, "ms.").getLastValue();
	}

	public long maximumCallTime(String methodName) {
		return (long) monitorFactory.getMonitor(methodName, "ms.").getMax();
	}

	public long minimumCallTime(String methodName) {
		return (long) monitorFactory.getMonitor(methodName, "ms.").getMin();
	}

	public long totalCallTime(String methodName) {
		return (long) monitorFactory.getMonitor(methodName, "ms.").getTotal();
	}

}
