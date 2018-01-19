package com.chnghx.utils;

import org.apache.commons.lang.RandomStringUtils;

public class RandomUtil {
	
	/**
	 * 生成随机数
	 * @param count 几位随机数
	 * @return
	 */
	public static String randomAlphanumeric(int count) {
		return RandomStringUtils.randomAlphanumeric(count);
	}

}
