package com.apo;

import com.apo.PatronBuilder.dto.Employee;
import com.apo.PatronPrototype.impl.PriceListImpl;
import com.apo.PatronPrototype.impl.ProductItem;
import com.apo.PatronPrototype.impl.PrototypeFactory;

public class App {
    public static void main(String[] args) {
        // Patron Prototype

        // Creamos la lista de precios inicial, esta tiene los productos con el precio
        // de lista
        PriceListImpl standarPriceList = new PriceListImpl("Standar Price List");
        for (int i = 1; i <= 5; i++) {
            ProductItem item = new ProductItem("Product " + i, i * 2);
            standarPriceList.addProductItem(item);
        }

        PrototypeFactory.addPrototype(standarPriceList.getListName(), standarPriceList);

        // Segunda lista para clientes de mayoreo a partir de la lista estandar con un
        // 10% de descuento sobre la lista de precio estandar

        PriceListImpl wholesalePriceList = (PriceListImpl) PrototypeFactory.getPrototype("Standar Price List");
        wholesalePriceList.setListName("Wholesale Price List");
        for (ProductItem item : wholesalePriceList.getProducts()) {
            item.setPrice(item.getPrice() * 0.90);
        }

        PrototypeFactory.addPrototype(wholesalePriceList.getListName(), wholesalePriceList);

        // Tercera lista de precios para clientes VIP a partir de la lista de mayoreo
        // con un 10% de descuento sobre la lista de precios de mayoreo

        PriceListImpl vipPriceList = (PriceListImpl) PrototypeFactory.getPrototype("Wholesale Price List");
        vipPriceList.setListName("VIP Price List");
        for (ProductItem item : vipPriceList.getProducts()) {
            item.setPrice(item.getPrice() * 0.90);
        }

        // Imprimimos las listas de precios

        System.out.println(standarPriceList);
        System.out.println(wholesalePriceList);
        System.out.println(vipPriceList);

    }
}
