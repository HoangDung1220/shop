package com.laptrinhjavaweb.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;


public class FormUtil {
	public static <T> T toModel(Class<T> tClass, HttpServletRequest request ) {
		T object = null;
		try {
			object = tClass.newInstance();
			try {
				BeanUtils.populate(object, request.getParameterMap());
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return object;
	}

}
