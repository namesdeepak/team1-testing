package test.tracking.pojo;

import java.util.ArrayList;

public class Card {

	String title;
	String desc;
	String priority;
	String type;
	String stage;
	String load = "1";
	

	
	public Card(String title, String desc, String priority, String type, String stage, String load) {
		this.title = title;
		this.desc = desc;
		this.priority = priority;
		this.type = type;
		this.stage = stage;
		this.load = load;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDesc() {
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	public String getPriority() {
		return priority;
	}



	public void setPriority(String priority) {
		this.priority = priority;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getStage() {
		return stage;
	}



	public void setStage(String stage) {
		this.stage = stage;
	}



	public String getLoad() {
		return load;
	}



	public void setLoad(String load) {
		this.load = load;
	}

}
