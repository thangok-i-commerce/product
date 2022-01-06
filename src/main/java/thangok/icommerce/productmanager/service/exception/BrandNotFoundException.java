package thangok.icommerce.productmanager.service.exception;

public class BrandNotFoundException extends Exception {
    public BrandNotFoundException(String message) {
        super("Brand not found:" + message);
    }
}
