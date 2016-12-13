package tavonatti.stefano.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import introsde.document.dao.LifeCoachDao;


@Entity
@Table(name="measure")
public class Measure implements Comparable<Measure>{
	
	@Id // defines this attributed as the one that identifies the entity
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name="mid") // maps the following attribute to a column
    private int mid;
	
	@Column(name="value")
	private double measureValue;
	
	@Column(name="TYPE")
	private String measureType;
	
	@Temporal(TemporalType.TIMESTAMP) // defines the precision of the date attribute
    @Column(name="created")
    private Date dateRegistered;
	
	private String measureValueType;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@XmlTransient
	private HealthProfile  healthProfile;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public double getMeasureValue() {
		return measureValue;
	}

	public void setMeasureValue(double value) {
		this.measureValue = value;
	}


	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date created) {
		this.dateRegistered = created;
	}

	public String getMeasureType() {
		return measureType;
	}

	public void setMeasureType(String measureType) {
		this.measureType = measureType;
	}

	@XmlTransient
	public HealthProfile getHealthProfile() {
		return healthProfile;
	}

	public void setHealthProfile(HealthProfile healthProfile) {
		this.healthProfile = healthProfile;
	}
	
	public static Measure updateMeasure(Measure m){
		EntityManager em = LifeCoachDao.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        m=em.merge(m);
        tx.commit();
        LifeCoachDao.instance.closeConnections(em);
        return m;
	}
	
	public static Measure getMeasureById(int mid){
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		Measure m=em.find(Measure.class, mid);
		LifeCoachDao.instance.closeConnections(em);
		return m;	
	}

	public String getMeasureValueType() {
		return measureValueType;
	}

	public void setMeasureValueType(String measureValueType) {
		this.measureValueType = measureValueType;
	}

	@Override
	public int compareTo(Measure o) {
		if(o.getDateRegistered().getTime()>getDateRegistered().getTime())
			return 1;
		return -1;
	}


}
