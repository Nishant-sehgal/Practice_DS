package com.qs;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) {
	}

	private Map<Integer, Task> map = new HashMap<>();

	public void implementSleepRequest(Map<String, String> paramMap, Socket clientSocket) {
		/*
		 * You need to Retrieve connid and timeout from paramsMap and implement
		 * the handling for the GET /sleep method
		 */

		// Your code goes here.
		Integer timeOut = -1;
		Integer connid = -1;
		if (null != paramMap && !paramMap.isEmpty()) {
			if (paramMap.containsKey("timeout")) {
				timeOut = Integer.parseInt(paramMap.get("timeout"));
			}
			if (paramMap.containsKey("connid")) {
				connid = Integer.parseInt(paramMap.get("connid"));
			}
		}
		Task task = new Task(clientSocket, timeOut, System.currentTimeMillis());
		Thread request = new Thread(task);
		request.start();
		map.put(connid, task);
	}

	public void implementGetServerStatusRequest(Socket clientSocket) {
		Map<Integer, Long> outputMap = new HashMap<>();
		for (Entry<Integer, Task> entry : map.entrySet()) {
			int conId = entry.getKey();
			Task task = entry.getValue();
			if (task.isCompleted()) {
				long val = task.getMilli() - System.currentTimeMillis();
				if (val > 0) {
					outputMap.put(conId, val / 1000);
				}
			}

		}
		System.out.println(outputMap);
		PrintWriter output = null;
		try {
			output = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		output.write(outputMap.toString());
		// Your code goes here.
	}
		
}
