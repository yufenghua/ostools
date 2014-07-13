package com.fenghua.ostools.mgr;

import java.util.HashMap;
import java.util.Map;

import com.fenghua.ostools.config.CmdConfig;
import com.fenghua.ostools.runner.CmdRunner;

/**
 * ���������
 * 
 * @author Qiaolin Pan
 * 
 */
public class CmdMgr {
	/**
	 * cmdmap
	 */
	private Map<String, CmdRunner> cmdMaps = new HashMap<String, CmdRunner>();
	private Map<String, CmdConfig> configMap = new HashMap<String, CmdConfig>();

	/**
	 * 
	 * @param config
	 * @param runner
	 */
	public void regCmd(CmdConfig config, CmdRunner runner) {
		cmdMaps.put(config.getCmd(), runner);
		configMap.put(config.getCmd(), config);
	}

	/**
	 * ��ȡrunner
	 * 
	 * @param cmd
	 * @return
	 */
	public CmdRunner getRunner(String cmd) {
		return cmdMaps.get(cmd);
	}

}
