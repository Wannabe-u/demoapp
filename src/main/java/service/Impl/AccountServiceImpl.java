package service.Impl;

import dao.IAccountdao;
import domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import service.AccountService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    private IAccountdao iaccountdao;

    @Override
    public List<Account> findAll() {
        System.out.println("Service业务层：查询所有账户");
        return iaccountdao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("保存账户");
    }
}
