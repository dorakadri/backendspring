package tn.esprit.khaddempro.modals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResponseData {
	private String name;
	private String url;
	private String type;
	private long size;
}