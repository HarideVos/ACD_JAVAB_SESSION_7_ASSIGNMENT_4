package sevenpointfour;

public class SpinYourWords {

		static void sort(String[] arr, int size) {
			int c = arr.length - size;
			int position = -1;
			String min = null;

			for (int i = 0; i < size; i++) {
				if (min == null || arr[c + i].compareToIgnoreCase(min) < 0) {
					min = arr[c + i];
					position = c + i;
				}
			}

			if (position < 0)
				return;

			String tmp = arr[c];
			arr[c] = arr[position];
			arr[position] = tmp;
			sort(arr, size - 1);
		}

		public static void main(String[] args) {
			StringBuilder sb = new StringBuilder();

			String str = "listen, pot, part, opt, trap, silent, top, this, hello, hits, what";

			str.trim();
			String[] words = str.split(", ");

			for (String a : words) {
				String[] letters = a.toLowerCase().split("");
				sort(letters, letters.length);
				String key = "";
				for (String l : letters) {
					key += l;
				}
				int i = sb.indexOf(key);
				if (i > -1) {
					if (sb.indexOf(a) > -1)
						;
					else
						sb.insert(i + key.length() + 3, a + ", ");
				} else {
					sb.append(":" + key + ":{ " + a + " }");
				}
			}

			str = sb.toString();
			str = str.trim();
			str = str.replaceAll(":[a-zA-z]+:", "");
			str = str.replaceAll("\\{ [a-zA-z]+ \\}", "");

			System.out.println(str);
			sb.replace(0, sb.length(), "");
	}
}
