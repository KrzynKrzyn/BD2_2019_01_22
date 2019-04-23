package com.bd2.app;

import java.util.List;

public class Summary {

	public static class Pair<T>
	{
		private long id;
		private T value;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public T getValue() {
			return value;
		}
		public void setValue(T value) {
			this.value = value;
		}
		
	}
	
	public static class Driver
	{
		private long id;
		
		private String name;
		private String surname;

		private List<String> permissions;
		public List<String> getPermissions() {
			return permissions;
		}
		public void setPermissions(List<String> permissions) {
			this.permissions = permissions;
		}
		private long box_ontime;
		private long box_notontime;
		private long box_weight;
		private long work_hours;
		private long work_kilometers;
		private long avg_speed;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public long getBox_ontime() {
			return box_ontime;
		}
		public void setBox_ontime(long box_ontime) {
			this.box_ontime = box_ontime;
		}
		public long getBox_notontime() {
			return box_notontime;
		}
		public void setBox_notontime(long box_notontime) {
			this.box_notontime = box_notontime;
		}
		public long getBox_weight() {
			return box_weight;
		}
		public void setBox_weight(long box_weight) {
			this.box_weight = box_weight;
		}
		public long getWork_hours() {
			return work_hours;
		}
		public void setWork_hours(long work_hours) {
			this.work_hours = work_hours;
		}
		public long getWork_kilometers() {
			return work_kilometers;
		}
		public void setWork_kilometers(long work_kilometers) {
			this.work_kilometers = work_kilometers;
		}
		public long getAvg_speed() {
			return avg_speed;
		}
		public void setAvg_speed(long avg_speed) {
			this.avg_speed = avg_speed;
		}
		
	}
	
	public static class Road
	{
		
	}
	
}
