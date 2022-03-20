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

package org.ylzl.eden.spring.framework.error;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.PropertyKey;
import org.ylzl.eden.spring.framework.cola.dto.Response;

/**
 * 异常抽象
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {

	private String errCode;

	private String errMessage;

	public BaseException(@PropertyKey(resourceBundle = ErrorConfig.BASE_NAME) String errCode, String errMessage) {
		super(errMessage);
		this.errCode = errCode;
		this.errMessage = errMessage;
	}

	public Response getResponse() {
		return Response.buildFailure(errCode, errMessage);
	}
}