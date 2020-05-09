package org.societe.generale.processes;

import org.societe.generale.entities.Account;
import org.societe.generale.entities.Transaction;

public aspect withdrawAspect {
 
    pointcut check(Account account, Transaction transaction) : 
    	call(boolean MoneyProcessImpl.withdraw(Account, Transaction)) && args(account, transaction) && target(transaction);
 
    before(Account account, Transaction transaction) : check(amount, transaction) {
    }
 
    boolean around(Account account, Transaction transaction) : check(amount, transaction) {
        return proceed(amount);
    }
 
    after(Account account, Transaction transaction) : check(amount) {
    }

}
