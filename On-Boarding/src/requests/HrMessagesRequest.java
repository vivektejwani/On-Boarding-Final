package requests;

import Entities.Group;
import Entities.HR;

public class HrMessagesRequest {

	private HR hr;
	private Group group;
	private int pageNumber;

	public HrMessagesRequest() {

	}

	public HrMessagesRequest(HR hr, Group group, int pageNumber) {
		super();
		this.hr = hr;
		this.group = group;
		this.pageNumber = pageNumber;
	}

	public HR getHr() {
		return hr;
	}

	public void setHr(HR hr) {
		this.hr = hr;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

}
