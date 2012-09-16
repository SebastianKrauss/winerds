package de.uniba.wiai.dsg.ss12.ajp.assignment4.literature.logic.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Cover {

	@XmlEnumValue("hard")
	HARD_COVER,

	@XmlEnumValue("soft")
	SOFT_COVER;

}
