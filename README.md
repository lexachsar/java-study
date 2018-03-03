# NetCracker
Упростить булевскую функцию.

# Содержание

1. [BooleanSimplification;](#BooleanSimplification)
2. [PetShop;](#PetShop)
3. [Reflection.](#Reflection)

# Описание заданий
<a name="BooleanSimplification"><h2>BooleanSimplification</h2></a>
Package: com.lexach.Netcracker.BooleanSimplification

Упростить булевскую функцию.

<a name="PetShop"><h2>PetShop</h2></a>
Package: com.lexach.Netcracker.PetShop

Pet Shop
### Phase 1

#### Hierarchy and storage of Animals

[x] Построить иерархию животных в виде наследуемых классов.

[] Абстрактный класс AbstractAnimal имеет 4 поля:
1. protected String breed; // порода
2. protected String name; // имя
3. protected Integer cost; // цена в магазине
4. protected String character; // характер

[] Геттеры этих состояний вынесены в интерфейс Animal.

[] В конструкторе каждого конкретного типа животного происходит заполнение этих состояний случайными значениями (или предконфигуренными заранее)

[] Объекты конкретных животных хранятся в классе PetShopStorage(Singleton) в виде состояния List<Animal> animals;

#### Buy & Sell Service(Singleton)

[x] Класс синглтон с двумя методами:
1. void buy(Animal animal) - покупка магазином
2. void sell(Animal animal) - продажа покупателю
Которые производят операции над хранилищем животных PetShopStorage и выводят информацию об операции

#### Search Service(Singleton)

[x] Класс, предназначенный для поиска животных в хранилище по следующем признакам:
1. Порода
2. Имя
3. Цена
4. Характер

#### RealLifeEmulator(Singleton)

[x] Класс для эмулирования работы зоо-магазина, который эмулирует следующие операции
1. Покупка
2. Продажа
3. Побег животных

#### Дополнительно:

[] Придумать внутренние классы для классов животных для тренировки и повторения темы

[] Придумать, как осуществить поддержание синглтонов (использования в разных местах одного и того же объекта) без сохранения объекта в классе этого же объектаPhase 2

### Phase 2

#### Data Storing Job(Singleton)

[] Класс синглтон, предназначенный для сохранения всех животных в файл формата TXT/JSON

#### Printing Service(Singleton)

[x] Класс синглтон, предназначенный для печати информации о совершенных операциях (Buy & Sell)

#### Дополнительно

[] Реализовать сохранение животных в файл в отдельном потоке каждый 10 секунд

[] Добавить логику загрузки животных из файла при старте приложения

### Phase 3

#### Cleaning

В абстрактный класс AbstractAnimal добавляется новое поле вида:
protected Integer degreeOfPollution;
Которое означает степень загрязненности животного от 0 до 100%

[] Так же добавляется два синглтон класса PollutionJob и CleaningJob, которые в отдельных потоках осуществляют процесс загрязнения и очистки всех животных по  следующей логике
Раз в полсекунды каждое животное загрязняется или очищается на случайное количество единиц в диапазоне от 20 до 30

#### Lazy

[] Переписать класс PetShopStorage так, чтобы животные из файла загружались только при первом обращении к классу через метод getAnimals()

#### Дополнительно

[] Привести Code style вашего проекта в идеальное состояние

[x] Добавить java-doc к методам в ваших интерфейсах

### Tools (Additional part)

#### Phase 1

[] Java 8 (Использование Stream API и Лямбд в SearchService)

[] Maven (Система сборки и управления зависимостями)

[] Spring (Перенос ответственности создания объектов)

#### Phase 2

[] Java FX (Десктопный UI для более дружелюбного отображения)

[] JAX-B (Реализация возможности выводить информацию о животных в формате XML)

[] Logging (Залогировать основные моменты логики сервисов с помощью библиотеки log4j)

[] Security (Шифрование всех данных, записанных в файл шифром Цезаря :)

#### Phase What are u doin’ here, bruh?

[] Spring Boot (Веб сервер для реализации Web UI приложения)

[] JSP (использование обновляемых раз в секунду динамических страниц для отображения текущего состояния всех животных)

[] Rest (реализация внешнего API для получения состояния животных в сторонних Web приложениях)

<a name="Reflection"><h2>Reflection</h2></a>

Package: com.lexach.Netcracker.Reflection

[] Какие ограничения имеют аннотации?

[] Написать метод, который принимает класс и выводит в консоль методы этого класса и всех его предков

[] Написать свою аннотацию, пометить метод своего класса ей, дописать программу из 2 так чтобы перед помеченным методом был символ *

