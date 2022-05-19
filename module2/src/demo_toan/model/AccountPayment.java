package demo_toan.model;

public class AccountPayment extends AccountBanking {
    private String numberCard;
    private double moneyInCard;

    public AccountPayment(int id, String account, String name, String dateCreate, String numberCard, double moneyInCard) {
        super(id, account, name, dateCreate);
        this.numberCard = numberCard;
        this.moneyInCard = moneyInCard;
    }

    public AccountPayment(String numberCard, double moneyInCard) {
        this.numberCard = numberCard;
        this.moneyInCard = moneyInCard;
    }

    public AccountPayment() {
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public double getMoneyInCard() {
        return moneyInCard;
    }

    public void setMoneyInCard(double moneyInCard) {
        this.moneyInCard = moneyInCard;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%f", super.toString(), numberCard, moneyInCard);
    }
}
