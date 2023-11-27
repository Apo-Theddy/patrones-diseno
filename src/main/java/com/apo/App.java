package com.apo;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.apo.PatronFactory.dao.ProductDAO;
import com.apo.PatronFactory.entity.Product;
import com.apo.PatronFactory.util.PropertiesUtil;

public class App {
    public static void main(String[] args) {

        Product productB = new Product(5L, "Product 5", 100);
        String message = "Seleccione la base de datos que desea usar\n1. Oracle\n2. MySQL\n3.SQLServer";
        String database = "MySQL";

        try {
            int option = Integer.parseInt(JOptionPane.showInputDialog(null, message));
            switch (option) {
                case 1 -> database = "Oracle";
                case 2 -> database = "MySQL";
                case 3 -> database = "SQLServer";
            }

            Properties prop = PropertiesUtil.loadProperty("META-INF/DBFactory.properties");
            saveNewProperty(prop, database);
            ProductDAO productDao = new ProductDAO();
            productDao.saveProduct(productB); /* Asignamos un nuevo valor a guardar */

            List<Product> products = productDao.findAllProducts(); /*
                                                                    * Obtener todos los registros tabla 'productos' de
                                                                    * nuestra base de datos
                                                                    */

            System.out.println("Product size ==> " + products.size()); /*
                                                                        * Obtener el tamanio de la lista de productos
                                                                        * que estan registrados en nuestra base de datos
                                                                        */

            for (Product product : products) { /* Recorremos toda nuestra lista con los registros de la base de datos */
                System.out.println(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void saveNewProperty(Properties prop, String database) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(
                PropertiesUtil.rootPath + "META-INF/DBFactory.properties");
        prop.setProperty("defaultDBClass", "com.apo.PatronFactory.impl." + database + "DBAdapter");
        prop.store(fileOutputStream, null);
        fileOutputStream.close();
    }

}
