public class CreateGoods {

  Goods temp;

  public CreateGoods() {
    temp = new Goods();
    temp.name = "нет данных";
    temp.count = -1;
    temp.price = -2;
    temp.description = "нет данных";
    
  }
  public CreateGoods setName(String name) {
    temp.name = name;
    return this;
  }

  public CreateGoods setCount(int count) {
    temp.count = count;
    return this;
  }

  public CreateGoods setPrice(double price) {
    temp.price = price;
    return this;
  }

  public CreateGoods setDescription(String description) {
    temp.description = description;
    return this;
  }

  public Goods Create() {
    return temp;
  }
}
