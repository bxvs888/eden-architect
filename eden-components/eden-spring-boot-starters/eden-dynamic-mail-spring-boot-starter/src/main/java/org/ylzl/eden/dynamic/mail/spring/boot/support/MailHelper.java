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

package org.ylzl.eden.dynamic.mail.spring.boot.support;

import lombok.RequiredArgsConstructor;
import org.ylzl.eden.dynamic.mail.MailTemplate;
import org.ylzl.eden.spring.framework.beans.ApplicationContextHelper;
import org.ylzl.eden.spring.framework.error.util.AssertUtils;
import org.ylzl.eden.commons.lang.MessageFormatUtils;

/**
 * 邮件操作模板助手
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@RequiredArgsConstructor
public class MailHelper {

	private static final String BEAN_DEFINITION_NAMED_NOT_FOUND = "MailTemplate beanDefinition named '{}' not found";

	private final MailBeanNames primary;

	public MailTemplate getExecutor() {
		MailTemplate mailTemplate = ApplicationContextHelper.getBean(primary.getBeanName(), MailTemplate.class);
		AssertUtils.notNull(mailTemplate, "SYS-ERROR-500", BEAN_DEFINITION_NAMED_NOT_FOUND, primary.getBeanName());
		return mailTemplate;
	}

	public MailTemplate getExecutor(MailBeanNames mailBeanNames) {
		String beanName = mailBeanNames.getBeanName();
		MailTemplate mailTemplate = ApplicationContextHelper.getBean(beanName, MailTemplate.class);
		AssertUtils.notNull(mailTemplate, "SYS-ERROR-500",
			MessageFormatUtils.format(BEAN_DEFINITION_NAMED_NOT_FOUND, beanName));
		return mailTemplate;
	}
}