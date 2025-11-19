package org.example8927850.ecommerce.cart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // GET /cart → list all cart items
    @GetMapping
    public List<CartItem> getCartItems() {
        return cartService.getAllCartItems();
    }

    // POST /cart/add/{productId} → add item to cart
    @PostMapping("/add/{productId}")
    public ResponseEntity<CartItem> addToCart(@PathVariable Long productId) {
        CartItem item = cartService.addToCart(productId);
        return ResponseEntity.ok(item);
    }

    // DELETE /cart/{id} → remove a specific cart item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Long id) {
        cartService.removeCartItem(id);
        return ResponseEntity.noContent().build();
    }

    // DELETE /emptycart → remove all items
    @DeleteMapping("/emptycart")
    public ResponseEntity<Void> emptyCart() {
        cartService.emptyCart();
        return ResponseEntity.noContent().build();
    }
}
