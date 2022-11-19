public class Goods {
    String name;
    double price;
    int count;
    String description;
    
    class ProxyName {
    String val;

    public ProxyName(String v) {
        this.val = v != null ? v : "EMPTY";

        if (v != null)
        this.val = v;
        else
        this.val = "EMPTY";
    }

    public String getVal() {
        return val;
          }
    }
    public void print() {
        System.out.println(
            String.format(
                "наименование: %s кол-во: %d цена: %.2f описание: %s",
                this.name,
                this.count,
                this.price,
                this.description));
      }
}     
