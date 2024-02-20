import java.util.Scanner;

//=======игра=======
public class Game {
    public static Character manager;
    public static Story story;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int turn = 0;
        System.out.println("Вы прошли собеседование и вот-вот станете сотрудником Корпорации. \n "
                + "Осталось уладить формальности - подпись под договором (Введите ваше имя):");
        manager = new Character(in.next());
        story = new Story();
        while (true) {
            manager.A += story.current_situation.dA;
            manager.K += story.current_situation.dK;
            manager.R += story.current_situation.dR;
            System.out.println("=====\nКарьера:" + manager.K + "\tАктивы:"
                    + manager.A + "\tРепутация:" + manager.R + "\n=====");
            System.out.println("============="
                    + story.current_situation.subject + "==============");
            System.out.println(story.current_situation.text);
            turn += 1;
            if (story.isEnd(turn)) {
                System.out.println("====================the end!===================");
                return;
            }
            if(turn % 2 == 0){
                story.go(0, turn);
            }
            else{
                story.go(in.nextInt(), turn);
            }

        }
    }
}