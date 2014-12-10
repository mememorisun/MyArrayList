package mytest;

public class MyAssertion {

	public static void assertEquals(long expected, long actual) {
		if (expected != actual) {
			throw new AssertionError(
					"assertEquals(long expected, long actual) : expected = "
							+ expected + " , but actual = " + actual);
		}
	}

	public static void assertEquals(double expected, double actual, double delta) {
		if (Math.abs(expected - actual) > delta) {
			throw new AssertionError(
					"assertEquals(double expected, double actual, double delta) : expected = "
							+ expected + " , but actual = " + actual
							+ " , delta = " + delta);
		}
	}

	public static void assertTrue(boolean actual) {
		if (!actual) {
			throw new AssertionError("assertTrue(boolean actual) : actual = "
					+ actual);
		}
	}

	public static void assertFalse(boolean actual) {
		if (actual) {
			throw new AssertionError("assertFalse(boolean actual) : actual = "
					+ actual);
		}
	}

	public static void assertArrayEquals(double[] expecteds, double[] actuals,
			double delta) {
		boolean result = true;
		if (expecteds.length != actuals.length) {
			result = false;
		} else {
			for (int i = 0; i < expecteds.length; i++) {
				if (Math.abs(expecteds[i] - actuals[i]) > delta) {
					result = false;
					break;
				}
			}
		}

		if (!result) {
			throw new AssertionError(
					"assertArrayEquals(double[] expecteds, double[] actuals, double delta) : expecteds = "
							+ expecteds
							+ " , but actuals = "
							+ actuals
							+ " , delta = " + delta);
		}
	}

}
