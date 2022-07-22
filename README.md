## Примеры автотестов для онлайн калькулятора для вычисления факториала

Сайт для тестов доступен по ссылке <https://qainterview.pythonanywhere.com/>

### Настройка тестового окружения 
- Установлен веб-браузер Chrome
- Драйвер для веб-браузера Chrome скачен со страницы 
<https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers> 
и путь к директорий, где он сохранен, добавлен в переменную окружения PATH, 
чтобы драйвер был доступен из командной строки
- Установлен JDK 11 и /bin директория добавлена в переменную окружения PATH 
и команда java доступна из командной строки 
- Установлен Maven, и команда mvn доступна из командной строки
- Установлен Allure-commandline, и команда allure доступна из командной строки

### Как запустить тесты
1. Скачать проект
2. Из корневой директории проекта (_./factorial_calculator_testing_) выполнить команду
```
mvn clean test -Dbrowser=CHROME
```

### Как создать отчет о запуске тестов
3. Находясь в корневой директории проекта, выполнить команду
```
allure generate --clean --report-dir ./target/allure-report ./target/allure-results 
   && allure open --host localhost --port 8899 ./target/allure-report
```
4. Набрать Ctrl+C в консоли, чтобы остановить локальный веб-сервер с отчетом