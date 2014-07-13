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
				// û�в��� ��ʾ����Ϣ(�� ? ��ͬ)
				// -i ��ʾ GUI ���棬�����ǵ�һ��ѡ��
				// -l ע��(������ѡ�� -m һ��ʹ��)
				// -s �رմ˼����
				// -r �رղ��������˼����
				// -a ����ϵͳ�ػ�
				// -m \\computername Զ�̼�����ػ�/������/����
				// -t xx ���ùرյĳ�ʱΪ xx ��
				// -c "comment" �ر�ע��(��� 127 ���ַ�)
				// -f ǿ�����е�Ӧ�ó���رն�û�о���
				// -d [p]:xx:yy �ر�ԭ�����
				// u ���û�����
				// p ��һ���ƻ��Ĺرմ���
				// xx ��һ����Ҫԭ�����(С�� 256 ��������)
				// yy ��һ����Ҫԭ�����(С�� 65536 ��������)
				//
				// ����-f��ǿ�йر�Ӧ�ó���
				//
				// ����-m �ܣܼ������������Զ�̼����
				//
				// ����-i����ʾͼ���û����棬��������Shutdown�ĵ�һ��ѡ��
				//
				// ����-l��ע����ǰ�û�
				//
				// ����-r���ػ�������
				//
				// ����-tʱ�䣺���ùػ�����ʱ
				//
				// ����-c "��Ϣ����"������ػ��Ի����е���Ϣ����(���ܳ�127���ַ�)
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
	 * ����һ������
	 * 
	 * @param resultSteam
	 *            ���������ʱ��Ŀ���̨���д�������������ǿ��Դ�null��
	 * @param cmd
	 *            �����е����� ����Ϊnull��""
	 * @throws Exception
	 */
	public static final void runCmd(OutputStream resultSteam, String cmd)
			throws Exception {
		if (StrUtils.isNullStr(cmd)) {
			throw new Exception("�����Ϊ��");
		}
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			PrintWriter writer = new PrintWriter(process.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
