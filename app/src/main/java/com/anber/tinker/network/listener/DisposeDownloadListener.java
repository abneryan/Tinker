package com.anber.tinker.network.listener;

/**
 * @author vision
 * @function 监听下载进度
 */
public interface DisposeDownloadListener extends DisposeDataListener {
	 void onProgress(int progrss);
}
