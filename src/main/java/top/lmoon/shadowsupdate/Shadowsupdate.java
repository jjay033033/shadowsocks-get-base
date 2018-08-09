package top.lmoon.shadowsupdate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import top.lmoon.shadowsupdate.config.ConfigList;
import top.lmoon.shadowsupdate.config.ConfigListFactory;
import top.lmoon.shadowsupdate.config.XmlConfig;
import top.lmoon.shadowsupdate.config.inithandler.ConfigLoaderInitHandler;
import top.lmoon.shadowsupdate.vo.ConfVO;

/**
 * ss工具入口类<br>
 * 用法：必须先执行init()初始化，获取账号列表时执行getConfList()
 * 
 * @author LMoon
 * @date 2018年8月9日
 *
 */
public class Shadowsupdate {
	
	private Shadowsupdate(){};
	
	public static Shadowsupdate getInstance(){
		return instanceHandler.instance;
	}
	
	private static class instanceHandler{
		public static final Shadowsupdate instance = new Shadowsupdate();
	}

	/**
	 * 初始化方法
	 * @param initHandler
	 */
	public void init(ConfigLoaderInitHandler initHandler) {
		XmlConfig.init(initHandler);
	}

	/**
	 * 获取ss账号列表
	 * @return
	 */
	public List<ConfVO> getConfList() {
		List<ConfVO> list = new ArrayList<ConfVO>();
		ConfigList c;
		Map<String, ConfigList> cMap = ConfigListFactory.getConfigListMap();
		for (Iterator<Entry<String, ConfigList>> it = cMap.entrySet().iterator(); it.hasNext();) {
			c = it.next().getValue();
			if (c != null) {
				List<ConfVO> cList = c.getConfigList();
				if (cList != null && !cList.isEmpty()) {
					list.addAll(cList);
				}
			}
		}

		return list;
	}

}
