package responses;

import java.util.ArrayList;

import Entities.Group;
import Entities.Message;

public class MessagesResponse {

	private ArrayList<Group> groupsList;
	private ArrayList<Message> messagesList;

	public MessagesResponse() {

	}

	public MessagesResponse(ArrayList<Group> groupsList,
			ArrayList<Message> messagesList) {
		super();
		this.groupsList = groupsList;
		this.messagesList = messagesList;
	}

	public ArrayList<Group> getGroupsList() {
		return groupsList;
	}

	public void setGroupsList(ArrayList<Group> groupsList) {
		this.groupsList = groupsList;
	}

	public ArrayList<Message> getMessagesList() {
		return messagesList;
	}

	public void setMessagesList(ArrayList<Message> messagesList) {
		this.messagesList = messagesList;
	}

}
