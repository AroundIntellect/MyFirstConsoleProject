import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
//С 1 по 5 строчки указываем какие библиотеки будут использоваться
public class SetNameAndSecondName { //Создаём отдельный класс, чтобы программа была понятнее
    static File FileMaleName = new File("MaleName.txt");
    static File FileFemaleName = new File("FemaleName.txt");
    static File FileNickName = new File("Nickname.txt");
    //С 8 по 10 строчки создаём переменные, через которые будем обращаться к файлам с именами


    static int colLine; //Создаём переменную для подсчёта количества не пустых строк
    static int i;       //Создаём переменную для заполнения массивов
    static String maleFile;
    static String femaleFile;
    static String nickFile;
    //С 14 по 16 строчки создаём необходимые переменные
    public static String name = "NoName";                       //Создаём переменную, в которую будет записано имя персонажа и записываем туда значение "NoName" для удобства
    public static void SetName() throws FileNotFoundException { //Создаём метод для записи имени
        Scanner maleScanner = new Scanner(FileMaleName);
        Scanner femaleScanner = new Scanner(FileFemaleName);
        Scanner nickScanner = new Scanner(FileNickName);
        //С 21 по 23 строчки создаём переменные, в которые получаем значения из файла(имена)

        colLine = 0;                                //Создаём переменную, которая будет считать количество не пустых строчек
        i = 0;
        while (maleScanner.hasNextLine()) {         //Пока в переменной есть следующая ещё неиспользованная строчка, делаем:
            maleFile = maleScanner.nextLine();      //В переменную maleFile построково записываем значения из переменной maleScanner
            if (!Objects.equals(maleFile, "")) { //Если полученная строка не пустая, то считаем её
                colLine++;
            }
        }
        maleScanner.close(); //Закрываем maleScanner, чтобы не загружать память

        maleScanner = new Scanner(FileMaleName); //Заново открываем файл с мужскими именами в переменную maleScanner
        String[] MaleName = new String[colLine]; //Создаём массив с мужскими именами, длиной colLine, в которой записаны не пустые строчки, иначе будет ошибка при проверке
        for (int i = 0; maleScanner.hasNextLine(); i++) {      //Пока в переменной есть следующая ещё неиспользованная строчка, делаем:
            maleFile = maleScanner.nextLine();   //В переменную maleFile построково записываем значения из переменной maleScanner
            if (maleFile.equals("")) {        //Пока записанная строчка пустая открываем следующую
                maleFile = maleScanner.nextLine();
            }
            MaleName[i] = maleFile;              //Записываем значение переменной maleFile в массив MaleName под индексом i
        }
        maleScanner.close();                     //Закрываем файл, чтобы не занимал память

        //С 49 по 67 строчки делаем то же самое, только для файла с женскими именами
        colLine = 0;
        while (femaleScanner.hasNextLine()) {
            femaleFile = femaleScanner.nextLine();
            if (!Objects.equals(femaleFile, "")) {
                colLine++;
            }
        }
        femaleScanner.close();

        femaleScanner = new Scanner(FileFemaleName);
        String[] FemaleName = new String[colLine];
        for (int i = 0; femaleScanner.hasNextLine(); i++) {
            femaleFile = femaleScanner.nextLine();
            if (femaleFile.equals("")) {
                femaleFile = femaleScanner.nextLine();
            }
            FemaleName[i] = femaleFile;
        }
        femaleScanner.close();

        //Так как в Nickname.txt данные записаны иным образом, то считывать их нужно иначе
        nickFile = nickScanner.nextLine();              //В этом файле всего одна строчка, поэтому получаем её в переменную nickFile
        String[] Nickname = nickFile.split(", "); //С помощью метода split записываем имена в массив Nickname, в аргументах указывая знак разделяющий имена
        nickScanner.close();                            //Закрываем nickScanner, чтобы не загружать память

        Scanner in = new Scanner(System.in); //Создаём сканер для ввода пользователя
        String tryThisName = in.nextLine();  //Создаём переменную tryThisName, в которую записываем введённое пользователем значение

        for (String x : MaleName) {          //При помощи метода foreach, который каждый раз по индексно присваивает переменной x значения из массива
            if (x.equals(tryThisName)) {     //Если значение в переменной x совпадает с тем, что ввёл пользователь, то
                name = tryThisName;          //Присваиваем переменной name введённое пользователем имя
                //break;
            }
        }
        if (name.equals("NoName")) {         //Если введённое пользователем имя не совпало ни с одним мужским именем, то проверяем женские по тому же алгоритму
            for (String x : FemaleName) {
                if (x.equals(tryThisName)) {
                    name = tryThisName;
                    //break;
                }
            }
        } if (name.equals("NoName")) {  //Если введённое пользователем имя не совпало ни с одним мужским и женским именем и в переменной name до сих пор хранится значение "NoName", то проверяем возможные прозвища
            for (String x : Nickname) {
                if (x.equals(tryThisName)) {
                    name = tryThisName;
                    //break;
                }
            }
        } if (name.equals("NoName")) {       //Если введённое пользователем имя не совпало ни с одним из возможных вариантов, то сообщаем пользователю об этом
            System.out.println();
            System.out.println("Ой-ой, рискну предположить, что ты ошибся в написании своего имени, с клавиатурой всегда так.. Но не переживай, ты можешь попробовать ещё раз!");
            System.out.println("Но, если ты на 100% уверен, что ошибки в написании имени нет, то могу констатировать факт:");
            System.out.println("К сожалению, такого имени я не знаю... Пожалуйста, не обижайся на меня, ведь ты всегда можешь использовать любое милое прозвище из списка чуть ниже <3");
            System.out.println(Arrays.toString(Nickname));
            SetName();                       //После вывода предупреждения о некорректности введённого пользователем имени заново запускаем метод SetName()
        }
    }
    public static String secondName;         //Создаём переменную, в которую будет записана фамилия пользователя
    public static void SetSecondName() {     //Создаём метод для записи фамилии пользователя
        System.out.println("Теперь, пожалуйста, напиши свою фамилию. Списка возможных фамилий нет, поэтому ты точно сможешь указать именно свою!");
        Scanner in = new Scanner(System.in); //Создаём сканер для ввода фамилии
        secondName = in.nextLine();          //Присваиваем переменной secondName введённую пользователем фамилию
    }
}
