package com.xxy.intelligentpapersearch.node;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * Created by xiongxiaoyu
 * Data:2018/10/24
 * Time:22:50
 */

@NodeEntity
@Data
public class Paper extends BaseEntity {

	@GraphId
	private Long id;
	private String  name;
	private String  doi;
	private String  document_id;
	private String  publisher;
	private String  publication_date;
	private String  summary;
	private String  introduce;

	@Relationship(type = "classify")
	@JsonProperty("归类")
	private List<Genre> genres;

	@Relationship(type = "participate")
	@JsonProperty("参加")
	private List<Meeting> meetings;

	@Relationship(type = "attribute")
	@JsonProperty("属于")
	private List<Keyword> keywords;

	@Override
	public String toString() {
		return "{" +
				"\n name:" + name +
				"\n doi:" + doi +
				"\n document_id:" + document_id +
				"\n publisher:" + publisher +
				"\n publication_date:" + publication_date +
				"\n summary:" + summary +
				"\n introduce:" + introduce +
				"\n }";
	}


}
