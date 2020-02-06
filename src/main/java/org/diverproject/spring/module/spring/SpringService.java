package org.diverproject.spring.module.spring;

import org.diverproject.spring.module.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SpringService
{
	@Autowired
	private ApplicationContext applicationContext;

	public <T> T getBeanByDatabase(Class<T> tClass, Database database)
	{
		return applicationContext.getBean(beanNameOf(tClass, database), tClass);
	}

	private <T> String beanNameOf(Class<T> tClass, Database database)
	{
		return String.format("%s%s", database.getName(), tClass.getSimpleName());
	}
}
