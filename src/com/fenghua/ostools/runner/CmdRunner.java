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
	 * ִ������
	 * 
	 * @param params
	 *            ִ������Ĳ���
	 * @throws Exception
	 */
	public void runCmd(Map<String, String> params) throws Exception;

}
