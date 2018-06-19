# Код из лекции: [Евгений Борисов — Spring-потрошитель, часть 1](https://www.youtube.com/watch?v=BmBr5diz8WA)

# Bean Definition Reader

- Считывает из xml файла все декларации бинов, и кладет их в словарь BeanDefinitions. 

# Bean Factory

- На основе мапы BeanDefinitions создает из классов объекты и все бины складывает в контейнер IoC Container.

- Если бин является singleton, то он создается в момент, когда поднимается контекст по умолчанию и складывается в контейнер.

- Если бин является prototype, то он создается только в тот момент, когда он нужен и в контейнере не хранится, поэтому destroy-методы для prototype никогда не работают.

- В первую очередь создает те бины, которые имплементируют интерфейс BeanPostProcessor и потом с их помощью настраивает остальные бины.

- BeanFactory проходится по BeanPostProcessor-ам дважды:
    1. До init метода.
    2. После init метода.

# Bean Post Processor

- Позволяет настраивать бины до того, как они попали в IoC Container.

- Задействует паттерн "Цепочка обязанностей" (Chain of resonsobility)

- Те BeanPostProcessor-ы, которые в классе что-то меняют, они должны это делать на этапе postProcessAfterInitialization, а не на этапе post ProcessBeforeInitialization.
   
   - Тогда все остальные классы имеют доступ к аннотациям профилируемого класса.
   
   - Тогда @PostConstruct всегда работает на оригинальный метод. 


## Имеет два метода:

В каждый метод приходит bean и его имя.

### Object postProcessBeforeInitialization(Object bean, String beanName)

Вызывается до init метода

### Object postProcessAfterInitialization(Object bean, String beanName)

Вызывается после init метода

## Есть два способа создать класс, выполняющий профилирование.

1. (CjLib) Он должен наследоваться от оригинального класса и переопределять, добавляя нужную логику, его методы (считается хуже).

2. (Dynamic Proxy) Он должен имплементировать те же самые интерфейсы.



# init методы, двухфазовый конструктор

Переменная repeat на этапе вызова конструктора равна нулю, поскольку

1. Сначала объект создается Java.

2. Когда объект создан, Spring начинает его настраивать (в данном случае инжектить значение).

Поэтому чтобы в конструкторе обратиться к вещам, которые должен настроить Spring, необходимо использовать intit-метод (вторую фазу конструктора).

## Разные способы прописать:

- В xml файле через атрибут init-method в теге bean.

- С помощью аннотации @PostConstruct и активацию пост процессора CommonAnnotationBPP.

- (Для Spring 2) имплиментировать интерфейс InitialisingBean и прописать afterPropertiesSet. 

# Конвенция MBean

Чтобы все объекты, которые зарегистрированны в MBean Server можно было менять через JMX Console. 

- [Пример](quoters/ProfilingController.java)

1. Надо имплементировать интерфейс, который будет называться так же, как класс, но у него в конце будет MBean.

2. В этом интерфейсе указываем те методы, которые должны быть доступны через JMX Console.

# Трехфазовый конструктор

Вызывается, когда уже абсолютно все настроено и все proxy сгенерированы.

## ApplicationListener

- Умеет слушать Spring Context и отслеживать все евенты, которые с ним происходят, например:
   - SpringStartedEvent (контекст **начал** свое построение).
   - SpringStoppedEvent.
   - ContextRefreshedEvent.
      - Когда контекст заканчивает свое построение, он всегда делает ContextRefreshedEvent.

   
## Итоги

1. Java Constructor

2. @PostConstruct (BeanPostProcessor)

3. @AfterProxy (Context Listener)



# Советы

- При создании аннотации, используемой во время работы программы необходимо поменять RetentionPolicy на RUNTIME (по-умолчанию CLASS)

- При вызове метода getBean следует делать поиск не по классу, а по интерфейсу.