package uk.com.devgrid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;

public class AppTest {
	/*@Test
	public void testCorrectAnswer() {
		Contestant contest = new Contestant(1);
		int problem = 2;
		int time = 21;
		String letter = "C";

		Contestant result = App.checkLetter(contest, problem, time, letter);
		assertEquals(1, result.getProblemsSolved().cardinality());
		assertTrue(result.getProblemsSolved().get(problem));
		assertEquals(21, result.getPenaltyTime());

	}

	@Test
	public void testIncorrectAnswer() {
		Contestant contest = new Contestant(1);
		int problem = 2;
		int time = 21;
		String letter = "I";

		Contestant result = App.checkLetter(contest, problem, time, letter);
		assertEquals(0, result.getProblemsSolved().cardinality());
		assertFalse(result.getProblemsSolved().get(problem));
		assertEquals(20, result.getPenaltyTime());

	}

	@Test
	public void testConvertMap() {
		Map<Integer, Contestant> map = new HashMap<>();
		Contestant a = new Contestant(1);
		Contestant b = new Contestant(2);
		Contestant c = new Contestant(3);
		b.addProblemSolved(1);
		b.addProblemSolved(2);

		a.addProblemSolved(1);

		map.put(1, a);
		map.put(2, b);
		map.put(3, c);

		List<Contestant> result = App.convertMap(map);
		assertEquals(b, result.get(0));
		assertEquals(a, result.get(1));
		assertEquals(c, result.get(2));
	}

	@Test
	public void testNewContestantSubmission() {
		Map<Integer, Contestant> map = mock(HashMap.class);
		String input = "1 2 3 R";
		when(map.containsKey(any())).thenReturn(false);

		Contestant result = App.processCases(map, input);
		assertNull(result);
	}

	@Test
	public void testOldContestantSubmission() {
		Map<Integer, Contestant> map = mock(HashMap.class);
		Contestant a = new Contestant(1);
		when(map.containsKey(any())).thenReturn(true);
		when(map.get(any())).thenReturn(a);

		String input = "1 2 3 R";

		Contestant result = App.processCases(map, input);
		assertEquals(a, result);
	}*/
}
