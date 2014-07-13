package com.fenghua.ostools.main;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fenghua.ostools.config.CmdConfig;
import com.fenghua.ostools.mgr.CmdMgr;
import com.fenghua.ostools.runner.ShutDowRunner;

/**
 * 入口类
 * 
 * @author Qiaolin Pan
 * 
 */
public class Main {
	public static void main(String[] args) throws Exception {
		// 测试代码
		// 理论情况要做如下几件事情：获取命令的配置信息;x向用户展示数据列表;用户选定命令;用户输入参数，执行时间
		final CmdMgr mgr = new CmdMgr();
		mgr.regCmd(new CmdConfig("shutdown"), new ShutDowRunner());
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		cachedThreadPool.submit(new Runnable() {
			public void run() {
				Map<String, String> map = new HashMap<String, String>();
				map.put("hour", String.valueOf(0));
				map.put("minite", String.valueOf(30));
				try {
					mgr.getRunner("shutdown").runCmd(map);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}
}
