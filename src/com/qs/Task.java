package com.qs;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Task implements Runnable {

	private Socket clientSocket;
	private int milli;
	private boolean completed;
	private volatile boolean runsignal=true;

	/**
	 * @return the milli
	 */
	public int getMilli() {
		return milli;
	}

	/**
	 * @param milli the milli to set
	 */
	public void setMilli(int milli) {
		this.milli = milli;
	}

	Task(Socket clientSocket, int seconds,long currenTime) {
		this.clientSocket = clientSocket;
		this.milli = seconds * 1000;
		currenTime = currenTime + this.milli;
	}

	/**
	 * @return the completed
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * @param completed the completed to set
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public void run() {
		while(runsignal){
			try {
				Thread.sleep(milli);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
				output.write("{stat:ok}");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					completed=true;
					runsignal = false;
					clientSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


	}

}
