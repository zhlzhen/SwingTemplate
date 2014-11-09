/*
 * ipassbook 0.6.0
 * Copyright (C)2009 wateray and contributors
 * wateray@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package baseui;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Action;

import org.apache.log4j.Logger;

import util.Log;

/**
 * @author wateray
 * @create 2009-4-29
 */
public class ActionManager {
	/**
	 * Common logger for actions
	 */
	private static Logger logger = Log.getLogger();

	/**
	 * Map of actions. All actions are singleton
	 */
	private static Map<Class<? extends Action>, Action> map = new HashMap<Class<? extends Action>, Action>();

	/**
	 * Returns an action object
	 * 
	 * @param clazz
	 * @return
	 */
	public static Action getAction(Class<? extends Action> clazz) {
		Action action = map.get(clazz);
		if (action == null) {
			try {
				action = clazz.newInstance();
				map.put(clazz, action);
			} catch (InstantiationException e) {
				logger.fatal(e.getMessage());
			} catch (IllegalAccessException e) {
				logger.fatal(e.getMessage());
			}
		}
		return action;
	}

	/**
	 * Method to log error from actions
	 * 
	 * @param obj
	 */
	protected static void error(Object obj) {
		logger.error(obj);
	}

	/**
	 * Enables or disables a group of actions
	 * 
	 * @param enable
	 * @param actions
	 */
	public static void setEnabledActions(boolean enable, Class<? extends Action>... actions) {
		for (Class<? extends Action> action : actions) {
			getAction(action).setEnabled(enable);
		}
	}
}
