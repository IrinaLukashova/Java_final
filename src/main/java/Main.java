import java.util.*;

//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//        Создать множество ноутбуков (Set).
//        Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
//        отвечающие фильтру. Критерии фильтрации можно хранить в любой удобной вам структуре данных(map, set, list, array). Например:
//        “Введите цифру, соответствующую необходимому критерию:
//        1 - ОЗУ
//        2 - Объем ЖД
//        3 - Операционная система
//        4 - Цвет …
//        Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
//        формат сдачи: ссылка на гит
public class Main {
    public static void main(String[] args) {
        LapTop mac1 = new LapTop(1, "macbookPRO", 180000, "ноутбук", "серебристый", "macOS");
        LapTop mac2 = new LapTop(2, "macbookAIR", 180000, "ноутбук", "серебристый", "macOS");
        LapTop wind1 = new LapTop(3, "acer", 87000, "ноутбук", "черный", "windows");

        Set<LapTop> laptops = new HashSet<>();
        laptops.add(mac1);
        laptops.add(mac2);
        laptops.add(wind1);

        FiltrList(laptops);
    }

    static void Filtr (Set<LapTop> laptops, Map<String, String> filtrs) {
        Set<LapTop> filtSet = new HashSet<>();
        for (LapTop laptop : laptops)
        {
            for (var key : filtrs.keySet()){
                if (key.equals("os")){
                    if (laptop.os.equals(filtrs.get(key))) filtSet.add(laptop);
                }
                if (key.equals("color")){
                    if (laptop.color.equals(filtrs.get(key))) filtSet.add(laptop);
                }
                if (key.equals("model")){
                    if (laptop.model.equals(filtrs.get(key))) filtSet.add(laptop);
                }
            }

        }
        System.out.println(filtSet);

    }

    static void FiltrList (Set<LapTop> laptops) {
        boolean i = true;
        Map<String, String> filtrs = new HashMap<>();
        while (i) {
            System.out.println("Выберете параметры для сортировки: \n 1. Операционная система;\n 2. Цвет; \n 3. Модель;");
            Scanner sc = new Scanner(System.in);
            String param = sc.next();

            System.out.printf("Выбран параметр %s, введите фильтр: ", param);
            Scanner sc1 = new Scanner(System.in);
            String filtr = sc1.next();

            if (param.equals("1")) {
                filtrs.put("os", filtr);
            }
            else if (param.equals("2")) {
                filtrs.put("color", filtr);
            }
            else if (param.equals("3")) {
                filtrs.put("model", filtr);
            }

            System.out.println("Хотите продолжить выбор параметров? (введите да или нет)");
            Scanner answer = new Scanner(System.in);
            String answ = answer.next();
            if (answ.equals("нет")) {
                i = false;
                Filtr(laptops, filtrs);
            }
        }
    }

}
