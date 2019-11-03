package ingredient;

import java.util.Calendar;


public abstract class Ingredient {

    protected String name;
    protected Calendar productionDate;//生产日期
    protected int storageLife;//保质期

    @Override
    public String toString() {
        return "配料信息{" +
                "配料名字：'" + name + '\'' +
                ", 生产日期：" + productionDate.getTime() +
                ", 保质期：" + storageLife + "天" +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Calendar productionDate) {
        this.productionDate = productionDate;
    }

    public int getStorageLife() {
        return storageLife;
    }

    public void setStorageLife(int storageLife) {
        this.storageLife = storageLife;
    }

    public Ingredient(String name, Calendar productionDate, int storageLife) {
        this.name = name;
        this.productionDate = productionDate;
        this.storageLife = storageLife;
    }

    public Ingredient() {
    }

    /**
     * 获取过期日期
     * @return 过期日期
     */
    public Calendar getExpireTime(){
        Calendar expireTime=(Calendar) productionDate.clone();
        expireTime.add(Calendar.DATE,storageLife);
        return expireTime;
    }
}
