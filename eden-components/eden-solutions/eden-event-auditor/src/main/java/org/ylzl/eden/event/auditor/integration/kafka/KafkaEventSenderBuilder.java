
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

package org.ylzl.eden.event.auditor.integration.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.ylzl.eden.event.auditor.EventSender;
import org.ylzl.eden.event.auditor.builder.AbstractEventSenderBuilder;
import org.ylzl.eden.event.auditor.builder.EventSenderBuilder;
import org.ylzl.eden.event.auditor.config.EventAuditorConfig;
import org.ylzl.eden.spring.framework.beans.ApplicationContextHelper;

/**
 * 基于 Kafka 发送审计事件构建器
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@Slf4j
public class KafkaEventSenderBuilder extends AbstractEventSenderBuilder implements EventSenderBuilder {

	/**
	 * 构建事件审计实例
	 *
	 * @return 事件审计实例
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EventSender build() {
		KafkaTemplate<String, String> kafkaTemplate = ApplicationContextHelper.getBean(KafkaTemplate.class);
		EventAuditorConfig.Sender.Kafka config = this.getEventAuditorConfig().getSender().getKafka();
		return new KafkaEventSender(kafkaTemplate, config.getTopic());
	}
}
