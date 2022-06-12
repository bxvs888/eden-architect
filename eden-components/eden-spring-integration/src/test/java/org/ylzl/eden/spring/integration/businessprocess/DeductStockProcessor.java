package org.ylzl.eden.spring.integration.businessprocess;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.ylzl.eden.spring.integration.businessprocess.executor.RollbackProcessor;
import org.ylzl.eden.spring.integration.businessprocess.process.ProcessContext;

/**
 * 锁定库存
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
@Slf4j
@Component
public class DeductStockProcessor extends RollbackProcessor<Order> {

	/**
	 * 执行流程
	 *
	 * @param context 上下文
	 */
	@Override
	protected void process(ProcessContext<Order> context) {
		Order order = context.getData();
		int stock = order.getStock();
		stock--;
		order.setStock(stock);
		log.info("预扣库存, orderNo: {}, stock: {}", order.getOrderNo(), order.getStock());
	}

	/**
	 * 回滚流程
	 *
	 * @param context 上下文
	 */
	@Override
	public void rollback(ProcessContext<Order> context) {
		Order order = context.getData();
		int stock = order.getStock();
		stock++;
		order.setStock(stock);
		log.info("释放库存, orderNo: {}, stock: {}", order.getOrderNo(), order.getStock());
	}
}
