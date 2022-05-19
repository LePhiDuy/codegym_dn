package demo_toan.model;

public abstract class AccountBanking {
    private int id;
    private String account;
    private String name;
    private String dateCreate;

    public AccountBanking(int id, String account, String name, String dateCreate) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.dateCreate = dateCreate;
    }

    public AccountBanking() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s", id, account, name, dateCreate);
    }
}
