# Test for Yandex

Тестовый проект для автоматизации REST API на примере публичного сервиса [Swagger Petstore](https://petstore.swagger.io/).

---

## 🧪 Технологии

- Java 21
- Maven
- [JUnit 5](https://junit.org/junit5/)
- [RestAssured](https://rest-assured.io/)
- [Jackson](https://github.com/FasterXML/jackson)
- [Lombok](https://projectlombok.org/)
- [Allure](https://docs.qameta.io/allure/)
- [SLF4J](http://www.slf4j.org) и [Logback](https://logback.qos.ch/)
- [DataFaker](https://github.com/datafaker-net/datafaker)

---

## ⚙️ Установка

### 1. Клонируй репозиторий
```bash
git clone https://github.com/your-username/petstore-api-tests.git
cd petstore-api-tests
````

### 2. Установи Java 21+, Maven, Allure (для просмотра отчетов)

### 3. Запуск тестов
- только тесты
```bash
mvn clean test
```
- тесты с отчетом в Allure
```bash
mvn clean test allure:serve
```

---

## 📁 Структура проекта
```
src
├── test
│   └── java
│       ├── checks            # Пользовательские проверки с логированием
│       ├── config            # Конфигурация из файла config.yaml
│       ├── data.provider.pet # Классы для создания тестовых объектов
│       ├── logging           # Пользовательский фильтр логирования для RestAssured
│       ├── models.pet        # Модели DTO (Pet, Category, Tag)
│       └── requests          # Методы API-запросов (POST, GET, PUT, DELETE)
│       └── tests             # JUnit тесты
└── resources
    └── config.yaml           # Файл конфигурации для тестов
    └── logback.xml           # Файл конфигурации для логирования
```

---

## 📌 Поддерживаемые HTTP-методы

Тестируются основные CRUD-операции:

| Метод | Endpoint           | Описание                       |
|-------|--------------------|--------------------------------|
| POST  | `/pet`             | Добавление нового питомца      |
| GET   | `/pet/{petId}`     | Получение питомца по ID        |
| PUT   | `/pet`             | Обновление информации о питомце|
| DELETE| `/pet/{petId}`     | Удаление питомца по ID         |

---

## 🧠 Особенности
- Генерация случайных тестовых данных через DataFaker
- Аннотации Allure для шагов и отчётов
- Логирование запросов RestAssured и результатов проверок
- Логирование уровня INFO в консоль и DEBUG в файл для отчета Allure

---

## ❗ Возможные проблемы
Тесты для методов GET и DELETE эндпоинта PET не стабильны. Возможная причина - скорость работы публичного тестового сервиса [Swagger Petstore](https://petstore.swagger.io/).