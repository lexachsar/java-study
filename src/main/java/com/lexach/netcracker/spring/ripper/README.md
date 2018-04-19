# Код из лекции: [Евгений Борисов — Spring-потрошитель, часть 1](https://www.youtube.com/watch?v=BmBr5diz8WA)

# Bean Definition Reader

- Считывает из xml файла все декларации бинов, и кладет их в словарь BeanDefinitions. 

# Bean Factory

- На основе мапы BeanDefinitions создает из классов объекты и все бины складывает в контейнер IoC Container.

- Если бин является singleton, то он создается в момент, когда поднимается контекст по умолчанию и складывается в контейнер.

- Если бин является prototype, то он создается только в тот момент, когда он нужен и в контейнере не хранится, поэтому destroy-методы для prototype никогда не работают.

# Bean Post Processor

- Позволяет настраивать бины до того, как они попали в IoC Container.

- Задействует паттерн "Цепочка обязанностей" (Chain of resonsobility)

### Имеет два метода:

В каждый метод приходит bean и его имя.

#### Object postProcessBeforeInitialization(Object bean, String beanName)

Вызывается до init метода

#### Object postProcessAfterInitialization(Object bean, String beanName)

Вызывается после init метода



# Советы

- При создании аннотации, используемой во время работы программы необходимо поменять RetentionPolicy на RUNTIME (по-умолчанию CLASS)

