package cn.qlq.chai;

import java.util.List;

/**
 * 
 * @author: qlq
 */
public class Chain {

	private List<ChainHandler> handlers;

	private int index = 0;

	public Chain(List<ChainHandler> handlers) {
		this.handlers = handlers;
	}

	public void proceed() {
		if (index >= handlers.size()) {
			return;
		}
		handlers.get(index++).execute(this);
	}
}
