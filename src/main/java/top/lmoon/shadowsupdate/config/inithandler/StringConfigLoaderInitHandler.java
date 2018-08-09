package top.lmoon.shadowsupdate.config.inithandler;

import java.util.Map;

import top.lmoon.shadowsupdate.util.XmlUtil;

public class StringConfigLoaderInitHandler implements ConfigLoaderInitHandler{
	
	private String xmlStr;

	public StringConfigLoaderInitHandler(String xmlStr) {
		super();
		this.xmlStr = xmlStr;
	}

	@Override
	public Map<?,?> getXmlMap() {
		Map<?,?> map = XmlUtil.toMap(xmlStr);
		return map;
	}

	@Override
	public boolean needSchedule() {
		return false;
	}

}
