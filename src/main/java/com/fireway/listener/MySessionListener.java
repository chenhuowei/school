package com.fireway.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.fireway.utils.LogUtil;

public class MySessionListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent event) {
		LogUtil.info(getClass(), event.getValue()+"添加...");
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		LogUtil.info(getClass(), event.getValue()+"移除...");
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		LogUtil.info(getClass(), event.getValue()+"替代...");
	}

	

}
