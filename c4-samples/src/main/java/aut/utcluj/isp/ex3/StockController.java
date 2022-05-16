package aut.utcluj.isp.ex3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockController {
    List<Product> products = new ArrayList<>();

    /**
     * Add product to catalogue
     *
     * @param product  - product information
     * @param quantity - number of times the product should be added
     * @apiNote: if products with the same products id already exists, assume that @param product has the same data
     */
    public void addProductToCatalogue(final Product product, final int quantity) {
        int k = quantity;
        if (products.contains(product)) {
            System.out.println("Product already exists");
        } else {
            while (k != 0) {
                products.add(product);
                k--;
            }
        }
    }

    /**
     * Return catalogue information
     *
     * @return dictionary where the key is the product id and the value is an array of products with the same id
     */
    public Map<String, List<Product>> getCatalogue() {
        Map<String, List<Product>> productMap = new HashMap<>();
        List<Product> productsWithSameId = new ArrayList<>();
        for (int j = 0; j < products.size(); j++) {
            int id = Integer.parseInt(products.get(j).getId());
            for (int i = 0; i < products.size(); i++) {

                if (Integer.parseInt(products.get(i).getId()) == id) {
                    productsWithSameId.add(products.get(i));
                }
                productMap.put(products.get(i).getId(), productsWithSameId);
            }
        }

        return productMap;
    }

    /**
     * Return all the products with particular id
     *
     * @param productId - unique product id
     * @return - list of existing products with same id or null if not found
     */
    public List<Product> getProductsWithSameId(final String productId) {
        List<Product> productsWithSameId = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(productId))
                productsWithSameId.add(products.get(i));
        }
        if (productsWithSameId.size() == 0)
            return null;
        else return productsWithSameId;
    }

    /**
     * Get total number of products from catalogue
     *
     * @return
     */
    public int getTotalNumberOfProducts() {
        return products.size();
    }

    /**
     * Remove all products with same product id
     *
     * @param productId - unique product id
     * @return true if at least one product was deleted or false instead
     */
    public boolean removeAllProductsWitProductId(final String productId) {
        int noProdDeleted = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(productId)) {
                noProdDeleted++;
                products.remove(products.get(i));
                i--;
            }
        }
        if (noProdDeleted != 0) return true;
        else return false;

    }

    /**
     * Update the price for all the products with same product id
     *
     * @param productId - unique product id
     * @param price     - new price to be added
     * @return true if at least one product was updated or false instead
     */
    public boolean updateProductPriceByProductId(final String productId, final Double price) {
        int noProdUpdated = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(productId)) {
                noProdUpdated++;
                products.get(i).setPrice(price);
            }
        }
        if (noProdUpdated != 0) return true;
        else return false;
    }
}
