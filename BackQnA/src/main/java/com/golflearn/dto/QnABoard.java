package com.golflearn.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor 
@Setter @Getter 
@EqualsAndHashCode(of= {"qnaBoardNo"})

@Entity
@Table(name = "board_jpa")
@SequenceGenerator(name = "boardjpa_seq_generator",
					sequenceName = "board_jpa_seq",
					initialValue = 1,
					allocationSize = 1
					)

@DynamicInsert  
@DynamicUpdate
public class QnABoard {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
		 	generator = "qnaboard_seq_generator")
	@Column(name = "qna_board_no")
	private Long boardNo;
//	@ColumnDefault          
	@Column(name = "qna_board_title")
	private String boardTitle;
	
	@Column(name = "qna_board_content")
	private String boardContent;
	
	@JsonFormat(pattern = "yy/MM/dd", timezone ="Asia/Seoul")
	@Column(name = "qna_board_dt")                                             
	@ColumnDefault(value = "SYSDATE")
	private Date qnaBoardDt;
	
	@Column(name = "qna_board_secret")
	private int qnaBoardSecret;
	
	@OneToOne   
	@JoinColumn(name = "qna_board_no")
	private QnAComment comment;

}
