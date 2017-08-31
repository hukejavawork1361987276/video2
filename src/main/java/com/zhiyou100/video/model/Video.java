package com.zhiyou100.video.model;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

public class Video {
	
	private int id;
	private	int speaker_id;
	private	int course_id ;
	private	int video_play_times;
	private	String video_title;
	private	String video_image_url;
	private	String video_url ;
	private	String video_descr;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private	Timestamp  insert_time;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private	Timestamp update_time ;
	//private	Date update_time ;
	private int video_length;
	private	String speakerName;
	private	String courseName;
	private	String speaker_name;
	private	String course_name;
	private int  subject_id;
	private String subject_name;
	private String video_lengthStr;
	
	
	
	
	
	
	public String getVideo_lengthStr() {
		return video_lengthStr;
	}
	public void setVideo_lengthStr(String video_lengthStr) {
		this.video_lengthStr = video_lengthStr;
	}
	public String getSpeaker_name() {
		return speaker_name;
	}
	public void setSpeaker_name(String speaker_name) {
		this.speaker_name = speaker_name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	private Course course;
	private Speaker speaker;
	
	
	
	public int getVideo_length() {
		return video_length;
	}
	public void setVideo_length(int video_length) {
		this.video_length = video_length;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSpeaker_id() {
		return speaker_id;
	}
	public void setSpeaker_id(int speaker_id) {
		this.speaker_id = speaker_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getVideo_play_times() {
		return video_play_times;
	}
	public void setVideo_play_times(int video_play_times) {
		this.video_play_times = video_play_times;
	}
	public String getVideo_title() {
		return video_title;
	}
	public void setVideo_title(String video_title) {
		this.video_title = video_title;
	}
	public String getVideo_image_url() {
		return video_image_url;
	}
	public void setVideo_image_url(String video_image_url) {
		this.video_image_url = video_image_url;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	public String getVideo_descr() {
		return video_descr;
	}
	public void setVideo_descr(String video_descr) {
		this.video_descr = video_descr;
	}
	
	public Timestamp getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(Timestamp insert_time) {
		this.insert_time = insert_time;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	@Override
	public String toString() {
		return "Video [id=" + id + ", speaker_id=" + speaker_id + ", course_id=" + course_id + ", video_play_times="
				+ video_play_times + ", video_title=" + video_title + ", video_image_url=" + video_image_url
				+ ", video_url=" + video_url + ", video_descr=" + video_descr + ", insert_time=" + insert_time
				+ ", update_time=" + update_time + ", video_length=" + video_length + ", speakerName=" + speakerName
				+ ", courseName=" + courseName + ", subject_id=" + subject_id + ", subject_name=" + subject_name
				+ ", course=" + course + ", speaker=" + speaker + "]";
	}
	
	
	}
	
	
	
	
	
	

