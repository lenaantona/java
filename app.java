public class app {
  public static void main(String[] args) {
    Goods currentGoods = new Goods();
    currentGoods.print();

    currentGoods = new CreateGoods()
        .setName("Мыло")
        .setCount(1)
        .setPrice(52.23)
        //.setDescription("мыло банное")
        .Create();

    currentGoods.print();
  }

}
