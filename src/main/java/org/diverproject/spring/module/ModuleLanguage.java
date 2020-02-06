package org.diverproject.spring.module;

import org.diverproject.scarlet.language.Language;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ModuleLanguage implements Language
{
	PATCH_GET_FIELD_BY_NAME("proman.modules.utils.patch.fieldGet"),

	;

	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", Locale.ENGLISH);

	private final String setting;

	private ModuleLanguage(String setting)
	{
		this.setting = setting;
	}

	@Override
	public int getCode()
	{
		return this.ordinal();
	}

	@Override
	public String getFormat()
	{
		return resourceBundle.getString(this.setting);
	}

	@Override
	public void setFormat(String format)
	{
		throw new UnsupportedOperationException();
	}
}
