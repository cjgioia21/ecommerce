package org.example8927850.ecommerce.cart;

import org.example8927850.ecommerce.product.Product;
import org.example8927850.ecommerce.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    // Get all cart items
    public List<CartItem> getAllCartItems() {
        return cartRepository.findAll();
    }

    // NEW: Add a product to cart using productId
    public CartItem addToCart(Long productId) {

        // Check if product exists
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));
        // Otherwise create a new cart item
        CartItem newItem = new CartItem();
        newItem.setProductId(product.getId());
        newItem.setProductName(product.getName());
        newItem.setPrice(product.getPrice());
        newItem.setQuantity(1);

        return cartRepository.save(newItem);
    }

    // Add manually (not used by controller anymore)
    public CartItem addCartItem(CartItem item) {
        return cartRepository.save(item);
    }

    // Remove a specific cart item
    public void removeCartItem(Long id) {
        cartRepository.deleteById(id);
    }

    // Empty the entire cart
    public void emptyCart() {
        cartRepository.deleteAll();
    }

    // Get a specific item
    public Optional<CartItem> getCartItemById(Long id) {
        return cartRepository.findById(id);
    }
}
