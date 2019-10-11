package uk.co.devgrid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import uk.co.devgrid.model.ContestantOld;

public class AppTest {
	@Test
	public void testCorrectAnswer() {
		ContestantOld contest = new ContestantOld(1);
		int problem = 2;
		int time = 21;
		String letter = "C";

		ContestantOld result = App.checkLetter(contest, problem, time, letter);
		assertEquals(1, result.getProblemsSolved().cardinality());
		assertTrue(result.getProblemsSolved().get(problem));
		assertEquals(21, result.getPenaltyTime());

	}

	@Test
	public void testIncorrectAnswer() {
		ContestantOld contest = new ContestantOld(1);
		int problem = 2;
		int time = 21;
		String letter = "I";

		ContestantOld result = App.checkLetter(contest, problem, time, letter);
		assertEquals(0, result.getProblemsSolved().cardinality());
		assertFalse(result.getProblemsSolved().get(problem));
		assertEquals(20, result.getPenaltyTime());

	}

	@Test
	public void testConvertMap() {
		Map<Integer, ContestantOld> map = new HashMap<>();
		ContestantOld a = new ContestantOld(1);
		ContestantOld b = new ContestantOld(2);
		ContestantOld c = new ContestantOld(3);
		b.addProblemSolved(1);
		b.addProblemSolved(2);

		a.addProblemSolved(1);

		map.put(1, a);
		map.put(2, b);
		map.put(3, c);

		List<ContestantOld> result = App.convertMap(map);
		assertEquals(b, result.get(0));
		assertEquals(a, result.get(1));
		assertEquals(c, result.get(2));
	}

	@Test
	public void testNewContestantSubmission() {
		Map<Integer, ContestantOld> map = mock(HashMap.class);
		String input = "1 2 3 R";
		when(map.containsKey(any())).thenReturn(false);

		ContestantOld result = App.processCases(map, input);
		assertNull(result);
	}

	@Test
	public void testOldContestantSubmission() {
		Map<Integer, ContestantOld> map = mock(HashMap.class);
		ContestantOld a = new ContestantOld(1);
		when(map.containsKey(any())).thenReturn(true);
		when(map.get(any())).thenReturn(a);

		String input = "1 2 3 R";

		ContestantOld result = App.processCases(map, input);
		assertEquals(a, result);
	}
}
