/*Base*/
package vn.easycredit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import vn.easycredit.domain.Utilities;

@Getter
@Setter
@MappedSuperclass
public class BaseInfoEntity {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = Utilities.MY_TIME_ZONE)
	@Column(name = "created_date")
	protected Date createdDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = Utilities.MY_TIME_ZONE)
	@Column(name = "updated_date")
	protected Date updatedDate;

	@Size(min = 0, max = 100)
	@Column(name = "user_created")
	protected String userCreated;
	
	@Size(min = 0, max = 100)
	@Column(name = "user_updated")
	protected String userUpdated;

	public BaseInfoEntity() {
		super();
		this.createdDate = new Date();
		this.updatedDate = new Date();
	}
	
}