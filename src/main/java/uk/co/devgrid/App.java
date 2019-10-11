package uk.co.devgrid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import uk.co.devgrid.model.ContestantOld;

public class App {

	public static void down(String[] args) {

		Scanner scan = new Scanner(System.in);
		final List<List<ContestantOld>> result = new ArrayList<>();

		int cases = Integer.parseInt(scan.nextLine());
		String input;

		for (int i = 0; i < cases; i++) {
			final Map<Integer, ContestantOld> map = new HashMap<>();
			while ((input = scan.nextLine()).length() > 0) {
				processCases(map, input);
			}
			List<ContestantOld> mapConverted = convertMap(map);
			result.add(mapConverted);
		}
		printResult(result);
	}

	public static ContestantOld processCases(Map<Integer, ContestantOld> map, String input) {
		String[] submission = input.split(" ");
		int contestant = Integer.parseInt(submission[0]);
		int problem = Integer.parseInt(submission[1]);
		int time = Integer.parseInt(submission[2]);
		String letter = submission[3];

		if (map.containsKey(contestant)) {
			return checkLetter(map.get(contestant), problem, time, letter);
		} else {
			ContestantOld contest = new ContestantOld(contestant);
			return map.put(contestant, checkLetter(contest, problem, time, letter));
		}
	}

	public static ContestantOld checkLetter(ContestantOld contest, int problem, int time, String letter) {
		if (letter.equals("C")) {
			contest.addProblemSolved(problem);
			contest.addPenaltyTime(time);
		} else if (letter.equals("I")) {
			contest.addPenaltyTime(20);
		}
		return contest;
	}

	public static List<ContestantOld> convertMap(Map<Integer, ContestantOld> map) {
		List<ContestantOld> result = new ArrayList<>(map.values());
		map.clear();
		
		Collections.sort(result);
		return result;
	}

	public static void printResult(List<List<ContestantOld>> result) {
		result.forEach((temp) -> {
			temp.forEach(System.out::println);
			System.out.println();
		});
	}
}
