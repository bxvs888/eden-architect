package org.ylzl.eden.spring.cloud.zookeeper.core;

import org.ylzl.eden.spring.framework.error.BaseException;

/**
 * Zookeeper 异常
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
public class ZookeeperException extends BaseException {

	public ZookeeperException(String errMessage) {
		super("C0100", errMessage);
	}
}