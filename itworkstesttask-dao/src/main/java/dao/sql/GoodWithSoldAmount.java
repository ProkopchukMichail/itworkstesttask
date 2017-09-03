package dao.sql;

/**
 * Created by comp on 03.09.2017.
 */
public class GoodWithSoldAmount {
    Integer goodId,typeId,amount;
    String name;

    public GoodWithSoldAmount() {
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getAmount() {
        return amount;
    }


    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "GoodWithSoldAmount{" +
                "goodId=" + goodId +
                ", typeId=" + typeId +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodWithSoldAmount)) return false;

        GoodWithSoldAmount that = (GoodWithSoldAmount) o;

        if (getGoodId() != null ? !getGoodId().equals(that.getGoodId()) : that.getGoodId() != null) return false;
        if (getTypeId() != null ? !getTypeId().equals(that.getTypeId()) : that.getTypeId() != null) return false;
        if (getAmount() != null ? !getAmount().equals(that.getAmount()) : that.getAmount() != null) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getGoodId() != null ? getGoodId().hashCode() : 0;
        result = 31 * result + (getTypeId() != null ? getTypeId().hashCode() : 0);
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
