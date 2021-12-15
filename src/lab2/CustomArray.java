package lab2;
import java.util.Scanner;

public class CustomArray {
    Scanner scanner;
    int[][] arr = new int[5][];
    static int[] length = new int[]{
            2,
            4,
            6,
            5,
            1
    };
    public CustomArray() {
        this.scanner = new Scanner(System.in);
    }

    public void Start() {
        this.Input();
        System.out.println("Исходная матрица: ");
        this.Print();
        this.Sort();
        System.out.println("Отсортированная матрица: ");
        this.Print();
    }

    private int InputElement(int i, int j) {
        i++;
        j++;
        System.out.println("Введите "+i+"x"+j+" элемент");
        while(!this.scanner.hasNextInt()) {
            System.out.println("Введите "+i+"x"+j+" элемент");
            this.scanner.next();
        }
        return this.scanner.nextInt();
    }

    public void Input() {
        this.arr = new int[5][];
        for(int i = 0; i < CustomArray.length.length; i++) {
            this.arr[i] = new int[CustomArray.length[i]];
            for(int j = 0; j < CustomArray.length[i]; j++) {
                this.arr[i][j] = this.InputElement(i,j);
            }
        }
    }

    public void Print() {
        for(int i = 0; i < this.arr.length; i++) {
            for(int j = 0; j < this.arr[i].length; j++) {
                int el = this.arr[i][j];
                System.out.print(el+" ");
            }
            System.out.print("0 ");
            System.out.println("");
        }
    }

    public void Sort() {
        int row = 5;
        int col = 6;
        for(int m = 0; m < (row * col - 1); m++) {
            for(int i = 0; i < row; i++) {
                for (int j = 0; j < CustomArray.length[i]; j++) {
                    if (j == CustomArray.length[i] - 1)
                        continue;
                    if (this.arr[i][j] > this.arr[i][j + 1]) {
                        int temp = this.arr[i][j];
                        this.arr[i][j] = this.arr[i][j + 1];
                        this.arr[i][j + 1] = temp;
                    }
                }
            }
        }
    }

    public int[] booble(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(i >= arr.length - 1)
                continue;
            if(arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        return arr;
    }
}
