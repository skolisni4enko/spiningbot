package ua.com.ligaspinig.spiningbot.config;

import org.springframework.stereotype.Component;

@Component
public class Constants {

    //Стартовый текст бота
    public static final String START_TEXT = "Привіт! \uD83D\uDE0A Я бот Ліги спінінгістів Херсону, який допоможе отримати результати турів та змазань загалом." +
            "Якщо по змаганнях нема питань, можна переглянути наш сайт:\n\n" +
            "<b><a href='https://ligaspining.com.ua'>Ліга Спінінгістів Херсону</a></b>\n\n\uD83C\uDF7B";

    //Пути к файлам туров соревнований. Внутри туров лежат зоны (A, B, C)
    public static final String EXCEL_TOUR1 = "..\\spinning\\src\\docsexcel\\По зонам ТУР1.xlsx";
    public static final String EXCEL_TOUR2 = "..\\spinning\\src\\docsexcel\\По зонам ТУР2.xlsx";
    public static final String EXCEL_TOUR3 = "..\\spinning\\src\\docsexcel\\По зонам ТУР3.xlsx";

    public static final String EXCEL_TOSS = "..\\spinning\\src\\docsexcel\\ЖЕРЕБ.xlsx";

    public static final String EXCEL_PERSONAL = "..\\spinning\\src\\docsexcel\\Особистий залік.xlsx";
    public static final String EXCEL_TEAM = "..\\spinning\\src\\docsexcel\\Командний залік.xlsx";

    //для кнопок
    public static final String BUTTON_STATISTIC = "Статистика";
    public static final String BUTTON_PERSONAL_FINISH = "Личка ИТОГ";
    public static final String BUTTON_TEAM_FINISH = "Команд.ИТОГ";
}
