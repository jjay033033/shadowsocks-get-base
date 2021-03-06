package top.lmoon.shadowsupdate;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import top.lmoon.shadowsupdate.util.HttpUtil;
import top.lmoon.shadowsupdate.vo.ConfVO;

/**
 * ss from json工具入口类<br>
 * 用法：获取账号列表时执行getConfList()
 * 
 * @author LMoon
 * @date 2018年8月9日
 *
 */
public class ShadowsupdateFrowJson {
	
	private ShadowsupdateFrowJson(){};
	
	public static ShadowsupdateFrowJson getInstance(){
		return instanceHandler.instance;
	}
	
	private static class instanceHandler{
		public static final ShadowsupdateFrowJson instance = new ShadowsupdateFrowJson();
	}

	/**
	 * 获取ss账号列表
	 * @return
	 */
	public List<ConfVO> getConfList() {
		List<ConfVO> list = new ArrayList<ConfVO>();
		try {
//			String jsonStr = HttpUtil.get("https://free-ss.site/ss.json?_="+System.currentTimeMillis());
			String jsonStr = "{\"data\": [[\"10/10/10/10\", \"60.149.166.211\", \"13437\", \"chacha20\", \"29816846\", \"15:15:02\", \"JP\"], [\"10/10/10/10\", \"191.41.17.236\", \"19843\", \"rc4-md5\", \"86231655\", \"15:15:02\", \"SG\"], [\"10/10/10/10\", \"124.4.66.156\", \"16202\", \"rc4-md5\", \"11317521\", \"15:15:02\", \"JP\"], [\"10/10/10/10\", \"133.24.127.161\", \"15653\", \"chacha20\", \"12767086\", \"15:15:02\", \"SG\"], [\"10/10/10/10\", \"156.230.218.209\", \"15378\", \"rc4-md5\", \"52566129\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"56.34.162.167\", \"18308\", \"chacha20\", \"29407582\", \"15:15:02\", \"JP\"], [\"10/10/10/10\", \"124.114.243.188\", \"16718\", \"aes-256-cfb\", \"11809647\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"50.137.54.203\", \"16926\", \"chacha20\", \"92659555\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"30.250.11.62\", \"19311\", \"rc4-md5\", \"25067501\", \"15:15:02\", \"SG\"], [\"10/10/10/10\", \"77.227.61.49\", \"18031\", \"aes-256-cfb\", \"33102413\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"78.142.156.86\", \"16918\", \"aes-256-cfb\", \"80099411\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"33.176.48.87\", \"18858\", \"aes-256-cfb\", \"89601381\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"223.150.207.200\", \"13960\", \"aes-256-cfb\", \"92012823\", \"15:15:02\", \"SG\"], [\"10/10/10/10\", \"203.215.81.244\", \"13440\", \"aes-256-cfb\", \"20747923\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"35.85.99.139\", \"19325\", \"aes-256-cfb\", \"79074733\", \"15:15:02\", \"JP\"], [\"10/10/10/10\", \"114.140.150.55\", \"15614\", \"aes-256-cfb\", \"92718859\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"170.186.58.111\", \"11166\", \"aes-256-cfb\", \"59327307\", \"15:15:02\", \"SG\"], [\"10/10/10/10\", \"29.112.235.179\", \"18643\", \"aes-256-cfb\", \"97055003\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"156.160.69.212\", \"19247\", \"aes-256-cfb\", \"50197131\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"62.94.119.214\", \"19516\", \"aes-256-cfb\", \"74712547\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"19.239.152.167\", \"17973\", \"chacha20\", \"99773821\", \"15:15:02\", \"US\"]]}";
			JSONObject jo = JSONObject.parseObject(jsonStr);
			JSONArray data = jo.getJSONArray("data");
			for(int i=0;i<data.size();i++){
				JSONArray ja = data.getJSONArray(i);
				//["10/10/10/10", "60.149.166.211", "13437", "chacha20", "29816846", "15:15:02", "JP"]
				if(ja.size()!=7){
					continue;
				}
				ConfVO vo = new ConfVO();
				vo.setServer(ja.getString(1));
				vo.setServer_port(ja.getIntValue(2));
				vo.setMethod(ja.getString(3));
				vo.setPassword(ja.getString(4));
				vo.setRemarks(ja.getString(6));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public static void main(String[] args) {						
		String jsonStr = "{\"data\": [[\"10/10/10/10\", \"60.149.166.211\", \"13437\", \"chacha20\", \"29816846\", \"15:15:02\", \"JP\"], [\"10/10/10/10\", \"191.41.17.236\", \"19843\", \"rc4-md5\", \"86231655\", \"15:15:02\", \"SG\"], [\"10/10/10/10\", \"124.4.66.156\", \"16202\", \"rc4-md5\", \"11317521\", \"15:15:02\", \"JP\"], [\"10/10/10/10\", \"133.24.127.161\", \"15653\", \"chacha20\", \"12767086\", \"15:15:02\", \"SG\"], [\"10/10/10/10\", \"156.230.218.209\", \"15378\", \"rc4-md5\", \"52566129\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"56.34.162.167\", \"18308\", \"chacha20\", \"29407582\", \"15:15:02\", \"JP\"], [\"10/10/10/10\", \"124.114.243.188\", \"16718\", \"aes-256-cfb\", \"11809647\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"50.137.54.203\", \"16926\", \"chacha20\", \"92659555\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"30.250.11.62\", \"19311\", \"rc4-md5\", \"25067501\", \"15:15:02\", \"SG\"], [\"10/10/10/10\", \"77.227.61.49\", \"18031\", \"aes-256-cfb\", \"33102413\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"78.142.156.86\", \"16918\", \"aes-256-cfb\", \"80099411\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"33.176.48.87\", \"18858\", \"aes-256-cfb\", \"89601381\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"223.150.207.200\", \"13960\", \"aes-256-cfb\", \"92012823\", \"15:15:02\", \"SG\"], [\"10/10/10/10\", \"203.215.81.244\", \"13440\", \"aes-256-cfb\", \"20747923\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"35.85.99.139\", \"19325\", \"aes-256-cfb\", \"79074733\", \"15:15:02\", \"JP\"], [\"10/10/10/10\", \"114.140.150.55\", \"15614\", \"aes-256-cfb\", \"92718859\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"170.186.58.111\", \"11166\", \"aes-256-cfb\", \"59327307\", \"15:15:02\", \"SG\"], [\"10/10/10/10\", \"29.112.235.179\", \"18643\", \"aes-256-cfb\", \"97055003\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"156.160.69.212\", \"19247\", \"aes-256-cfb\", \"50197131\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"62.94.119.214\", \"19516\", \"aes-256-cfb\", \"74712547\", \"15:15:02\", \"US\"], [\"10/10/10/10\", \"19.239.152.167\", \"17973\", \"chacha20\", \"99773821\", \"15:15:02\", \"US\"]]}";
		System.out.println(getInstance().getConfList());
	}

}
