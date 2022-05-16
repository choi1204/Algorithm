package algorithm;

public class Something {
    static final int ZERO = 0;
    static final int ONE = 1;

    static final int A = 0;
    static final int B = 1;

    final int number;
    final int word;

    public Something(int number, int word) {
        this.number = number;
        this.word = word;
    }


    public static void main(String[] args) {
        Something something = new Something(Something.ZERO, Something.A);
        int number = something.number;
        float word = something.word;

        System.out.println(number == word);  //true

    }
}
