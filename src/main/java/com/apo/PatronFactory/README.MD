# PATRON FACTORY

Este patron nos permite la creacion de objetos de un subtipo, esto nos facilita la implementacion en tiempo de diseno de algun tipo que desconozcamos, ya que delegaremos la logica de creacion a la clase Factory, con este patron podremos crear instancias dinamicamente, su configuracion la podemos hacer mediante algun tipo de archivo de texto, XML, propierte o algun tipo de estrategia que usemos.

Este Patron se centra en los siguientes puntos:

```
Interfaz , Abstract Factory, ConcreteProduct, ConcreteFactory
```
```
1. ConcreteFactory __*extends*__ AbstractFactory
2. ConcreteFactory __*create*__ IProduct
3. ConcreteProduct __*extends*__ IProduct
```


![Factory Image](image.png)