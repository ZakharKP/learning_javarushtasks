package com.javarush.task.task23.task2309;

import java.util.List;

import com.javarush.task.task23.task2309.vo.Location;
import com.javarush.task.task23.task2309.vo.NamedItem;
import com.javarush.task.task23.task2309.vo.Server;
import com.javarush.task.task23.task2309.vo.Subject;
import com.javarush.task.task23.task2309.vo.Subscription;
import com.javarush.task.task23.task2309.vo.User;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		print(solution.getUsers());
		print(solution.getLocations());
		print(solution.getServers());
		print(solution.getSubjects());
		print(solution.getSubscriptions());
	}

	public static void print(List list) {
		String format = "Id=%d, name='%s', description=%s";
		for (Object obj : list) {
			NamedItem item = (NamedItem) obj;
			System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
		}
	}

	public List<User> getUsers() {

		return new AbstractDbSelectExecutor<User>() {
			@Override
			public String getQuery() {
				return "SELECT * FROM USER";
			}
		}.execute();
	}

	public List<Location> getLocations() {
		return new AbstractDbSelectExecutor<Location>() {
			@Override
			public String getQuery() {
				return "SELECT * FROM LOCATION";
			}
		}.execute();
	}

	public List<Server> getServers() {

		return new AbstractDbSelectExecutor<Server>() {
			@Override
			public String getQuery() {
				return "SELECT * FROM SERVER";
			}
		}.execute();
	}

	public List<Subject> getSubjects() {
		return new AbstractDbSelectExecutor<Subject>() {
			@Override
			public String getQuery() {
				return "SELECT * FROM SUBJECT";
			}
		}.execute();
	}

	public List<Subscription> getSubscriptions() {

		return new AbstractDbSelectExecutor<Subscription>() {
			@Override
			public String getQuery() {
				return "SELECT * FROM SUBSCRIPTION";
			}
		}.execute();
	}
}
