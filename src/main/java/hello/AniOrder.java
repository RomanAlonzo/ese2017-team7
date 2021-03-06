package hello;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*The object used to create the object table in the database. "Object" is a reserved keyword in SQL, so AniOrder is used as a 
 * combination of order and aniTrans.
 */
@Entity // This tells Hibernate to make a table out of this class
public class AniOrder {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	@OneToOne
	public Address fromAddr;
	@OneToOne
	private Address toAddr;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy.mmmm.dd")
	private Date until;
	private String timeframe;
	private String typeOfAnimal;
	private Integer numberOfAnimals;
	private String timeEstimation;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-mm-dd'T'HH:mm")
	private Date startTime;
	private String driver;
	private String orderStatus = "undelivered";
	private String statusMessage = "";
	@Autowired
	
	public AniOrder(NewOrder order, Address fromAddressId, Address toAddressId) {
		setId(order.getOrderId());
		setFromAddr(fromAddressId);
		setToAddr(toAddressId);
		setUntil(order.getUntil());
		setTimeframe(order.getTimeframe());
		setNumberOfAnimals(order.getNumberOfAnimals());
		setTypeOfAnimal(order.getTypeOfAnimal());
		setTimeEstimation(order.getTimeEstimation());
		setStartTime(order.getStartTime());
		setDriver(order.getDriver());
		setOrderStatus(order.getOrderStatus());
		setStatusMessage(order.getStatusMessage());	
	}
	
	public AniOrder() {
		
	}
	

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getFromAddr() {
        return fromAddr;
    }

    public void setFromAddr(Address fromAddr) {
        this.fromAddr = fromAddr;
    }
    
    public Address getToAddr() {
        return toAddr;
    }

    public void setToAddr(Address toAddr) {
        this.toAddr = toAddr;
    }
    
    public Date getUntil() {
        return until;
    }

    public void setUntil(Date until) {
        this.until = until;
    }
    
    public String getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }
    
    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public void setTypeOfAnimal(String typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }
    
    public Integer getNumberOfAnimals() {
        return numberOfAnimals;
    }

    public void setNumberOfAnimals(Integer numberOfAnimals) {
        this.numberOfAnimals = numberOfAnimals;
    }
    
    public String getTimeEstimation() {
        return timeEstimation;
    }

    public void setTimeEstimation(String timeEstimation) {
        this.timeEstimation = timeEstimation;
    }
    
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
  
    

}