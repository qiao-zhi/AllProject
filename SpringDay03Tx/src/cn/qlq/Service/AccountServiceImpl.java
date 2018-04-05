package cn.qlq.Service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import cn.qlq.Dao.AccountDao;
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class AccountServiceImpl implements AccountService {

	
	private AccountDao ad;
	private TransactionTemplate transactionTemplate;
	
	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
/*	@Override
	public void transfer(final Integer from,final Integer to,final Double money) {
		// TODO Auto-generated method stub

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
						
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				//减钱
				ad.minusMoney(from, money);
				
				//假如中间出一个异常
				int i=1/0;
				
				//加钱
				ad.addMoney(to, money);
				
			}
		});

	}*/
	
	
	public AccountDao getAd() {
		return ad;
	}
	public void setAd(AccountDao ad) {
		this.ad = ad;
	}
	@Override
//	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void transfer(Integer from, Integer to, Double money) {
		// TODO Auto-generated method stub
		//减钱
		ad.minusMoney(from, money);
		
		//假如中间出一个异常
		int i=1/0;
		
		//加钱
		ad.addMoney(to, money);
	}

}
