/// Написать программу, показывающую последовательность действий для игры "Ханойская башня"
public class Task4 {
    static void haino_tower(int count_disk, int pin1, int pin2) { ///метод для "Ханойской башни"
        if (count_disk == 1){
            System.out.printf("Переложить диск 1 с %d стержня на %d стержень.\n", pin1, pin2);
        }
        else {
            int tmp = 6 - pin1 - pin2;
            haino_tower(count_disk-1, pin1, tmp);
            System.out.printf("Переложить диск %d с %d стержня на %d стержень.\n",count_disk, pin1, pin2);
            haino_tower(count_disk-1, tmp, pin2);
        }
     }
    public static void main(String[] args) {
        haino_tower(3, 1, 2);
    }
}
