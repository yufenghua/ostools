package com.fenghua.ostools.main;

import com.fenghua.ostools.config.CmdConfig;
import com.fenghua.ostools.mgr.CmdMgr;
import com.fenghua.ostools.runner.ShutDowRunner;

/**
 * Èë¿ÚÀà
 * 
 * @author Qiaolin Pan
 * 
 */
public class Main {
	public static void main(String[] args) throws Exception {
		CmdMgr mgr = new CmdMgr();
		mgr.regCmd(new CmdConfig(), new ShutDowRunner());
	}
}
