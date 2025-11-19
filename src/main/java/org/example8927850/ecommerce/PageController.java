package org.example8927850.ecommerce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Product page
    @GetMapping("/product-page")
    public String productsPage() {
        return "product-page.html";
    }

    // Cart page
    @GetMapping("/cart-page")
    public String cartPage() {
        return "cart-page.html";
    }
}
