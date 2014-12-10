//ArrayListのdouble版
package myarraylist;

public class MyArrayList {

	private class NullOrDouble {

		private double val = 0;
		private boolean isNull = true;

		public NullOrDouble() {
		}

		public NullOrDouble(double v) {
			val = v;
			isNull = false;
		}

		public double get() {
			return val;
		}

		public boolean isNull() {
			return isNull;
		}

		public void set(double v) {
			isNull = false;
			val = v;
		}

	}

	private final static int INIT_NUM = 10;

	private NullOrDouble[] list;

	private NullOrDouble[] ini(int l) {
		NullOrDouble[] re = new NullOrDouble[l];
		for (int i = 0; i < re.length; i++) {
			re[i] = new NullOrDouble();
		}
		return re;
	}

	public MyArrayList() {
		list = ini(INIT_NUM);
	}

	public MyArrayList(int i) {
		if (i >= 0) {
			list = ini(i);
		} else {
			throw new IllegalArgumentException();
		}
	}

	private NullOrDouble[] doub(NullOrDouble[] l) {
		NullOrDouble[] re = ini(l.length == 0 ? 1 : list.length * 2);
		for (int i = 0; i < l.length; i++) {
			if (!l[i].isNull()) {
				re[i] = new NullOrDouble(l[i].get());
			}
		}
		return re;
	}

	public int size() {
		int re = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].isNull()) {
				break;
			} else {
				re++;
			}
		}
		return re;
	}

	public double get(int i) {
		if (0 <= i && i < size() && !list[i].isNull()) {
			return list[i].get();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	public boolean contains(double v) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].get() == v)
				return true;
		}

		return false;
	}

	public int indexOf(double v) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].get() == v)
				return i;
		}

		return -1;
	}

	public int lastIndexOf(double v) {
		if (list.length == 0)
			return -1;

		for (int i = list.length - 1; i >= 0; i--) {
			if (list[i].get() == v)
				return i;
		}

		return -1;
	}

	public double[] toArray() {
		int len = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].isNull()) {
				break;
			} else {
				len++;
			}
		}

		double[] re = new double[len];
		for (int i = 0; i < len; i++) {
			if (list[i].isNull()) {
				break;
			} else {
				re[i] = list[i].get();
			}
		}
		return re;
	}

	public void set(int i, double v) {
		if (0 <= i && i < size() && !list[i].isNull()) {
			list[i].set(v);
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public void add(double v) {
		if (list.length == 0 || !list[list.length - 1].isNull()) {
			list = doub(list);
		}

		for (int i = 0; i < list.length; i++) {
			if (list[i].isNull()) {
				list[i].set(v);
				break;
			}
		}
	}

	public void add(int in, double v) {
		if (!(0 <= in && in < size() && !list[in].isNull())) {
			throw new IndexOutOfBoundsException();
		}

		if (list.length == 0 || !list[list.length - 1].isNull()) {
			list = doub(list);
		}

		NullOrDouble[] newList = ini(list.length + 1);

		boolean b = false;
		for (int i = 0; i < newList.length; i++) {
			if (i == in) {
				newList[i] = new NullOrDouble(v);
				b = true;
			} else if (b) {
				if (!list[i - 1].isNull()) {
					newList[i] = new NullOrDouble(list[i - 1].get());
				}
			} else {
				if (!list[i].isNull()) {
					newList[i] = new NullOrDouble(list[i].get());
				}
			}
		}
		list = newList;
	}

	public double remove(int in) {
		if (!(0 <= in && in < size() && !list[in].isNull())) {
			throw new IndexOutOfBoundsException();
		}

		double re = 0;
		NullOrDouble[] newList = ini(list.length - 1);

		boolean b = false;
		for (int i = 0; i < list.length; i++) {
			if (i == in) {
				re = list[i].get();
				b = true;
			} else if (b) {
				if (!list[i].isNull()) {
					newList[i - 1] = new NullOrDouble(list[i].get());
				}
			} else {
				if (!list[i].isNull()) {
					newList[i] = new NullOrDouble(list[i].get());
				}
			}
		}
		list = newList;
		return re;
	}

	public boolean remove(double v) {

		boolean re = false;

		NullOrDouble[] newList = ini(list.length);

		boolean b = false;
		for (int i = 0; i < list.length; i++) {
			if (list[i].get() == v && !b) {
				b = true;
				re = true;
			} else if (b) {
				if (!list[i].isNull()) {
					newList[i - 1] = new NullOrDouble(list[i].get());
				}
			} else {
				if (!list[i].isNull()) {
					newList[i] = new NullOrDouble(list[i].get());
				}
			}
		}
		list = newList;
		return re;
	}

	public void clear() {
		list = ini(0);
	}
}
