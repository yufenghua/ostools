package com.fenghua.ostools.runner;

import java.util.Map;

/**
 * the cmd runners
 * 
 * @author Qiaolin Pan
 * 
 */
public interface CmdRunner {
	/**
	 * 执行命令
	 * 
	 * @param params
	 *            执行命令的参数
	 * @throws Exception
	 */
	public void runCmd(Map<String, String> params) throws Exception;

}
