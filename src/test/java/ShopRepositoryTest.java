import org.example.AlreadyExistsException;
import org.example.NotFoundException;
import org.example.Product;
import org.example.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "book", 500);
        Product product2 = new Product(2, "cup", 200);
        Product product3 = new Product(3, "pen", 50);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "book", 500);
        Product product2 = new Product(2, "cup", 200);
        Product product3 = new Product(3, "pen", 50);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(4)
        );
    }

    @Test
    public void shouldAddWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "book", 500);
        Product product2 = new Product(2, "cup", 200);
        Product product3 = new Product(3, "pen", 50);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "book", 500);
        Product product2 = new Product(2, "cup", 200);
        Product product3 = new Product(2, "cup", 200);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class,
                () -> repo.add(product2)
        );
    }
}
