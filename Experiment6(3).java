//Pankaj(22bcs13842)
import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + price;
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("Phone", "Electronics", 800),
            new Product("Tablet", "Electronics", 600),
            new Product("Shirt", "Clothing", 50),
            new Product("Jeans", "Clothing", 70),
            new Product("Sofa", "Furniture", 300),
            new Product("Chair", "Furniture", 100)
        );

        // Group products by category
        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));

        // Find the most expensive product in each category
        Map<String, Product> mostExpensiveByCategory = products.stream()
            .collect(Collectors.toMap(
                p -> p.category,
                p -> p,
                (p1, p2) -> p1.price > p2.price ? p1 : p2
            ));

        // Calculate the average price of all products
        double averagePrice = products.stream()
            .mapToDouble(p -> p.price)
            .average()
            .orElse(0);

        // Display grouped products
        System.out.println("Products by Category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        // Display most expensive products by category
        System.out.println("\nMost Expensive Products by Category:");
        mostExpensiveByCategory.forEach((category, product) -> {
            System.out.println(category + ": " + product);
        });

        // Display average price
        System.out.println("\nAverage Price of All Products: $" + averagePrice);
    }
}
