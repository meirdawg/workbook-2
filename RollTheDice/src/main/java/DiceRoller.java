public class DiceRoller {
    public static void main(String[] args) {
        Dice dice = new Dice();
        int roll1, roll2;
        int twoCounter = 0, fourCounter = 0, sixCounter = 0, sevenCounter = 0;

        for (int i = 1; i <= 100; i++) {
            roll1 = dice.roll();
            roll2 = dice.roll();
            int sum = roll1 + roll2;




}
    }
