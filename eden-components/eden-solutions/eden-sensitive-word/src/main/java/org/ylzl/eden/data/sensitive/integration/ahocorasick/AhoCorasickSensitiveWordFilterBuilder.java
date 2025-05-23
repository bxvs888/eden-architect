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

package org.ylzl.eden.data.sensitive.integration.ahocorasick;

import org.ahocorasick.trie.Trie;
import org.ylzl.eden.data.sensitive.SensitiveWordFilter;
import org.ylzl.eden.data.sensitive.builder.AbstractSensitiveWordFilterBuilder;
import org.ylzl.eden.data.sensitive.builder.SensitiveWordFilterBuilder;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * AhoCorasick 敏感词过滤构建器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
public class AhoCorasickSensitiveWordFilterBuilder extends AbstractSensitiveWordFilterBuilder implements SensitiveWordFilterBuilder {

	private Trie trie;

	private static final AtomicBoolean BUILD_STATE = new AtomicBoolean(false);

	/**
	 * 构建敏感词过滤器
	 *
	 * @return 敏感词过滤器
	 */
	@Override
	public SensitiveWordFilter build() {
		if (BUILD_STATE.compareAndSet(false, true)) {
			trie = Trie.builder()
				.addKeywords(getSensitiveWordLoader().loadSensitiveWords())
				.build();
		}
		return new AhoCorasickSensitiveWordFilter(trie);
	}
}
