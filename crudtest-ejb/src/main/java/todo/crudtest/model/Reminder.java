package todo.crudtest.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
public class Reminder implements Serializable {
    /** Default value included to remove warning. Remove or modify at will. **/
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 12)
    private String title;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 250)
    private String body;
    
    @Temporal(TemporalType.DATE)
    private Calendar lastModified = Calendar.getInstance();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Calendar getLastModified() {
		return lastModified;
	}

	public void setLastModified(Calendar date) {
		this.lastModified = date;
	}

	@Override
	public String toString() {
		return "Reminder [id=" + id + ", title=" + title + ", body=" + body + ", last modified=" + lastModified + "]";
	}
}
