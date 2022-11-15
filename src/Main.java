import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Satır sayısını giriniz: ");
        int r = input.nextInt();
        System.out.print("Sütun sayısını giriniz: ");
        int c = input.nextInt();
        MineSweeper game = new MineSweeper(r,c);
        game.Run();
    }
}
