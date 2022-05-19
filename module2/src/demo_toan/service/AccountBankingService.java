package demo_toan.service;

import demo_toan.exception.NotFoundBankAccountException;
import demo_toan.model.AccountBanking;
import demo_toan.model.AccountPayment;
import demo_toan.model.AccountSaving;
import demo_toan.util.FileHelper;
import demo_toan.util.ConstantUtils;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountBankingService {
    public AccountBankingService() {
        accountBankingList = mapToAccountBankingList();
    }

    public List<AccountBanking> accountBankingList = new ArrayList<AccountBanking>();
    FileHelper fileHelper = new FileHelper();
    public void create(AccountBanking accountBanking) {
        int lastId = 0;
        if (accountBankingList.size() > 0) {
            lastId = accountBankingList.get(accountBankingList.size() - 1).getId();
        }
        accountBanking.setId(lastId + 1);
        accountBankingList.add(accountBanking);
        fileHelper.write(ConstantUtils.path, Collections.singletonList(accountBanking), true);
    }

    public List findAll() {
        return accountBankingList;
    }

    public List<AccountBanking> searchByName(String name) {
        List<AccountBanking> result = new ArrayList<>();
        for (AccountBanking account : accountBankingList) {
            if (account.getName().contains(name)) {
                result.add(account);
            }
        }
        return result;
    }
    private List mapToAccountBankingList(){
        List result = new ArrayList();
        List<String> lines = fileHelper.read(ConstantUtils.path);
        for (String line : lines){
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            String accountCode = tmp[1];
            String name = tmp[2];
            String dateCreate = tmp[3];

            AccountBanking accountBanking;
            if(tmp.length == 8){
                double moneySaving = Double.parseDouble(tmp[4]);
                String dateSaving = tmp[5];
                Double rate = Double.parseDouble(tmp[6]);
                int period = Integer.parseInt(tmp[7]);
                accountBanking = new AccountSaving(id, accountCode, name, dateCreate, moneySaving, dateSaving, rate, period);
            }
            else{
                String numberCard = tmp[4];
                Double moneyInCard = Double.parseDouble(tmp[5]);
                accountBanking = new AccountPayment(id, accountCode, name, dateCreate,numberCard, moneyInCard);
            }

            result.add(accountBanking);
        }

        return result;
    }
    public void delete(String accountCode) throws NotFoundBankAccountException {
        if(!accountBankingList.removeIf(e-> e.getAccount().equals(accountCode))) {
            throw new NotFoundBankAccountException("Account code " + accountCode + " couldn't found ");
        }
        fileHelper.write(ConstantUtils.path, accountBankingList, false);
    }
}
