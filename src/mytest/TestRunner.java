package mytest;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import myarraylist.*;

public class TestRunner {

	public static void main(String[] args) {
		new TestRunner().run(new MyArrayListTest());
	}

	private void run(Object o) {

		myTestResult result = new myTestResult();

		for (Method m : o.getClass().getDeclaredMethods()) {
			try {
				m.setAccessible(true);
				for (Annotation a : m.getDeclaredAnnotations()) {
					if (a.annotationType().equals(Test.class)) {
						try {
							m.getAnnotation(Test.class).expected()
									.asSubclass(Exception.class);

							try {
								m.invoke(o);
								result.failure(m.getName(),"No Error : expected = "
										+ m.getAnnotation(Test.class)
												.expected().toString());
							} catch (InvocationTargetException e) {
								if (e.getTargetException()
										.getClass()
										.equals(m.getAnnotation(Test.class)
												.expected())) {
									result.success(m.getName(), e.getTargetException().toString());
								} else if (e.getTargetException().getClass()
										.equals(AssertionError.class)) {
									result.failure(m.getName(), e.getTargetException().toString());
								} else {
									result.error(m.getName(), e.getTargetException().toString());
								}
							} catch (Exception e) {
								result.error(m.getName(), e.toString());
							}

						} catch (Exception ex) {
							try {
								m.invoke(o);
								result.success(m.getName());
							} catch (InvocationTargetException e) {
								if (e.getTargetException().getClass()
										.equals(AssertionError.class)) {
									result.failure(m.getName(), e.getTargetException().toString());
								} else {
									result.error(m.getName(), e.getTargetException().toString());
								}
							} catch (Exception e) {
								result.error(m.getName(), e.toString());
							}
						}
					}

				}
			} catch (Exception e) {
				System.out.print(e.toString());
			}
		}

		result.show();
	}

	private class myTestResult {

		private int done;
		private int error;
		private int failure;

		private List<String> result;

		public myTestResult() {
			done = 0;
			error = 0;
			failure = 0;
			result = new ArrayList<String>();
		}

		private void done(String mn, String es, String state) {
			done++;
			result.add(mn + " : " + state + " : " + es);
		}

		private void done(String mn, String state) {
			done++;
			result.add(mn + " : " + state);
		}

		public void failure(String mn, String es) {
			failure++;
			done(mn, es, "FAILURE");
		}

		public void error(String mn, String es) {
			error++;
			done(mn, es, "ERROR");
		}

		public void success(String mn, String es) {
			done(mn, es, "SUCCESS");
		}

		public void success(String mn) {
			done(mn,"SUCCESS");
		}

		public void show() {
			System.out.println("Done : " + done + " , Error : " + error
					+ " , Failure : " + failure);
			Collections.sort(result);
			for (String s : result) {
				System.out.println(s);
			}
		}

	}
}
