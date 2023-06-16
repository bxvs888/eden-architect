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

package org.ylzl.eden.common.mq.spring.boot.autoconfigure.condition;

import org.apache.rocketmq.spring.autoconfigure.RocketMQProperties;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * 消息队列装配条件
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
public class OnMessageQueueCondition extends AnyNestedCondition {

	public OnMessageQueueCondition() {
		super(ConfigurationPhase.REGISTER_BEAN);
	}

	public OnMessageQueueCondition(ConfigurationPhase configurationPhase) {
		super(ConfigurationPhase.REGISTER_BEAN);
	}

	@ConditionalOnExpression("${rocketmq.enabled:true}")
	@ConditionalOnBean(RocketMQProperties.class)
	@ConditionalOnClass(RocketMQTemplate.class)
	static class OnRocketMQCondition {
	}

	@ConditionalOnExpression("${spring.kafka.enabled:true}")
	@ConditionalOnBean(KafkaProperties.class)
	@ConditionalOnClass(KafkaTemplate.class)
	static class OnKafkaCondition {
	}
}
