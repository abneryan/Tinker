package com.anber.tinker.network.listener;

/**********************************************************
 * @文件名称：DisposeDataListener.java
 * @文件描述：业务逻辑层真正处理的地方，包括java层异常和业务层异常
 **********************************************************/
public interface DisposeDataListener {

	/**
	 * 请求成功回调事件处理
	 */
	public void onSuccess(Object responseObj);

	/**
	 * 请求失败回调事件处理
	 */
	public void onFailure(Object reasonObj);

}
