/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ylzl.eden.spring.data.redis.serializer;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * Long Redis 序列化
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
public enum LongRedisSerializer implements RedisSerializer<Long> {

	INSTANCE;

	@Override
	public byte[] serialize(Long aLong) throws SerializationException {
		if (null != aLong) {
			return aLong.toString().getBytes();
		} else {
			return new byte[0];
		}
	}

	@Override
	public Long deserialize(byte[] bytes) throws SerializationException {
		if (bytes != null && bytes.length > 0) {
			return Long.parseLong(new String(bytes));
		} else {
			return null;
		}
	}
}
