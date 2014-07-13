package com.fenghua.ostools.runner;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import com.fenghua.ostools.util.StrUtils;

public class ShutDowRunner implements CmdRunner {

	public void runCmd(Map<String, String> params) throws Exception {

		Date date = null;
		while (true) {
			date = new Date(System.currentTimeMillis());
			if (date.getHours() == StrUtils.parseToInt(params.get("hour"), 0)
					&& date.getMinutes() == StrUtils.parseToInt(
							params.get("minite"), 0)) {
				// shutdown [-i | -l | -s | -r | -a] [-f] [-m
				// \\computername] [-t xx] [-c "comment"] [-d up:xx:yy]
				//
				// 没有参数 显示此消息(与 ? 相同)
				// -i 显示 GUI 界面，必须是第一个选项
				// -l 注销(不能与选项 -m 一起使用)
				// -s 关闭此计算机
				// -r 关闭并重启动此计算机
				// -a 放弃系统关机
				// -m \\computername 远程计算机关机/重启动/放弃
				// -t xx 设置关闭的超时为 xx 秒
				// -c "comment" 关闭注释(最大 127 个字符)
				// -f 强制运行的应用程序关闭而没有警告
				// -d [p]:xx:yy 关闭原因代码
				// u 是用户代码
				// p 是一个计划的关闭代码
				// xx 是一个主要原因代码(小于 256 的正整数)
				// yy 是一个次要原因代码(小于 65536 的正整数)
				//
				// 　　-f：强行关闭应用程序
				//
				// 　　-m ＼＼计算机名：控制远程计算机
				//
				// 　　-i：显示图形用户界面，但必须是Shutdown的第一个选项
				//
				// 　　-l：注销当前用户
				//
				// 　　-r：关机并重启
				//
				// 　　-t时间：设置关机倒计时
				//
				// 　　-c "消息内容"：输入关机对话框中的消息内容(不能超127个字符)
				runCmd(null, "shutdown -s -f");
				return;
			}
			try {
				Thread.currentThread().sleep(1000 * 30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 运行一个命令
	 * 
	 * @param resultSteam
	 *            将会此命令时候的控制台输出写入此流，这个流是可以传null的
	 * @param cmd
	 *            待运行的命令 不能为null或""
	 * @throws Exception
	 */
	public static final void runCmd(OutputStream resultSteam, String cmd)
			throws Exception {
		if (StrUtils.isNullStr(cmd)) {
			throw new Exception("命令不能为空");
		}
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			PrintWriter writer = new PrintWriter(process.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
