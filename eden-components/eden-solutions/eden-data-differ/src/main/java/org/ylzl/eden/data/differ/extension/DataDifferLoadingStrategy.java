/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ylzl.eden.data.differ.extension;

import org.ylzl.eden.extension.strategy.LoadingStrategy;

/**
 * 数据比对扩展点加载策略
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
public class DataDifferLoadingStrategy implements LoadingStrategy {

	public static final String META_INF = "META-INF/data-differ/";

	@Override
	public String directory() {
		return META_INF;
	}

	@Override
	public int getPriority() {
		return MAX_PRIORITY;
	}
}
