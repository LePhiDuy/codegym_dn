package demo_toan.model;

public class AccountSaving extends AccountBanking{
    private double moneySave;
    private String dateSaving;
    private double rate;
    private int period;

    public AccountSaving(int id, String account, String name, String dateCreate, double moneySave, String dateSaving, double rate, int period) {
        super(id, account, name, dateCreate);
        this.moneySave = moneySave;
        this.dateSaving = dateSaving;
        this.rate = rate;
        this.period = period;
    }

    public AccountSaving(double moneySave, String dateSaving, double rate, int period) {
        this.moneySave = moneySave;
        this.dateSaving = dateSaving;
        this.rate = rate;
        this.period = period;
    }

    public AccountSaving() {
    }

    public double getMoneySave() {
        return moneySave;
    }

    public void setMoneySave(double moneySave) {
        this.moneySave = moneySave;
    }

    public String getDateSaving() {
        return dateSaving;
    }

    public void setDateSaving(String dateSaving) {
        this.dateSaving = dateSaving;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return String.format("%s,%f,%s,%f,%d", super.toString(), moneySave, dateSaving, rate, period);
    }
}
