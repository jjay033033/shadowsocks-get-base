package priv.lmoon.shadowsupdate.config.inithandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import priv.lmoon.shadowsupdate.util.XmlUtil;

public abstract class FileConfigLoaderInitHandler implements ConfigLoaderInitHandler{
	
	private String configPath;
	
	private long lastModify;

	public FileConfigLoaderInitHandler(String configPath, long lastModify) {
		super();
		this.configPath = configPath;
		this.lastModify = lastModify;
	}

	@Override
	public Map<?,?> getXmlMap() {
		Map<?,?> map = new HashMap<>();
		if (configPath == null) {
			return map;
		}
		File file = new File(configPath);
		if (!file.exists()) {
			throw new RuntimeException("file = " + configPath + " is not exist!");
		}
		if (file.lastModified() == lastModify) {
			return map;
		}
		lastModify = file.lastModified();
		try {
			FileInputStream fis = new FileInputStream(file);
			map = XmlUtil.toMap(fis);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("config.xml初始化失败:", e);
		}
		return map;
	}

	@Override
	public boolean needSchedule() {
		return true;
	}

}
