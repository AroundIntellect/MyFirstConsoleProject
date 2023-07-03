import java.io.FileNotFoundException;

public class StartGame {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Привет, Я текстовая игра! Сейчас я объясню, как в меня играть");
        System.out.println("Правила очень просты: Сперва читаешь реплику, которую тебе кто-то говорит, а затем отвечаешь");
        System.out.println("Отвечать очень просто, под текстом с фразой, которую тебе сказали есть варианты ответа с номерами");
        System.out.println("Твоя задача выбрать тот, который больше понравится и написать в консоль его номер");
        System.out.println("Однако учти, что в игре есть система кармы, которая будет влиять на концовку");
        System.out.println("Поэтому будь осторожен, при выборе ответа! На этом обучение окончено, желаю хорошей игры!");
        System.out.println("Осталось только узнать как к тебе можно обращаться и начать игру!");
        System.out.println();
        System.out.println("Для начала, пожалуйста, напиши своё настоящее имя в консоль, только не используй вариации своего имени, пожалуйста!");
        System.out.println("Например, моего создателя зовут Александр и это имя я знаю, однако любые его вариации, вроде 'Саня', 'Шурик' и тому подобные мне неизвестны!");


        SetNameAndSecondName.SetName();
        SetNameAndSecondName.SetSecondName();
        Game.Morning();
    }




    public static void FinishGame() {
        if (CheckAllAnswer.goodCarma > CheckAllAnswer.badCarma) {
            System.out.println("Это хорошая концовка, молодец!");
        } else {
            System.out.println("Это плохая концовка :(");
        }
        System.exit(0);
    }
}
