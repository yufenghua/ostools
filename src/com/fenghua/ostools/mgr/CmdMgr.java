package com.fenghua.ostools.mgr;

import java.util.HashMap;
import java.util.Map;

import com.fenghua.ostools.config.CmdConfig;
import com.fenghua.ostools.runner.CmdRunner;

/**
 * √¸¡Óπ‹¿Ì¿‡
 * 
 * @author Qiaolin Pan
 * 
 */
public class CmdMgr {
	/**
	 * cmdmap
	 */
	private Map<CmdConfig, CmdRunner> cmdMaps = new HashMap<CmdConfig, CmdRunner>();

	/**
	 * 
	 * @param config
	 * @param runner
	 */
	public void regCmd(CmdConfig config, CmdRunner runner) {
		cmdMaps.put(config, runner);
	}

}
