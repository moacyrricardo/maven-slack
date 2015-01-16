package br.com.kibutx.slackmavenplugin.api;

import java.io.Serializable;

import org.apache.maven.plugins.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Field implements Serializable {
		private static final long serialVersionUID = -2568313563058072257L;

		/**
		 * the value of this field
		 */
		@Parameter
//		@Parameter(property="value")
		private String value;
		
		@JsonProperty("short")
		@Parameter(alias="short", property="short")
		@JsonInclude(JsonInclude.Include.NON_NULL)
		private String shortValue;
		
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getShortValue() {
			return shortValue;
		}
		public void setShortValue(String shortValue) {
			this.shortValue = shortValue;
		}
	}