package priv.lmoon.shadowsupdate.config.inithandler;

import java.util.Map;

public interface ConfigLoaderInitHandler {
	
	void init();

	Map<?,?> getXmlMap();

	boolean needSchedule();

}
