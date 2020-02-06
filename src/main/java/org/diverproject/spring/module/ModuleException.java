package org.diverproject.spring.module;

import org.diverproject.scarlet.ScarletRuntimeException;

public class ModuleException extends ScarletRuntimeException
{
	private static final long serialVersionUID = 1826218859652612136L;

	public ModuleException(ModuleLanguage language)
	{
		super(language);
	}

	public ModuleException(ModuleLanguage language, Object... args)
	{
		super(language, args);
	}

	public ModuleException(Exception e)
	{
		super(e);
	}

	public ModuleException(Exception e, ModuleLanguage language)
	{
		super(e, language);
	}

	public ModuleException(Exception e, ModuleLanguage language, Object... args)
	{
		super(e, language, args);
	}
}
