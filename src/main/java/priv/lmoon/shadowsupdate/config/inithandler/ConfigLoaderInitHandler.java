package priv.lmoon.shadowsupdate.config.inithandler;

import java.util.Map;

public interface ConfigLoaderInitHandler {

	Map<?,?> getXmlMap();

	boolean needSchedule();

}
