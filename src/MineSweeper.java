import java.util.Random;
import java.util.Scanner;
public class MineSweeper {
    int row,column;
    String[][]matris;
    String[][] oyunMatrisi;
    Random random = new Random();
    Scanner input = new Scanner(System.in);
    MineSweeper(int row,int column){
        this.row = row;
        this.column = column;
        this.matris = new String[this.row][this.column];
        this.oyunMatrisi = new String[this.row][this.column];
    }
    void gameMap(){
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                this.oyunMatrisi[i][j] = "-";
            }
        }
    }
    void printGameMap(){
        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.column; j++){
                System.out.print(this.oyunMatrisi[i][j] +  " ");
            }
            System.out.println();
        }
    }

    void Run(){
        int hak = (this.row * this.column) - ((this.row * this.column)/4);
        gameMap();
        Mine();
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz");

        while(hak > 0) {
            int mineCounter = 0;

            System.out.println("===========================");
            System.out.println("Kalan Hamle Hakkınız : " + hak);
            display(oyunMatrisi);

            System.out.print("Satır Giriniz : ");
            int cRow = input.nextInt();

            System.out.print("Sütun Giriniz : ");
            int cCol = input.nextInt();
            if ((cRow < 0 || cRow >= this.row) || (cCol < 0 || cCol >= this.column)) {
                System.out.println("Hatalı Giriş Yaptınız, Lütfen doğru indis numarası giriniz !");
                continue;
            }
            else {
                if (this.matris[cRow][cCol].equals("*")) {
                    System.out.println("Game Over!!");
                    display(matris);
                    break;
                }
                if (!this.oyunMatrisi[cRow][cCol].equals("-")){
                    System.out.println("Bu hamleyi zaten yaptınız !");
                    continue;
                }
                else{
                    int minusRow = (cRow - 1), plusRow = (cRow + 1);
                    int minusCol = (cCol - 1), plusCol = (cCol + 1);

                    if ( (minusRow < 0) || (minusCol < 0) ){
                        minusRow = 0;
                        minusCol = 0;
                    }
                    if( (plusRow >= this.row) || (plusCol >= this.column) ){
                        plusRow = cRow;
                        plusCol = cCol;
                    }
                    for(int i = minusRow; i <= plusRow; i++){
                        for (int j = minusCol; j<= plusCol; j++){
                            if(this.matris[i][j].equals("*")){
                                mineCounter++;
                            }
                        }
                    }
                    String convertMineCounter = String.valueOf(mineCounter);
                    this.oyunMatrisi[cRow][cCol] = convertMineCounter;
                    hak--;
                }
            }
        }
        if(hak == 0){
            System.out.println("Oyunu Kazandınız  !");
            printGameMap();
        }
    }
    void Mine(){
        int mineNumber = (this.row * this.column)/4 ; // Mayın sayısının hesaplandığı kısım.
        for (int i=0; i<this.row;i++){
            for(int j=0; j<this.column;j++){
                this.matris[i][j] = "-";
            }
        }
        while(mineNumber > 0){ // Mayınların, oyun alanına rastgele eklendiği kısım.
            int x = random.nextInt(this.row);
            int y = random.nextInt(this.column);
            if (!this.matris[x][y].equals("*")){
                this.matris[x][y] = "*";
                mineNumber --;
            }
        }
    }
    void display(String[][] arr){
        for(int i = 0; i < this.row ;i++) {
            for (int j = 0; j < this.column; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
