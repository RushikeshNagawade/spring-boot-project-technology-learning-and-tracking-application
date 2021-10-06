package technology.learning.and.tracking.application.model;
import javax.persistence.*;

@Entity
@Table(name = "events")
public class EventEntity {
	
	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
 	
	@Column
	private String ename;
	
	@Column
	private String start_date;

	@Column
	private String end_date;

	public EventEntity() {
		super();
	}

	public EventEntity(String ename, String start_date, String end_date) {
		super();
		this.ename = ename;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public EventEntity(int eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}

	public EventEntity(String ename) {
		super();
		this.ename = ename;
	}

	public EventEntity(int eid, String ename, String start_date, String end_date) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "EventEntity [eid=" + eid + ", ename=" + ename + ", start_date=" + start_date + ", end_date=" + end_date
				+ "]";
	}
	
	
	

}
