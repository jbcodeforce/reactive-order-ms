package ibm.gse.eda.api;

import java.time.LocalDate;

public class Order {
    public String id;
    public String deliveryLocation;
    public Long quantity; 
    public LocalDate deliveryDate;
    public String status;
}